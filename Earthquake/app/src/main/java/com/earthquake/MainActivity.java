package com.earthquake;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;


/*
* Main Activity class of the app that starts the main process of populating the ListView.
* onCreate() method will immediately start the background process of fetching data from the api
* and then the UI thread that will use the CustomAdapter to populate the ListView with the new data.
*/
public class MainActivity extends AppCompatActivity {

    public static ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView) findViewById(R.id.earthquake_list);

        // Creating on click listener for clicking on a list item
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Create Alert Dialog when list item is clicked
                AlertDialog.Builder adb = new AlertDialog.Builder(MainActivity.this);
                adb.setTitle("Earthquake Info:");

                // Inflate the view with the ImageView to show the magnitude picture
                LayoutInflater inflater = getLayoutInflater();
                View dialogLayout = inflater.inflate(R.layout.image_layout, null);
                adb.setView(dialogLayout);
                EarthquakeInfo ei = (EarthquakeInfo) parent.getItemAtPosition(position);
                adb.setPositiveButton("OK",null);
                AlertDialog dialog = adb.show();

                // Show the magnitude centered using the same image layout as the magnitude picture
                LinearLayout ll = (LinearLayout) dialog.findViewById(R.id.image_layout);
                TextView messageText = (TextView) ll.findViewById(R.id.dialog_mag);
                messageText.setGravity(Gravity.CENTER);
                messageText.setText("Magnitude: " + ei.getMagnitude());
                dialog.setView(messageText);
                dialog.show();
            }
        });

        // Start background process to fetch data from api
        FetchData process = new FetchData();
        process.execute();
    }



    /*
    * Class for creating background process to fetch data from api.
    * doInBackground() method will pull the data from the api and put into a list that will be later used to populate the ListView
    * onPostExecute() method will use the CustomAdapter class to populate the ListView with the data we pulled from the api
    */
    public class FetchData extends AsyncTask<Void, Void, Void> {

        String data = "";
        String json_url = "http://api.geonames.org/earthquakesJSON?formatted=true&north=44.1&south=-9.9&east=-22.4&west=55.2&username=mkoppelman";
        ArrayList<EarthquakeInfo> eqlist = new ArrayList<>();

        // Background thread for pulling info from api
        @Override
        protected Void doInBackground(Void... voids) {
            try {
                // Create connection from provided URL and read each line
                URL url = new URL(json_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String line = "";

                while (line != null){
                    line = bufferedReader.readLine();
                    data = data + line;
                }

                // Close input stream and disconnect url connection since we have read everything
                inputStream.close();
                httpURLConnection.disconnect();

                // Since the api will return a JSON array, we will go through that array and create JSON objects of each item
                JSONObject earthquakes = new JSONObject(data);
                JSONArray ja = earthquakes.getJSONArray("earthquakes");
                for (int i = 0; i < ja.length(); i++){
                    JSONObject jo = (JSONObject) ja.get(i);
                    EarthquakeInfo ei = new EarthquakeInfo();
                    ei.setId(jo.getString("eqid"));
                    ei.setMagnitude(jo.getDouble("magnitude"));
                    ei.setDate(jo.getString("datetime"));
                    ei.setDepth(jo.getString("depth"));
                    ei.setLongitude(jo.getString("lng"));
                    ei.setLatitude(jo.getString("lat"));
                    ei.setSource(jo.getString("src"));

                    eqlist.add(ei);
                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        // UI thread to populate ListView with the data from the api
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            // Populate item list with JSON objects we just fetched
            CustomAdapter adapter = new CustomAdapter(MainActivity.this, eqlist);
            MainActivity.lv.setAdapter(adapter);
        }
    }
}


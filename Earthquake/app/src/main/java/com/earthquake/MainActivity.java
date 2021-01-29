package com.earthquake;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
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
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    public static ListView lv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        lv = (ListView) findViewById(R.id.list_view);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder adb = new AlertDialog.Builder(MainActivity.this);
                adb.setTitle("Earthquake Info:");
                LayoutInflater inflater = getLayoutInflater();
                View dialogLayout = inflater.inflate(R.layout.image_layout, null);
                adb.setView(dialogLayout);
                EarthquakeInfo ei = (EarthquakeInfo) parent.getItemAtPosition(position);
                adb.setPositiveButton("OK",null);
                AlertDialog dialog = adb.show();

                LinearLayout ll = (LinearLayout) dialog.findViewById(R.id.image_layout);
                TextView messageText = (TextView) ll.findViewById(R.id.alert_message);
                messageText.setGravity(Gravity.CENTER);
                messageText.setText("Magnitude: " + ei.getMagnitude());
                dialog.setView(messageText);
                dialog.show();
            }
        });

        FetchData process = new FetchData();
        process.execute();
    }



    public class FetchData extends AsyncTask<Void, Void, Void> {

        String data = "";
        String json_url = "http://api.geonames.org/earthquakesJSON?formatted=true&north=44.1&south=-9.9&east=-22.4&west=55.2&username=mkoppelman";
        HttpURLConnection httpURLConnection;
        ArrayList<EarthquakeInfo> eqlist = new ArrayList<>();

        // Background thread
        @Override
        protected Void doInBackground(Void... voids) {
            try {
                URL url = new URL(json_url);
                httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader =new BufferedReader(new InputStreamReader(inputStream));
                String line = "";

                while (line != null){
                    line = bufferedReader.readLine();
                    data = data + line;
                }
                inputStream.close();

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

        // UI thread
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            CustomAdapter adapter = new CustomAdapter(MainActivity.this, eqlist);
            MainActivity.lv.setAdapter(adapter);
            httpURLConnection.disconnect();
        }
    }
}


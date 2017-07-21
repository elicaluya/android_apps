package edu.uoregon.ecaluya.tide_appv3;

import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * Created by elijahcaluya on 7/20/17.
 */

public class DisplayTides extends AppCompatActivity {

    String location;
    String date;
    String station_name;
    String station_id;
    String url_date;

    private Dal dal = new Dal(this);
    Cursor cursor = null;
    SimpleCursorAdapter adapter = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);



        location = getIntent().getExtras().getString("location");
        date = getIntent().getExtras().getString("date");
        url_date = getIntent().getExtras().getString("urlDate");
        station_name = getIntent().getExtras().getString("station");
        station_id = getIntent().getExtras().getString("stationID");

        Cursor check = dal.getPredictionByLocation(station_name,date);

        if (location.equals("Alameda, CA")) {
            if (!(check.moveToFirst()) || check.getCount() == 0)
                new RestTask().execute(station_id, url_date, "20171231");
            else {
                cursor = check;
                display();
            }
        } else if (location.equals("Monterey, CA")) {
            if (!(check.moveToFirst()) || check.getCount() == 0)
                new RestTask().execute(station_id, url_date, "20171231");
            else {
                cursor = check;
                display();
            }
        } else if (location.equals("San Leandro, CA")) {
            if (!(check.moveToFirst()) || check.getCount() == 0)
                new RestTask().execute(station_id, url_date, "20171231");
            else {
                cursor = check;
                display();
            }
        }
    }

    public void display() {
        adapter =new SimpleCursorAdapter(
                this,
                R.layout.list_view_items,
                cursor,
                new String[] {"Date", "Time", "Pred", "Type"},
            new int[]{R.id.date, R.id.time, R.id.pred, R.id.hl},0);

        ListView itemsListView = (ListView) findViewById(R.id.tideListView);
        itemsListView.setAdapter(adapter);
}



    // Nested Asynchronous Class
    public class RestTask extends AsyncTask<String, Void, TideItems> {
        private String station;
        private String startDate;
        private String endDate;


        @Override
        protected TideItems doInBackground(String... params) {
            String baseURL = "https://opendap.co-ops.nos.noaa.gov/axis/webservices/highlowtidepred/response.jsp?";
            station = params[0];
            startDate = params[1];
            endDate = params[2];
            String query = "stationId="+station+"&beginDate="+startDate+"&endDate="+endDate;
            String endQuery = "&datum=MLLW&unit=0&timeZone=0&format=xml&Submit=Submit";
            TideItems items = null;
            try{
                URL url = new URL(baseURL + query + endQuery);
                HttpURLConnection connection = (HttpURLConnection)url.openConnection();
                connection.setRequestProperty("User-Agent", "");
                connection.setRequestMethod("GET");
                connection.setDoInput(true);
                connection.connect();
                InputStream in = connection.getInputStream();
                if (in != null) {
                    items = dal.parseXmlStream(in);
                    items.setStationID(station);
                }
            }
            catch (Exception e){
                Log.e("Tide", "doInBackground error: " + e.getLocalizedMessage());
            }
            return items;
        }

        @Override
        protected void onPostExecute(TideItems items) {
            if (items != null && items.size() != 0) {
                dal.loadDbFromXML(items);
                cursor = dal.getPredictionByLocation(station_name,date);
                display();
            }
        }
    }
}

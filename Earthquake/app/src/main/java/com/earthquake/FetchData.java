package com.earthquake;

import android.os.AsyncTask;
import android.os.Build;

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

public class FetchData extends AsyncTask<Void, Void, Void> {

    String data = "";
    String dataParsed = "";
    String singleParsed = "";
    String json_url = "http://api.geonames.org/earthquakesJSON?formatted=true&north=44.1&south=-9.9&east=-22.4&west=55.2&username=mkoppelman";
    HttpURLConnection httpURLConnection;

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
            JSONObject earthquakes = new JSONObject(data);
            JSONArray ja = earthquakes.getJSONArray("earthquakes");
            for (int i = 0; i < ja.length(); i++){
                JSONObject jo = (JSONObject) ja.get(i);
                singleParsed = "ID: " + jo.get("eqid") + "\n" +
                            "Datetime: " + jo.get("datetime") + "\n" +
                            "Depth: " + jo.get("depth") + "\n" +
                            "Longitude: " + jo.get("lng") + "\n" +
                            "Latitude: " + jo.get("lat") + "\n" +
                            "Source: " + jo.get("src") + "\n" +
                            "Magnitude: " + jo.get("magnitude") + "\n\n";

                dataParsed = dataParsed + singleParsed;
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } finally {
            if (httpURLConnection != null)
                httpURLConnection.disconnect();
        }
        return null;
    }

    // UI thread
    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);


    }
}

package edu.uoregon.ecaluya.tide_appv2;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;


/**
 * Created by elijahcaluya on 7/16/17.
 */

public class DisplayTides extends AppCompatActivity{


    String location;
    String date;
    String station_name;

    private Dal dal = new Dal(this);
    Cursor cursor = null;
    SimpleCursorAdapter adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);

        location = getIntent().getExtras().getString("location");
        date = getIntent().getExtras().getString("date");
        station_name = getIntent().getExtras().getString("station");

        // Initialize database
        TideSQLiteHelper helper = new TideSQLiteHelper(this);
        SQLiteDatabase db = helper.getReadableDatabase();

        String query = "SELECT * FROM Tide_Predictions WHERE StationName = ?";
        String[] variables = new String[]{station_name};
        Cursor test = db.rawQuery(query,variables);



        if (location.equals("Alameda, CA")) {
            if (!(test.moveToFirst()) || test.getCount() == 0)
                db = dal.loadDbFromXML(db,"alameda.xml");
        }
        else if (location.equals("Florence, OR")) {
            if (!(test.moveToFirst()) || test.getCount() == 0)
                db = dal.loadDbFromXML(db,"florence.xml");
        }
        else if (location.equals("San Leandro, CA")) {
            if (!(test.moveToFirst()) || test.getCount() == 0)
                db = dal.loadDbFromXML(db,"san_leandro.xml");
        }

        cursor = dal.getPredictionByLocation(db,station_name,date);


        adapter = new SimpleCursorAdapter(
                this,
                R.layout.list_view_items,
                cursor,
                new String[]{"Date", "Day", "Time", "PredFt","HighLow"},
                new int[]{
                        R.id.date,
                        R.id.day,
                        R.id.time,
                        R.id.pred,
                        R.id.hl
                },
                0 );

        ListView itemsListView = (ListView)findViewById(R.id.tideListView);
        itemsListView.setAdapter(adapter);

        db.close();
    }
}

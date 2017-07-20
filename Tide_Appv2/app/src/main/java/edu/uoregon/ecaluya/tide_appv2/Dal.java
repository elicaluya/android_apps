package edu.uoregon.ecaluya.tide_appv2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import java.io.InputStream;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * Created by elijahcaluya on 7/16/17.
 */

public class Dal {

    private Context context = null;

    public Dal(Context context)
    {
        this.context = context;
    }

    // Parse the XML files and put the data in the db
    public SQLiteDatabase loadDbFromXML(SQLiteDatabase db, String fileName) {

        // Get the data from the XML file
        TideItems items = parseXmlFile(fileName);

        // Put weather forecast in the database
        ContentValues cv = new ContentValues();

        for (TideItem item : items) {

            cv.put("Date", item.getDate());
            cv.put("Day", item.getDay());
            cv.put("Time", item.getTime());
            cv.put("PredFt", item.getPred_in_ft());
            cv.put("PredCM", item.getPred_in_ft());
            cv.put("HighLow", item.getHighlow());
            cv.put("StationName", items.getStationName());
            db.insert("Tide_Predictions", null, cv);
        }

        //db.close();
        return db;
    }


    public Cursor getPredictionByLocation(SQLiteDatabase db, String location, String date)
    {
        String query = "SELECT * FROM Tide_Predictions WHERE StationName = ? AND Date = ?";
        String[] variables = new String[]{location,date};    // rawQuery must not include a trailing ';'
        return db.rawQuery(query, variables);
    }


    public TideItems parseXmlFile(String fileName) {
        try {
            // get the XML reader
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            XMLReader xmlreader = parser.getXMLReader();

            // set content handler
            ParseHandler handler = new ParseHandler();
            xmlreader.setContentHandler(handler);

            // read the file from internal storage
            InputStream in = context.getAssets().open(fileName);

            // parse the data
            InputSource is = new InputSource(in);
            xmlreader.parse(is);

            // set the feed in the activity
            TideItems items = handler.getItems();
            return items;
        }
        catch (Exception e) {
            Log.e("News reader", e.toString());
            return null;
        }
    }
}

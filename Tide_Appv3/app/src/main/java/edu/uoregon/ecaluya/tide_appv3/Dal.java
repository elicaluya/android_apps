package edu.uoregon.ecaluya.tide_appv3;

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
 * Created by elijahcaluya on 7/20/17.
 */

public class Dal {

    private Context context = null;

    public Dal(Context context)
    {
        this.context = context;
    }

    // Parse the XML files and put the data in the db
    public SQLiteDatabase loadDbFromXML(TideItems items) {

        TideSQLiteHelper helper = new TideSQLiteHelper(context);
        SQLiteDatabase db = helper.getWritableDatabase();

        // Put weather forecast in the database
        ContentValues cv = new ContentValues();

        for (TideItem item : items) {

            cv.put("Date", item.getDate());
            cv.put("Time", item.getTime());
            cv.put("Pred", item.getPred());
            cv.put("Type", item.getType());
            cv.put("StationName", items.getStationName());
            cv.put("StationID", items.getStationID());
            cv.put("Longitude", items.getLongitude());
            cv.put("Latitude", items.getLatitude());
            db.insert("Tide_Predictions", null, cv);
        }

        //db.close();
        return db;
    }


    public Cursor getPredictionByLocation(String location, String date)
    {
        TideSQLiteHelper helper = new TideSQLiteHelper(context);
        SQLiteDatabase db = helper.getWritableDatabase();

        String query = "SELECT * FROM Tide_Predictions WHERE StationName = ? AND Date = ?";
        String[] variables = new String[]{location,date};    // rawQuery must not include a trailing ';'
        return db.rawQuery(query, variables);
    }


    public TideItems parseXmlStream(InputStream in) {
        TideItems items = null;
        if (in != null) {
            try {
                // get the XML reader
                SAXParserFactory factory = SAXParserFactory.newInstance();
                SAXParser parser = factory.newSAXParser();
                XMLReader xmlreader = parser.getXMLReader();

                // set content handler
                ParseHandler handler = new ParseHandler();
                xmlreader.setContentHandler(handler);

                // parse the data
                InputSource is = new InputSource(in);
                xmlreader.parse(is);
                items = handler.getItems();
            } catch (Exception e) {
                Log.e("Tide", "parseXMLStream error: " + e.toString());
            }
        }
        return items;
    }
}

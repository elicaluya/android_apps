package edu.uoregon.ecaluya.tide_app;

import android.content.Context;
import android.util.Log;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import java.io.InputStream;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * Created by elijahcaluya on 7/14/17.
 */

public class FileIO {

    private final String fileName = "tide_predictions.xml";
    private Context context = null;

    public FileIO (Context context){
        this.context = context;
    }

    public TideItems readFile() {
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
            Log.e("NEWS READER", e.toString());
            return null;
        }
    }

}

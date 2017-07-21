package edu.uoregon.ecaluya.tide_appv3;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by elijahcaluya on 7/20/17.
 */

public class ParseHandler extends DefaultHandler{

    private TideItems items;
    private TideItem item;

    private boolean isDate = false;
    private boolean isTime = false;
    private boolean isPred = false;
    private boolean isType = false;
    private boolean isStationName = false;
    private boolean isStationID = false;
    private boolean isLatitude = false;
    private boolean isLongitude = false;
    private String date = null;


    public TideItems getItems(){
        return items;
    }

    @Override
    public void startDocument() throws SAXException {
        items = new TideItems();
        item = new TideItem();
    }

    @Override
    public void startElement(String namespaceURI, String localName,
                             String qName, Attributes atts) throws SAXException {


        if (qName.equals("data")){
            item = new TideItem();
            item.setDate(date);
            return;
        }
        else if (qName.equals("item")){
            date = atts.getValue(0);
            return;
        }
        else if (qName.equals("time")){
            isTime = true;
            return;
        }
        else if (qName.equals("pred")){
            isPred = true;
            return;
        }
        else if (qName.equals("type")){
            isType = true;
            return;
        }
        else if (qName.equals("stationName")){
            isStationName = true;
            return;
        }
        else if (qName.equals("stationId")){
            isStationID = true;
            return;
        }
        else if (qName.equals("latitude")){
            isLatitude = true;
            return;
        }
        else if (qName.equals("longitude")){
            isLongitude = true;
            return;
        }

    }

    @Override
    public void endElement(String namespaceURI, String localName,
                           String qName) throws SAXException
    {
        if (qName.equals("data")) {
            items.add(item);
        }
        return;
    }

    @Override
    public void characters(char ch[], int start, int length) {
        String s = new String(ch, start, length);

        if (isTime){
            item.setTime(s);
            isTime = false;
        }
        else if (isPred){
            item.setPred(s);
            isPred = false;
        }
        else if (isType){
            item.setType(s);
            isType = false;
        }
        else if (isStationName){
            items.setStationName(s);
            isStationName = false;
        }
        else if (isStationID){
            items.setStationID(s);
            isStationID = false;
        }
        else if (isLongitude){
            items.setLongitude(s);
            isLongitude = false;
        }
        else if (isLatitude){
            items.setLatitude(s);
            isLatitude = false;
        }
    }
}

package edu.uoregon.ecaluya.tide_appv2;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by elijahcaluya on 7/16/17.
 */

public class ParseHandler extends DefaultHandler {

    private TideItems items;
    private TideItem item;

    private boolean isDate = false;
    private boolean isDay = false;
    private boolean isTime = false;
    private boolean isPredInFt = false;
    private boolean isPredInCm = false;
    private boolean isHighLow = false;
    private boolean isStationName = false;

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


        if (qName.equals("item")){
            item = new TideItem();
            return;
        }
        else if (qName.equals("date")){
            isDate = true;
            return;
        }
        else if (qName.equals("day")){
            isDay = true;
            return;
        }
        else if (qName.equals("time")){
            isTime = true;
            return;
        }
        else if (qName.equals("pred_in_ft")){
            isPredInFt = true;
            return;
        }
        else if (qName.equals("pred_in_cm")){
            isPredInCm = true;
            return;
        }
        else if (qName.equals("highlow")){
            isHighLow = true;
            return;
        }
        else if (qName.equals("stationname")){
            isStationName = true;
            return;
        }

    }

    @Override
    public void endElement(String namespaceURI, String localName,
                           String qName) throws SAXException
    {
        if (qName.equals("item")) {
            items.add(item);
        }
        return;
    }

    @Override
    public void characters(char ch[], int start, int length) {
        String s = new String(ch, start, length);

        if (isDate){
            item.setDate(s);
            isDate = false;
        }
        else if (isDay){
            item.setDay(s);
            isDay = false;
        }
        else if (isTime){
            item.setTime(s);
            isTime = false;
        }
        else if (isPredInFt){
            item.setPredInFt(s);
            isPredInFt = false;
        }
        else if (isPredInCm){
            item.setPredInCm(s);
            isPredInCm = false;
        }
        else if (isHighLow){
            item.setHighLow(s);
            isHighLow = false;
        }
        else if (isStationName){
            items.setStationName(s);
            isStationName = false;
        }
    }
}

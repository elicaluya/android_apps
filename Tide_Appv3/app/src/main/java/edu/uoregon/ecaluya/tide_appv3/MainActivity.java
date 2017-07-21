package edu.uoregon.ecaluya.tide_appv3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener{

    Spinner locationSpinner;
    String location;
    DatePicker datePicker;
    String date;
    Button showTides;

    int day;
    int month;
    int year;
    String dayString;
    String monthString;
    String url_date;

    String monterey_station = "Monterey";
    String alameda_station = "Alameda";
    String san_leandro_station = "San Leandro Marina";
    String monterey_id = "9413450";
    String alameda_id = "9414750";
    String san_leandro_id = "9414688";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        locationSpinner = (Spinner)findViewById(R.id.location_spinner);
        datePicker = (DatePicker) findViewById(R.id.date_picker);
        showTides = (Button)findViewById(R.id.submit_button);

        locationSpinner.setOnItemSelectedListener(this);
        showTides.setOnClickListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (position){
            case 0:
                location = "Alameda, CA";
                break;
            case 1:
                location = "Monterey, CA";
                break;
            case 2:
                location = "San Leandro, CA";
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onClick(View v){
        if (v.getId() == R.id.submit_button){
            day = datePicker.getDayOfMonth();
            if (day < 10)
                dayString = "0" + Integer.toString(day);
            else
                dayString = Integer.toString(day);
            month = datePicker.getMonth() + 1;
            if (month < 10)
                monthString = "0" + Integer.toString(month);
            else
                monthString = Integer.toString(month);
            year = datePicker.getYear();
            date =   monthString + "/" + dayString + "/" + Integer.toString(year);
            url_date = Integer.toString(year) + monthString + dayString;


            Intent intent = new Intent(this,DisplayTides.class);
            // Add station specific data
            if (location.equals("Monterey, CA")){
                intent.putExtra("station", monterey_station);
                intent.putExtra("stationID",monterey_id);
            }

            else if (location.equals("Alameda, CA")){
                intent.putExtra("station", alameda_station);
                intent.putExtra("stationID",alameda_id);
            }

            else if (location.equals("San Leandro, CA")){
                intent.putExtra("station", san_leandro_station);
                intent.putExtra("stationID",san_leandro_id);
            }

            // Add other data
            intent.putExtra("location",location);
            intent.putExtra("date",date);
            intent.putExtra("urlDate",url_date);

            startActivity(intent);
        }
    }
}

package edu.uoregon.ecaluya.tide_appv2;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
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

    String florence_station = "Florence USCG Pier, Suislaw River";
    String alameda_station = "Alameda";
    String san_leandro_station = "San Leandro Marina";

    Boolean isFlorence = false;
    Boolean isAlameda = false;
    Boolean isSanLeandro = false;


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
                location = "Florence, OR";
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
            date = Integer.toString(year) + "/" + monthString + "/" + dayString;

            if (location.equals("Florence, OR"))
                isFlorence = true;
            else if (location.equals("Alameda, CA"))
                isAlameda = true;
            else if (location.equals("San Leandro, CA"))
                isSanLeandro = true;

            Intent intent = new Intent(this,DisplayTides.class);
            intent.putExtra("location",location);
            intent.putExtra("date",date);
            if (isFlorence)
                intent.putExtra("station",florence_station);
            else if (isAlameda)
                intent.putExtra("station",alameda_station);
            else if (isSanLeandro)
                intent.putExtra("station",san_leandro_station);
            startActivity(intent);
        }
    }
}

package edu.uoregon.ecaluya.sneaker_game;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by elijahcaluya on 7/23/17.
 */

public class AnswersActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    String brand = null;

    ImageView shoeImage;
    Spinner brandSpinner;
    Spinner shoeSpinner;

    ArrayList<Integer> id_adidas;
    ArrayList<Integer> id_jordan;
    ArrayList<Integer> id_nike;
    ArrayList<String> adidas;
    ArrayList<String> jordan;
    ArrayList<String> nike;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.answers_activity);

        shoeImage = (ImageView)findViewById(R.id.shoe_image);
        brandSpinner = (Spinner)findViewById(R.id.brand_spinner);
        shoeSpinner = (Spinner)findViewById(R.id.shoe_spinner);

        id_adidas = getIntent().getIntegerArrayListExtra("adidas ids");
        id_jordan = getIntent().getIntegerArrayListExtra("jordan ids");
        id_nike = getIntent().getIntegerArrayListExtra("nike ids");

        adidas = getIntent().getStringArrayListExtra("adidas shoes");
        jordan = getIntent().getStringArrayListExtra("jordan shoes");
        nike = getIntent().getStringArrayListExtra("nike shoes");
        brandSpinner.setOnItemSelectedListener(this);

        shoeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (brand.equals("Adidas"))
                    shoeImage.setImageResource(id_adidas.get(position));
                else if (brand.equals("Air Jordan"))
                    shoeImage.setImageResource(id_jordan.get(position));
                else if (brand.equals("Nike"))
                    shoeImage.setImageResource(id_nike.get(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                if (brand.equals("Adidas"))
                    shoeImage.setImageResource(id_adidas.get(0));
                else if (brand.equals("Air Jordan"))
                    shoeImage.setImageResource(id_jordan.get(0));
                else if (brand.equals("Nike"))
                    shoeImage.setImageResource(id_nike.get(0));
            }
        });

    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (position){
            case 0:
                brand = "Adidas";
                String[] adidas_shoes = getModelColorway(brand);
                shoeSpinner.setAdapter(new ArrayAdapter<String>(this,
                        android.R.layout.simple_spinner_item,adidas_shoes));
                break;
            case 1:
                brand = "Air Jordan";
                String[] jordan_shoes = getModelColorway(brand);
                shoeSpinner.setAdapter(new ArrayAdapter<String>(this,
                        android.R.layout.simple_spinner_item,jordan_shoes));
                break;
            case 2:
                brand = "Nike";
                String[] nike_shoes = getModelColorway(brand);
                shoeSpinner.setAdapter(new ArrayAdapter<String>(this,
                        android.R.layout.simple_spinner_item,nike_shoes));
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        brand = "Adidas";
    }

    public String[] getModelColorway(String brand){
        String[] array = null;
        if (brand.equals("Adidas")){
            array = new String[adidas.size()];
            for (int i = 0; i < adidas.size()-1;i++)
                array[i] = adidas.get(i);
        }
        else if (brand.equals("Air Jordan")){
            array = new String[jordan.size()];
            for (int i = 0; i < jordan.size()-1;i++)
                array[i] = jordan.get(i);
        }
        else if (brand.equals("Nike")){
            array = new String[nike.size()];
            for (int i = 0; i < nike.size()-1;i++)
                array[i] = nike.get(i);
        }
        return array;
    }
}

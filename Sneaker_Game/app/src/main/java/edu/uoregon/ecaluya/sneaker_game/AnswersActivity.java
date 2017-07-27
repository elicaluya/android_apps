package edu.uoregon.ecaluya.sneaker_game;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;

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
    TextView shoeText;
    Button upButton;
    Button downButton;

    String[] currentShoes = null;
    int index = 0;

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
        shoeText = (TextView)findViewById(R.id.shoe);
        upButton = (Button)findViewById(R.id.up_button);
        downButton = (Button)findViewById(R.id.down_button);


        id_adidas = getIntent().getIntegerArrayListExtra("adidas ids");
        id_jordan = getIntent().getIntegerArrayListExtra("jordan ids");
        id_nike = getIntent().getIntegerArrayListExtra("nike ids");

        adidas = getIntent().getStringArrayListExtra("adidas shoes");
        jordan = getIntent().getStringArrayListExtra("jordan shoes");
        nike = getIntent().getStringArrayListExtra("nike shoes");
        brandSpinner.setOnItemSelectedListener(this);

        upButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downButton.setEnabled(true);
                index++;
                displayShoe();
                if (index == currentShoes.length-1)
                    upButton.setEnabled(false);
            }
        });
        downButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                upButton.setEnabled(true);
                index--;
                displayShoe();
                if(index == 0)
                    downButton.setEnabled(false);
            }
        });

    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (position){
            case 0:
                brand = "Adidas";
                String[] adidas_shoes = getModelColorway(brand);
                currentShoes = adidas_shoes;
                index = 0;
                displayShoe();
                upButton.setEnabled(true);
                downButton.setEnabled(false);
                break;
            case 1:
                brand = "Air Jordan";
                String[] jordan_shoes = getModelColorway(brand);
                currentShoes = jordan_shoes;
                index = 0;
                displayShoe();
                upButton.setEnabled(true);
                downButton.setEnabled(false);
                break;
            case 2:
                brand = "Nike";
                String[] nike_shoes = getModelColorway(brand);
                currentShoes = nike_shoes;
                index = 0;
                displayShoe();
                upButton.setEnabled(true);
                downButton.setEnabled(false);
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
            for (int i = 0; i < adidas.size();i++)
                array[i] = adidas.get(i);
        }
        else if (brand.equals("Air Jordan")){
            array = new String[jordan.size()];
            for (int i = 0; i < jordan.size();i++)
                array[i] = jordan.get(i);
        }
        else if (brand.equals("Nike")){
            array = new String[nike.size()];
            for (int i = 0; i < nike.size();i++)
                array[i] = nike.get(i);
        }
        return array;
    }

    public void displayShoe(){
        if (brand.equals("Adidas")){
            shoeText.setText(currentShoes[index]);
            shoeImage.setImageResource(id_adidas.get(index));
        }
        else if (brand.equals("Air Jordan")) {
            shoeImage.setImageResource(id_jordan.get(index));
            shoeText.setText(currentShoes[index]);
        }
        else if (brand.equals("Nike")) {
            shoeImage.setImageResource(id_nike.get(index));
            shoeText.setText(currentShoes[index]);
        }
    }
}

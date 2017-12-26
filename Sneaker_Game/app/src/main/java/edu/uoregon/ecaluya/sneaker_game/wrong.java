package edu.uoregon.ecaluya.sneaker_game;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.TextView;

/**
 * Created by elica on 12/25/2017.
 */

public class wrong extends Activity{
    TextView model;
    TextView colorway;
    String shoe_model;
    String shoe_colorway;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wrong_popup);

        model = (TextView)findViewById(R.id.model_text);
        colorway = (TextView)findViewById(R.id.colorway_text);
        shoe_model = getIntent().getExtras().getString("shoeModel");
        shoe_colorway = getIntent().getExtras().getString("shoeColorway");
        model.setText(shoe_model);
        colorway.setText(shoe_colorway);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int)(width*.7),(int)(height*.7));
    }
}

package edu.uoregon.ecaluya.sneaker_game;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.Random;

/**
 * Created by elijahcaluya on 7/12/17.
 */

public class gameplayActivity extends AppCompatActivity {
    String brandName;
    int max;
    int[] array;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gameplay);

        brandName = getIntent().getExtras().getString("brand_name");
        int id = getIntent().getExtras().getInt("id");
        array = getIntent().getExtras().getIntArray("array");
        max = getIntent().getExtras().getInt("array_max");


        gameplayFragment gameplay = (gameplayFragment)getFragmentManager().findFragmentById(R.id.gameplay_fragment);
        gameplay.setBrandName(brandName,id);
    }

    public void nextShoe(View v){
        gameplayFragment gameplay = (gameplayFragment)getFragmentManager().findFragmentById(R.id.gameplay_fragment);
        if (brandName.equals("Adidas"))
            gameplay.pickRandShoe(v,max,array);
        else if (brandName.equals("Air Jordan"))
            gameplay.pickRandShoe(v,max,array);
        else if (brandName.equals("Nike"))
            gameplay.pickRandShoe(v,max,array);
    }

    public void submitAnswer(View v){
        gameplayFragment gameplay = (gameplayFragment)getFragmentManager().findFragmentById(R.id.gameplay_fragment);
        gameplay.submit(v);
    }

    public void resetGame(View v){
        gameplayFragment gameplay = (gameplayFragment)getFragmentManager().findFragmentById(R.id.gameplay_fragment);
        gameplay.reset(v,max,array);
    }
}

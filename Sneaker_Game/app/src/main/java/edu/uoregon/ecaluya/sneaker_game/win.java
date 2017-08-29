package edu.uoregon.ecaluya.sneaker_game;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.TextView;

/**
 * Created by elijahcaluya on 7/19/17.
 */

public class win extends Activity{

    TextView scoreNum;
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.win_popup);

        scoreNum = (TextView)findViewById(R.id.score_num);
        score = getIntent().getExtras().getInt("scoreNum");
        scoreNum.setText(Integer.toString(score));

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int)(width*.7),(int)(height*.7));
    }
}

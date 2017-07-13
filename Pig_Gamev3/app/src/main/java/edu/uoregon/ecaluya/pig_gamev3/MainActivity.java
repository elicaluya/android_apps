package edu.uoregon.ecaluya.pig_gamev3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String p1Name = getIntent().getExtras().getString("p1Name");
        String p2Name = getIntent().getExtras().getString("p2Name");
        Boolean lessScore = getIntent().getExtras().getBoolean("lessScore");
        Boolean moreScore = getIntent().getExtras().getBoolean("moreScore");
        Boolean rollCount = getIntent().getExtras().getBoolean("rollCount");
        Boolean totalRoll = getIntent().getExtras().getBoolean("totalRoll");

        MainActivityFragment mainActivityFragment = (MainActivityFragment)getFragmentManager()
                .findFragmentById(R.id.main_activity_fragment);

        mainActivityFragment.setLayout(p1Name,p2Name,totalRoll);
        mainActivityFragment.setRules(lessScore,moreScore,rollCount,totalRoll);
    }

    public void roll(View view){
        MainActivityFragment mainActivityFragment = (MainActivityFragment)getFragmentManager()
                .findFragmentById(R.id.main_activity_fragment);
        mainActivityFragment.roll_die(view);
    }
}

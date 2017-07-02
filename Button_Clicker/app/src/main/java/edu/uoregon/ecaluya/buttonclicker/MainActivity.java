package edu.uoregon.ecaluya.buttonclicker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnAdd;
    Button btnReset;
    TextView count;
    static final String count_num = "count number";
    private int mCount_num = 0;


    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        savedInstanceState.putInt(count_num,mCount_num);
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = (Button)findViewById(R.id.add);
        btnReset = (Button)findViewById(R.id.reset);
        count = (TextView)findViewById(R.id.count_number);

        if (savedInstanceState != null){
            mCount_num = savedInstanceState.getInt(count_num);
            count.setText(String.valueOf(mCount_num));
        }
        else {
            mCount_num = Integer.parseInt(count.getText().toString());
            count.setText(String.valueOf(mCount_num));
        }


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                mCount_num++;
                count.setText(String.valueOf(mCount_num));
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCount_num = 0;
                count.setText(String.valueOf(mCount_num));
            }
        });

    }
}

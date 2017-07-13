package edu.uoregon.ecaluya.pig_gamev3;

import android.app.Fragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * Created by elijahcaluya on 7/10/17.
 */

public class MenuFragment extends Fragment implements OnClickListener {

    EditText p1Name;
    EditText p2Name;
    Menu menu;

    SharedPreferences prefs;
    boolean lessScore = false;
    boolean lessScoreOn = false;
    boolean moreScore = false;
    boolean moreScoreOn = false;
    boolean rollCount = false;
    boolean rollCountOn = false;
    boolean totalRoll = false;
    boolean totalRollOn = false;

    // Display Menu in action bar
    @Override
    public void onCreateOptionsMenu(android.view.Menu menu, MenuInflater menuInflater){
        super.onCreateOptionsMenu(menu,menuInflater);
        menuInflater.inflate(R.menu.options_menu, menu);
    }

    // Actions for items in the menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.menu_settings:
                startActivity(new Intent(menu,SettingsActivity.class));
                return true;
            case R.id.menu_about:
                Toast.makeText(menu, "Pig Game v3 by Elijah Caluya",Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.menu_fragment,container,false);
        setHasOptionsMenu(true);
        Button newGame = (Button)view.findViewById(R.id.new_game);
        newGame.setOnClickListener(this);

        PreferenceManager.setDefaultValues(getActivity(),R.xml.preferences,false);
        prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

        menu = (Menu)getActivity();
        p1Name = (EditText)menu.findViewById(R.id.p1_name);
        p2Name = (EditText)menu.findViewById(R.id.p2_name);

    }

    @Override
    public void onClick(View v){
        if (v.getId() == R.id.new_game){
            String p1 = p1Name.getText().toString();
            String p2 = p2Name.getText().toString();
            Intent intent = new Intent(getActivity(), MainActivity.class);
            intent.putExtra("p1Name",p1);
            intent.putExtra("p2Name",p2);
            intent.putExtra("lessScore",lessScore);
            intent.putExtra("moreScore",moreScore);
            intent.putExtra("rollCount",rollCount);
            intent.putExtra("totalRoll",totalRoll);
            startActivity(intent);

        }
    }

    @Override
    public void onResume(){
        super.onResume();
        lessScore = prefs.getBoolean(getResources().getString(R.string.less_score),true);
        if (lessScore)
            lessScoreOn = true;
        else
            lessScoreOn = false;

        moreScore = prefs.getBoolean(getResources().getString(R.string.more_score),true);
        if(moreScore)
            moreScoreOn = true;
        else
            moreScoreOn = false;

        rollCount = prefs.getBoolean(getResources().getString(R.string.roll_count),true);
        if (rollCount)
            rollCountOn = true;
        else
            rollCountOn = false;

        totalRoll = prefs.getBoolean(getResources().getString(R.string.total_roll),true);
        if (totalRoll)
            totalRollOn = true;
        else
            totalRollOn = false;
    }
}

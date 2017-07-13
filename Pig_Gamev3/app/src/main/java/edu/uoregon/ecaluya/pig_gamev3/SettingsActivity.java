package edu.uoregon.ecaluya.pig_gamev3;

import android.os.Bundle;
import android.preference.PreferenceActivity;

/**
 * Created by elijahcaluya on 7/11/17.
 */

public class SettingsActivity extends PreferenceActivity {
    @Override
    @SuppressWarnings("deprecation")
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }
}

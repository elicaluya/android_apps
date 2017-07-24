package edu.uoregon.ecaluya.sneaker_game;

import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;

/**
 * Created by elijahcaluya on 7/23/17.
 */

public class SettingsActivity extends PreferenceActivity {

    @Override
    @SuppressWarnings("deprecation")
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);

        final CheckBoxPreference lowLimit = (CheckBoxPreference)findPreference("Low_Limit");
        final CheckBoxPreference highLimit = (CheckBoxPreference)findPreference("Higher_Limit");
        final CheckBoxPreference normLimit = (CheckBoxPreference)findPreference("Normal_Limit");
        final CheckBoxPreference easyMode = (CheckBoxPreference)findPreference("Easy_Mode");
        final CheckBoxPreference hardMode = (CheckBoxPreference)findPreference("Hard_Mode");
        final CheckBoxPreference normMode = (CheckBoxPreference)findPreference("Normal_Mode");

        lowLimit.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                highLimit.setChecked(false);
                normLimit.setChecked(false);
                return true;
            }
        });

        highLimit.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                lowLimit.setChecked(false);
                normLimit.setChecked(false);
                return true;
            }
        });
        normLimit.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                highLimit.setChecked(false);
                lowLimit.setChecked(false);
                return true;
            }
        });
        easyMode.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                hardMode.setChecked(false);
                normMode.setChecked(false);
                return true;
            }
        });
        hardMode.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                easyMode.setChecked(false);
                normMode.setChecked(false);
                return true;
            }
        });
        normMode.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                hardMode.setChecked(false);
                easyMode.setChecked(false);
                return true;
            }
        });
    }

}

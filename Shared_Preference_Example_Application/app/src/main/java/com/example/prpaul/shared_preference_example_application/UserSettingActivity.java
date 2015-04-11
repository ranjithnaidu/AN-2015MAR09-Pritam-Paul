package com.example.prpaul.shared_preference_example_application;

import android.os.Bundle;
import android.preference.PreferenceActivity;

/**
 * Created by prpaul on 4/11/2015.
 */
public class UserSettingActivity extends PreferenceActivity {

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.user_settings);
    }
}

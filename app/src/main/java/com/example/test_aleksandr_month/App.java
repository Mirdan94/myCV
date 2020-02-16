package com.example.test_aleksandr_month;

import android.app.Application;

import com.example.test_aleksandr_month.data.SharedPreferenceHelper;

public class App extends Application {

    private static SharedPreferenceHelper preferenceHelper;

    @Override
    public void onCreate() {
        super.onCreate();

        preferenceHelper = new SharedPreferenceHelper(this);

    }

    public static SharedPreferenceHelper getPreference () {
        return preferenceHelper;
    }
}

package com.example.karan.weatherapp;

import android.app.Activity;
import android.content.SharedPreferences;

public class CityPrefernce {

    SharedPreferences prefs;

    public CityPrefernce(Activity activity){
        prefs = activity.getPreferences(Activity.MODE_PRIVATE);
    }

    // If the user has not chosen a city yet, return
    // Sydney as the default city
    String getCity(){
        return prefs.getString("city", "Sydney, AU");
    }

    void setCity(String city){
        prefs.edit().putString("city", city).commit();
    }

}
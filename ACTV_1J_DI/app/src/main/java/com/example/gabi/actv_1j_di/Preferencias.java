package com.example.gabi.actv_1j_di;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.support.v7.widget.Toolbar;
import android.view.ViewParent;
import android.widget.Toast;

public class Preferencias extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferencias);

        //Recuperamos nuestros datos
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        // Registramos el listener
        SharedPreferences.OnSharedPreferenceChangeListener listener = new SharedPreferences.OnSharedPreferenceChangeListener() {
            public void onSharedPreferenceChanged(SharedPreferences prefs, String key) {
                if (key.equals("opcion5")) {
                    Preference connectionPref = findPreference(key);
                    //Recogemos los String de nuestra List
                    String s =  prefs.getString(key,"");
                    //Lo mostramos en un Toast
                    Toast.makeText(getApplicationContext(),"El tiempo de espera es "+ s, Toast.LENGTH_SHORT).show();
                }

            }
        };

        prefs.registerOnSharedPreferenceChangeListener(listener);
    }

}










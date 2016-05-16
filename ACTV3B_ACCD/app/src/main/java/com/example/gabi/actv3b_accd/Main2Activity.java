package com.example.gabi.actv3b_accd;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;
public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        /*
        Esta segunda Activity Recuperara los datos y los imprimira en un Toast
         */
        //Creamos nuestro objeto preferencia compartida, al cual le pasamos nuestropaquete, y un modo privadosolo
        // visible para la aplicacion
        SharedPreferences Preference = getSharedPreferences("com.example.gabi.actv3b_accd", Activity.MODE_PRIVATE);
        //Recuperamos los valores uardados
        String nombre = Preference.getString("Nombre","");
        String dni = String.valueOf(Preference.getString("DNI", ""));
        String FechNac = Preference.getString("Fecha","");
        String Sex = Preference.getString("Sexo", "");
        //Los mostramos en un Toast
        Toast.makeText(Main2Activity.this,"He leido :" + "Nombre :" + nombre + "," + "DNI :" + dni + ","
                                    +"Fecha Nacimiento :" + FechNac + "," +"Sexo :"+ Sex,Toast.LENGTH_LONG).show();
    }
}

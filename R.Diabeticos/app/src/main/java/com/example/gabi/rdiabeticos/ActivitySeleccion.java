package com.example.gabi.rdiabeticos;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class ActivitySeleccion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ImageButton BtnTarta = (ImageButton)findViewById(R.id.imageButton1);

        BtnTarta.setOnClickListener(new Button.OnClickListener() {
                                     @Override
                                     public void onClick(View v) {
                                         Intent intent = new Intent(getApplicationContext(), ActivityRecetas.class);
                                         startActivity(intent);

                                     }
                                 }
        );


    }

}

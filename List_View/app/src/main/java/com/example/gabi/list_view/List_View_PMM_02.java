package com.example.gabi.list_view;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class List_View_PMM_02 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list__view__pmm_02);


        Intent intent =getIntent();
        String item = intent.getStringExtra("so");
        Toast.makeText(List_View_PMM_02.this, item, Toast.LENGTH_LONG).show();
    }

}

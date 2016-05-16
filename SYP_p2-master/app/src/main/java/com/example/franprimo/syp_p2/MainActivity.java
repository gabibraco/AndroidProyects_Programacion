package com.example.franprimo.syp_p2;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

    private String TAG = "Practica 2 SYP: ";
    TareaMuyCostosa tmc = new TareaMuyCostosa();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button startWork = (Button) findViewById(R.id.button);
        Button stopWork = (Button) findViewById(R.id.button2);
        Button saludar = (Button) findViewById(R.id.button3);

        startWork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Ejecutando tarea muy costosa");
                ejecutarWork();
            }
        });

        stopWork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Deteniendo tarea muy costosa");
                detenerWork();
            }
        });

        saludar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Saludando");
                Toast t = Toast.makeText(getApplicationContext(), "Hola", Toast.LENGTH_SHORT);
                t.show();
            }
        });
    }

    public void ejecutarWork(){
        new Thread(new TareaMuyCostosa()).start();
    }

    public void detenerWork(){
        tmc.stopThread();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

package com.example.gabi.activitylife;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
    //Etiqueta representativa del proyecto
    private static final String TAG="ACTIVITYLIFE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "Cargada mi app");

        //Generar el Listener
        final Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Vamos a programar nuestra llamada a segundo activity
                Intent llamada = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(llamada);
            }
        });
        //Generar el Lisener del segundo boton
        final Button button2 = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Vamos a programar llamada a maps
                Uri direccion= Uri.parse("geo:0,0?q=Aldaya");
                Intent llamada = new Intent(Intent.ACTION_VIEW,direccion);
                startActivity(llamada);
            }
        });
    }

    protected void onResume(){
        super.onResume();
        Log.i(TAG, "Volvemos a nuestra aplicacion");
    }
    protected void onPause(){
        super.onPause();
        Log.i(TAG, "Nuestra aplicacion pasa a segundo plano");
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

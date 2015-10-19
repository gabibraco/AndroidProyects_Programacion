package com.example.gabi.act1fwebview;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivityWebview extends AppCompatActivity {

    //Inicio de definicion de varibles
    private Button boton;
    EditText buscar;
    private WebView Webview;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Definimos nuestro Layout principal
        setContentView(R.layout.activity_main_activity_webview);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //Definimos nuestros objetos dentro de nuestro Layout
        boton=(Button)findViewById(R.id.button);
        buscar=(EditText)findViewById(R.id.editText);
        //Definimos nuestro Webview, lo activamos y le pasamos nuestra nueva clase
        Webview=(WebView)findViewById(R.id.webView);
        Webview.setWebViewClient(new MiBuscador());
        //Implementamos la accion de nuestro boton con un Listener
        boton.setOnClickListener(new View.OnClickListener() {
            //Accion del boton
            @Override
            public void onClick(View v) {
                /*
                Definimos una nueva varible de tipo string que recogera
                 la uri escrita en nuestro EditText
                 */
                String url = buscar.getText().toString();
                //Recogemos los settings y buscamos la url
                Webview.getSettings().setLoadsImagesAutomatically(true);
                Webview.getSettings().setJavaScriptEnabled(true);
                Webview.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
                Webview.loadUrl(url);
            }
        });
    }
    //Definimos nuestra nueva clase
    private class MiBuscador extends WebViewClient {
        @Override
        //Declaramos un nuevo metodo al cual le pasaremos los datos por el constructor
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity_webview, menu);
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

package com.example.gabi.fragmentlistview;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;
import android.content.Intent;

public class MainActivity extends Activity implements ListFragment.ListFragmentListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

  }
    public void onListSelected(int position,String item){
        Toast.makeText(this,"Texto elegida: "+ item +position,Toast.LENGTH_LONG).show();
        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
        intent.putExtra("so", item);
        startActivity(intent);
    }
}

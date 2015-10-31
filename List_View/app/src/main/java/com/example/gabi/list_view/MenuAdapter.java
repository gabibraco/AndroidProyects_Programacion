package com.example.gabi.list_view;

/**
 * Created by Gabi on 30/10/2015.
 */
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MenuAdapter extends ArrayAdapter<String> {
    private Context context;
    private ArrayList<String> datos;
    public MenuAdapter(Context context, ArrayList<String> datos) {
        super(context, 0, datos);
        this.context=context;
        this.datos=datos;
    }

    public View getView (int position, View convertView, ViewGroup parent){
        LayoutInflater inflater= (LayoutInflater)context.getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);
        if(convertView==null){
            Log.i("INFO_DAM", parent.toString());
            convertView=inflater.inflate(R.layout.item_layout,parent,false);
        }
        ImageView imagen= (ImageView) convertView.findViewById(R.id.imageView);
        TextView texto= (TextView) convertView.findViewById(R.id.textView);

        texto.setText(datos.get(position));

        return convertView;
    }
}

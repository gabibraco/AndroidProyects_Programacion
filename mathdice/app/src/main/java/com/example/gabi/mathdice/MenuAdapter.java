package com.example.gabi.mathdice;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class MenuAdapter extends ArrayAdapter<String> {
    //Variables que usaremos
    private Context context;
    private ArrayList<String> datos;

    //Metodo constructor para sacar las variables recibidas fuera
    public MenuAdapter(Context context, ArrayList<String> datos) {
        super(context, 0 , datos);//Sin resources por eso es 0
        this.context = context;
        this.datos = datos;
    }

    //Metodo getView que monta el View y lo envia para ser usado (es llamado 1 vez por elemento)
    public View getView (int position, View convertView, ViewGroup parent){
        //Creamos el inflater para recoger nuestro layout
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //Comprobamos que no exista el convertView, si no existe creamos uno nuevo
        if(convertView == null){
            //El convertView recibe un item de la lista de su padre, y puesto que la ultima opcion es false,
            // la del medio (parent) nos da un set de layoutParams para el root view
            convertView= inflater.inflate(R.layout.lista_item, parent,false);
        }

        //Creamos los objetos imagen y texto que corresponderan al espacio Xml de imagen y texto
        ImageView imagen = (ImageView) convertView.findViewById(R.id.imageView3);
        TextView texto = (TextView) convertView.findViewById(R.id.textView);

        //le asignamos a la variables "texto" el valor de la posicion de "datos"
        texto.setText(datos.get(position));

        //Dependiendo de los datos recibidos segun la posicion, asignamos colores y imagenes
        if(datos.get(position) == "PERFIL"){ //Si es Perfil
            imagen.setImageDrawable(context.getDrawable(R.drawable.ic_face_black_24dp));//Recuperamos la imagen Drawable
            imagen.setBackgroundColor(Color.argb(255,102, 51, 0));//Asignamos el color al fondo imagen
            texto.setBackgroundColor(Color.argb(255, 236, 213, 193));//signamos color al fondo texto
        }else
            if(datos.get(position) =="JUEGO"){//si es juego
                imagen.setImageDrawable(context.getDrawable(R.drawable.ic_extension_black_24dp));
                imagen.setBackgroundColor(Color.argb(255,204, 51, 0));
                texto.setBackgroundColor(Color.argb(255, 255, 176, 150));
            }else
                if(datos.get(position) =="INSTRUCCIONES"){
                    imagen.setImageDrawable(context.getDrawable(R.drawable.ic_description_black_24dp));
                    imagen.setBackgroundColor(Color.argb(255,108, 153, 0));
                    texto.setBackgroundColor(Color.argb(255, 234, 255, 193));
                }else
                    if(datos.get(position) =="INFO"){
                        imagen.setImageDrawable(context.getDrawable(R.drawable.ic_info_black_24dp));
                        imagen.setBackgroundColor(Color.argb(255,0, 153, 153));
                        texto.setBackgroundColor(Color.argb(255, 193, 255, 255));
                    }

        //Revolvemos el convertView
        return convertView;
        }
}


package com.example.gabi.rdiabeticos;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FragmentPerfil extends Fragment implements View.OnClickListener {
    //DECLARACION DE NUESTRAS VARIABLES,OBJETOS Y VIEWS
    Button BtnGuardar;
    // campos de texto
    EditText edit_text1;
    EditText edit_text2;
    //nuestro callback
    private OnFragmentBotonListener mListener;
    //Declaramos nuestro SharedPrefereences
    SharedPreferences prefs;
    //Fichero de guardado
    private Uri fileUri;
    //Tipos definidos
    public static final int MEDIA_TYPE_IMAGE = 1;
    public static final int MEDIA_TYPE_VIDEO = 2;
    private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 100;

    public ImageView foto;
    public static File mediaStorageDir;
    public static View v;
    public static String timeStamp;

    //cONSTRUCTOR REQUERIDO
    public FragmentPerfil() {
    }

    //METOD DE CREACION
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // creamos archivo para preferencias.
        prefs = getActivity().getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);


    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentBotonListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    /************************************
     * METODO DONDE CREAREMOS NUESTROS VIEWS
     ************************************/
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //Infalamos nuestro Vieww
        v = inflater.inflate(R.layout.fragment_perfil, container, false);
        //Instanciamos nuestro boton para guardar
        BtnGuardar = (Button) v.findViewById(R.id.BtnGuardar);
        //Declaramos el listener de nuestro booton
        BtnGuardar.setOnClickListener(this);
        // Recupero de Preferencias la info.  En caso de que no exista, devolverá el segundo parametro.
        String Nombre = prefs.getString("nombre", "Introduzca su nombre");
        String Apellido = prefs.getString("apellido", "Introduzca su Apellido");
        //Asignamos a nuestros edit text las variables donde recuperamos los datos almacenados
        edit_text1 = (EditText) v.findViewById(R.id.editApellidos);
        edit_text2 = (EditText) v.findViewById(R.id.editnombre);

        edit_text1.setText(Nombre);
        edit_text2.setText(Apellido);
        //Instancamos nuestro boton para lanzar la camara y el textview donde se colocara el path
        final Button boton = (Button) v.findViewById(R.id.BtnFoto);
        final TextView fichero = (TextView) v.findViewById(R.id.textView2);
        //Instanciamos la imagen
        foto = (ImageView) v.findViewById(R.id.imageView4);
        //El listenes del boton para hacer la foto
        boton.setOnClickListener(new Button.OnClickListener() {
                                     @Override
                                     public void onClick(View v) {
                                         // create Intent to take a picture and return control to the calling application
                                         Intent camara = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                         fileUri = getOutputMediaFileUri(MEDIA_TYPE_IMAGE); // create a file to save the image
                                         camara.putExtra(MediaStore.EXTRA_OUTPUT, fileUri); // set the image file name
                                         // start the image capture Intent
                                         startActivityForResult(camara, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
                                         //Colocamos el nombre del fichero
                                         fichero.setText(fileUri.getPath());
                                     }
                                 }
        );
        return v;
    }

    /**
     * Creamos en este metodo la uri de nuestro file
     */
    private static Uri getOutputMediaFileUri(int type) {
        return Uri.fromFile(getOutputMediaFile(type));
    }

    /**
     * Creamos el fichero con este metodo
     */
    private static File getOutputMediaFile(int type) {
        //Utilizamos la clase especial que nos proporcona enviroment
        mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), "MyCameraApp");
        /**************************************************************************
         Creamos el directorio donde se guardara nuestra imagen y que se va a llamar
         MyCameraApp
         ***************************************************************************/

        if (!mediaStorageDir.exists()) {
            if (!mediaStorageDir.mkdirs()) {
                Log.d("MyCameraApp", "failed to create directory");
                return null;
            }
        }

        // Creamos el fichero
        timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File mediaFile;
        //Si es una imagen el archivo que se creara sera de tipo .jpg
        if (type == MEDIA_TYPE_IMAGE) {
            mediaFile = new File(mediaStorageDir.getPath() + File.separator +
                    "IMG_" + timeStamp + ".jpg");
        } else
            //Si por el contrario es un video el formato seria .mp4
            if (type == MEDIA_TYPE_VIDEO) {
                mediaFile = new File(mediaStorageDir.getPath() + File.separator +
                        "VID_" + timeStamp + ".mp4");
            } else {
                return null;
            }
        //Devolvemos el file creado
        return mediaFile;
    }

    // Este lo declaramos aqui para que al volver de utilizar la camara la imagen se coloque en el sitio adecuado
    @Override
    public void onResume() {
        super.onResume();
        try {
            //Condicion que debe exirtir nuestro directorio
            if (mediaStorageDir.exists()) {
                // Leemos el archivo guardado y lo asignamos al ImageView.
                Bitmap myBitmap = BitmapFactory.decodeFile(mediaStorageDir.getAbsolutePath()
                        + File.separator + "IMG_" + timeStamp + ".jpg");
                //Declaramos nuestro View
                ImageView myImage = (ImageView) v.findViewById(R.id.imageView4);
                //Y lo asignamos
                myImage.setImageBitmap(myBitmap);
            }
        } catch (Exception e) {
            Log.d("DAM", "Error iniciando la actividad de nuevo " + e.getMessage());
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        //Declaramos el callback
        mListener = null;
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }

    /*
    ESTE ES EL INTERFAZ QUE EL ACTIVITY SUPOERIOR DEBE IMPLEMENTAR PARA TRATAR LA INFORMACION
    Y ESTA ACTIVITY ES EL ACTIVITYPERFIL
     */
    public interface OnFragmentBotonListener {
        void onFragmentInteraction(String a, String b);
    }

    /*
    AQUI DECLARAMOS EL LISTENER DE NUESTRO BOTON, AQUI PARA ALMACENAR LA INFORMACION UTILIZAMOS
    SHAREDPREFERENCES.
     */
    public void onClick(View v) {
        // recupero el valor en string de los campos y asigno los valores a dos constantes.
        String uno = edit_text1.getText().toString();
        String dos = edit_text2.getText().toString();
        //ALMACENAMOS LA INFORMACION CON SHAREDPREFERENCES
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("nombre", uno);
        editor.putString("apellido", dos);
        //FORZAMOS EL ALMACENAMIENTO DE LA INFORMACION
        editor.commit();
        // Y PASAMOS LOS VALORES A TRAVES DE NUESTRO COLBACK
        mListener.onFragmentInteraction(uno, dos);


    }
}
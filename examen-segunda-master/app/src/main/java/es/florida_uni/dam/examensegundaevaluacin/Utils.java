package es.florida_uni.dam.examensegundaevaluacin;

import android.util.Log;

import java.security.MessageDigest;

public class Utils {
    final static String TAG = "SYP-examensegunda";

    public static void consumeCPU(){
        long millis = System.currentTimeMillis();

        final int TUNNING = 2;
        final int SIZE = 600;//1024;
            // TODO: para las pruebas puedes bajar este número y la carrera irá más rápida
            //1024 ~ 200ms
        for(int i=0;i<TUNNING;i++){

            String data = "a";
            while(data.length() < SIZE) {
                data += "a";
            }

            try{
                byte[] bytesOfMessage = data.getBytes("UTF-8");
                MessageDigest md = MessageDigest.getInstance("MD5");
                md.digest(bytesOfMessage);
            }catch(Exception e){}
        }

        //Log.i(TAG, "Millis consumed: " + (System.currentTimeMillis() - millis));

    }

}

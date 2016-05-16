package com.example.gabi.p05_mathdicemusica_pmm;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

<<<<<<< HEAD
import android.media.AudioManager.OnAudioFocusChangeListener;
public class JuegoFragment extends Fragment {

    //Declaramos uestras variables de audio
    private AudioManager audioManager;
    private MediaPlayer MPlayer;

    //Contructor del fragment requerido
    public JuegoFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            //Declaramos el servicio de audio.
            audioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

            //Cargamos la cancion
            MPlayer = MediaPlayer.create(getActivity(), R.raw.heavy);
            /*
            Como no he puesto botones para controlar el audio, solo tengo que poner en marcha el audio.
            y con la funcion start() del Mplayerlo iniciamos.
            */
            MPlayer.start();
=======

public class JuegoFragment extends Fragment {
    //  Sonido

    //Control de estado
    private int sonando = 0; //0=cancion no comenzada; 1=comenzada; 2=pause;
    //private MediaPlayer mPlayer;
    public AudioManager mAudioManager;
    public boolean mCanPlayAudio;

    public JuegoFragment() {

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            // Capturamos el servicio que nos proporciona manejar Sonidos
            mAudioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

            sound();
>>>>>>> a7d5ad622879e5833adeca8ae2b958866b88a44b
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
<<<<<<< HEAD
        // Inflamos nuestro layout
        View v = inflater.inflate(R.layout.fragment_juego, container, false);
        return v;
    }

    @Override
    public void onResume() {
        Log.d("AUDIO", "MUSICA YYY ACCION!!!!");
        super.onResume();
    }
    //Creamos el metodo para pausar
    @Override
    public void onPause() {
        Log.d("AUDIO", "EN PAUSA");
        //lo ponemos en modo pause cuando salimos del fragment
        MPlayer.pause();
        audioManager = null;
        super.onPause();
    }
=======
            // Inflate the layout for this fragment
            View v = inflater.inflate(R.layout.fragment_juego, container, false);

            return v;
    }

        // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {

    }

>>>>>>> a7d5ad622879e5833adeca8ae2b958866b88a44b
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

    }
<<<<<<< HEAD
    /*
    /*Construyo este metodo para que cuando pulsemos otra vez en el list la cancion no se me
    vuelva a cargar encima de la que tengo*/
    @Override
    public void onDetach() {
        super.onDetach();
        /*Con este metodo , nos aseguramos que cuando se vuelva a pulsar en el lisview la cancion,
        empezara de cero*/
        MPlayer.release();
    }

}
=======

    @Override
    public void onDetach() {
        super.onDetach();

    }
    //Metodo que controla el sistema de sonido
    public void sound() {
        // Cargamos la cancion
        MediaPlayer mPlayer = MediaPlayer.create(getActivity(), R.raw.heavy);
        if (sonando == 0){
            sonando = 1;

            mPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                                              @Override
                                              public void onPrepared(MediaPlayer mp) {
                                                  Log.d("AUDIO", "Cargada la cancion");
                                              }
                                          }
            );

            // Request audio focus
            int result = mAudioManager.requestAudioFocus(afChangeListener,
                    AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN);

            mCanPlayAudio = AudioManager.AUDIOFOCUS_REQUEST_GRANTED == result;
            mPlayer.start();
        } else if (sonando == 1){
            sonando=2;
            mPlayer.pause();
        } else {
            sonando=1;
            mPlayer.start();
        }

    }


    // Get ready to play sound effects
    @Override
    public void onResume() {
        Log.d("AUDIO", "Iniciando musica");
        super.onResume();
        mAudioManager.setSpeakerphoneOn(true);
        mAudioManager.loadSoundEffects();
    }

    // Release resources & clean up
    @Override
    public void onPause() {
        Log.d("AUDIO", "Pausando musica");
        mAudioManager.setSpeakerphoneOn(false);
        mAudioManager.unloadSoundEffects();
        super.onPause();
    }

    // Listen for Audio focus changes
    AudioManager.OnAudioFocusChangeListener afChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                mAudioManager.abandonAudioFocus(afChangeListener);
                mCanPlayAudio = false;
            }
        }
    };



}


>>>>>>> a7d5ad622879e5833adeca8ae2b958866b88a44b

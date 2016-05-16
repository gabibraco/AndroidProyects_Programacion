package com.example.gabi.fragmentlistview;

import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;


public class ListFragment extends Fragment {

    ListFragmentListener mCallback;

    // Container Activity must implement this interface
    //INNER CLASS donde el Activity superior debe implementar position
    public interface ListFragmentListener {
        public void onListSelected(int position,String item);
    }

    public ListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_list, container, false);
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            mCallback = (ListFragmentListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnHeadlineSelectedListener");

        }
    }

    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
              /*
      EN PRIMER LUGAR DEFINIMOS EL ARRAY DE STRINGS Y LO CONVERTIMOS A UNA LISTA
      EN ESTE CASO ARRAYLIST
       */
        //DATOS
        String[] sistemasOperatvos = new String[]{"Android", "iPhone", "WindowsMobile",
                "Blackberry", "WebOs", "Ubuntu", "Windows", "Max Os X", "Linux", "OS/2",
                "Ubuntu", "Windows7", "Max Os X", "Linux", "OS/2", "Android", "iPhone",
                "WindowsMobile","Android", "iPhone", "WindowsMobile",
                "Blackberry", "WebOs", "Ubuntu", "Windows", "Max Os X", "Linux", "OS/2",
                "Ubuntu", "Windows7", "Max Os X", "Linux", "OS/2", "Android", "iPhone",
                "WindowsMobile"
        };
        ArrayList<String> listaSO = new ArrayList<String>(Arrays.asList(sistemasOperatvos));
        //En segundo Lugar enchufamos la lista al adaptador
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, listaSO);

        //Utilizamos nuestro AdapterCustomizado
        // MenuAdapter adapter = new MenuAdapter(this, listaSO);

        //Por ultimo enchufamos el Adapter a la Vista que es ListView
        //Interfaz o Vision
        final ListView listView = (ListView) getActivity().findViewById(R.id.listview);
        listView.setAdapter(adapter);
        //InterActuando
        listView.setOnItemClickListener(new nuestroListener());
        // Inflate the layout for this fragment


}

    @Override
    public void onDetach() {
        super.onDetach();
        mCallback=null;
    }
    //INNERCLASS
    private class nuestroListener implements AdapterView.OnItemClickListener{
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //String de la posicion
            String item = (String) parent.getItemAtPosition(position);
            // Toast.makeText(List_View_PMM.this, item, Toast.LENGTH_LONG).show();
            // Paso de Informacion
            mCallback.onListSelected(position,item);

        }


    }

}

package com.example.gabi.actv_5a_accd;

import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends Activity implements View.OnClickListener{
    private MyBDAdapter dbAdapter;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Declaramos nuestros Botones
        final Button btnInsProfesor = (Button)findViewById(R.id.btnInsProfesor);
        final Button btnInsEstudiante = (Button)findViewById(R.id.btnInsEstudiante);
        final Button btnBorraProfesor = (Button)findViewById(R.id.btnBorraProfesor);
        final Button btnBorraEstudiante = (Button)findViewById(R.id.btnBorraEstudiante);
        final Button btnConsultaEstudiante = (Button)findViewById(R.id.btnConsulEstudiante);
        final Button btnConsultaProfesor = (Button)findViewById(R.id.btnConsulProfe);
        final Button btnConsultarAmbos = (Button)findViewById(R.id.btnConsultaAmbos);

        //Asignamos el listener a nuestros botones
        btnInsProfesor.setOnClickListener(this);
        btnInsEstudiante.setOnClickListener(this);
        btnBorraProfesor.setOnClickListener(this);
        btnBorraEstudiante.setOnClickListener(this);
        btnConsultaEstudiante.setOnClickListener(this);
        btnConsultaProfesor.setOnClickListener(this);
        btnConsultarAmbos.setOnClickListener(this);
        //Generamos un objeto de nuestro Adapter
        dbAdapter = new MyBDAdapter(this);
        //Abrimos nuestra base de datos
        dbAdapter.open();
    }
        public void onClick (View v) {
            //Definimos nuestros EditText
            EditText Name = (EditText) findViewById(R.id.editTextName);
            EditText Year = (EditText) findViewById(R.id.editTextYear);

            EditText Ciclo = (EditText) findViewById(R.id.editTextCiclo);
            EditText Curso = (EditText) findViewById(R.id.editTextCurso);
            EditText Nota = (EditText) findViewById(R.id.editTextNota);
            EditText Tutor = (EditText) findViewById(R.id.editTextTutor);
            EditText Despacho = (EditText) findViewById(R.id.editTextDespacho);
            EditText ID = (EditText) findViewById(R.id.editTextId);

            // ListView lv = (ListView) findViewById(R.id.listView);
            //Asigamos el valor de los EditText a unas variables
            String Nombre = Name.getText().toString();
            String Edad = Year.getText().toString();
            String Ciclos = Ciclo.getText().toString();
            String Cursos = Curso.getText().toString();
            String Nmedia = Nota.getText().toString();
            String CursoTutor = Tutor.getText().toString();
            String Despachos = Despacho.getText().toString();
            String id = ID.getText().toString();

            //Generamos un switch para nuestros botones
            switch (v.getId()) {
                case R.id.btnInsEstudiante:
                    dbAdapter.open();
                    //Pasamos los datos recogidos por el edit text para insertarlos
                    dbAdapter.insertarestudiante(Nombre, Edad, Ciclos, Cursos, Nmedia);
                    //Limpiamos los campos
                    Name.setText("");
                    Year.setText("");
                    Ciclo.setText("");
                    Curso.setText("");
                    Nota.setText("");
                    break;
                case R.id.btnInsProfesor:
                    dbAdapter.open();
                    //Pasamos los datos recogidos por el edit text para insertarlos
                    dbAdapter.insertarprofesor(Nombre, Edad, Ciclos, CursoTutor, Despachos);
                    //Limpiamos los campos
                    Name.setText("");
                    Year.setText("");
                    Ciclo.setText("");
                    Tutor.setText("");
                    Despacho.setText("");
                    break;
                case R.id.btnBorraEstudiante:
                    dbAdapter.open();
                    //Le indicamos el id que queremos borrar
                    dbAdapter.borrarestudiante(id);
                    //Limpiamos el edittext
                    ID.setText("");
                    break;
                case R.id.btnBorraProfesor:
                    dbAdapter.open();
                    //Le indicamos el id que queremos borrar
                    dbAdapter.borrarprofesor(id);
                    //Limpiamos el edittext
                    ID.setText("");
                    break;
                /*
                ACTV5B ( Consultas con Cursor): Apartir de aqui sera la parte de la actv5b
                 */
                case R.id.btnConsulEstudiante:
                    //Definimos nuestra condicion
                    if (Ciclo.getText() != null && Curso.getText() != null) {
                        //Declaraos los String que recuperaran los datos de los editext
                        String NomCiclo = Ciclo.getText().toString();
                        String NomCursos = Curso.getText().toString();
                        String edad2= Year.getText().toString();
                        //Creammos nuestro ArrayList para enviar los datos al metodo recuperarEstudiantes
                        ArrayList<String> listadoAlumno = new ArrayList<>(dbAdapter.recuperarEstudiantes(edad2));
                        //Creamos un objeto de menu adapter al cual le pasamos nuestro Arraylist
                        MenuAdapter adapter = new MenuAdapter(this, listadoAlumno);
                        //Instanciamos nuestro ListView
                        ListView lv = (ListView) findViewById(R.id.listView);
                        //Pasamos a nuestro listView el adapter
                        lv.setAdapter(adapter);
                    }
                    break;
                case R.id.btnConsulProfe:
                    //Definimos nuestra condicion
                    if (Ciclo.getText() != null && Tutor.getText() != null) {
                        //Declaraos los String que recuperaran los datos de los editext
                        String NomCiclo = Ciclo.getText().toString();
                        String CursoTuto = Tutor.getText().toString();
                        //Creammos nuestro ArrayList para enviar los datos al metodo recuperarEstudiantes
                        ArrayList<String> listadoPorfes = new ArrayList<>(dbAdapter.recuperarProfesores(NomCiclo, CursoTuto));
                        //Creamos un objeto de menu adapter al cual le pasamos nuestro Arraylist
                        MenuAdapter adapter = new MenuAdapter(this, listadoPorfes);
                        //Instanciamos nuestro ListView
                        ListView lv = (ListView) findViewById(R.id.listView);
                        //Pasamos a nuestro listView el adapter
                        lv.setAdapter(adapter);
                    }
                    break;

                //Examen aqui consultamos algo
                case R.id.btnConsultaAmbos:
                   if ( Year.getText()!=null){
                       String Edad1 = Year.getText().toString();
                       ArrayList<String> listadoAlumno =new ArrayList<>(dbAdapter.recuperarAlumnoporEdades(Edad1));
                       ArrayList<String> listadoPorfes =new ArrayList<>(dbAdapter.recuperarProfesorporEdades(Edad1));
                       ArrayList<String> Todos = new ArrayList<String>();
                       Todos.addAll(listadoAlumno);
                       Todos.addAll(listadoPorfes);
                       MenuAdapter adapter = new MenuAdapter(this, Todos);
                       //Instanciamos nuestro ListView
                       ListView lv = (ListView) findViewById(R.id.listView);
                       //Pasamos a nuestro listView el adapter
                       lv.setAdapter(adapter);





                    /*
                    //Condicion que los datos que pasamos o sean nulos para mostrar los datos en el ArrayList
                    if (Ciclo.getText() != null && Curso.getText() != null && Tutor.getText() != null) {
                        //Declaraos los String que recuperaran los datos de los editext
                        String NomCiclo = Ciclo.getText().toString();
                        String NomCursos = Curso.getText().toString();
                        String CursoTuto = Tutor.getText().toString();
                        //Creammos nuestro ArrayList para enviar los datos al metodo recuperarEstudiantes
                        ArrayList<String> listadoAlumno = dbAdapter.recuperarEstudiantes(NomCiclo, NomCursos);
                        ArrayList<String> listadoPorfes = dbAdapter.recuperarProfesores(NomCiclo, CursoTuto);
                        //Creamos un nuevo ArrayList donde insertamos los datos de las otras dos listas
                        ArrayList<String> Todos = new ArrayList<String>();
                        Todos.addAll(listadoAlumno);
                        Todos.addAll(listadoPorfes);
                        //Creamos un objeto de menu adapter al cual le pasamos nuestro Arraylist
                        MenuAdapter adapter = new MenuAdapter(this, Todos);
                        //Instanciamos nuestro ListView
                        ListView lv = (ListView) findViewById(R.id.listView);
                        //Pasamos a nuestro listView el adapter
                        lv.setAdapter(adapter);*/
                    }
            }

        }
    //Esto sigue formando parte de la ACTV 5A tambien
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

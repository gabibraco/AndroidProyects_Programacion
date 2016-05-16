package com.example.gabi.actv_5a_accd;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;


public class MyBDAdapter  {
        // Definiciones y constantes
        private static final String DATABASE_NAME = "centro.db";
        public static final String DATABASE_TABLE_ESTUDIANTE = "estudiante";
        private static final String DATABASE_TABLE_PROFESOR = "profesor";
        private static final int DATABASE_VERSION = 1;
        //Declaracion de variables tabla Estudiante
        public static final String NOMBRE = "nombre";
        public static final String EDAD = "edad";
        public static final String CICLO = "ciclo";
        public static final String CURSO = "curso";
        public static final String NMEDIA = "nota";
        public static final String id ="id";
        //Declaracion de Variables tabla Profesor
        public static final String CURSO_TUTOR = "tutor";
        public static final String DESPACHO = "despacho";
        //Declatracion de variables para crear tabla estudiante
        private static final String DATABASE_CREATE_ESTU = "CREATE TABLE "+DATABASE_TABLE_ESTUDIANTE +" " +
                "(_id integer primary key autoincrement, nombre text, edad integer,ciclo text,curso text,nota integer);";
        private static final String DATABASE_DROP_ESTU = "DROP TABLE IF EXISTS "+DATABASE_TABLE_ESTUDIANTE +";";
        //Declatracion de variables para crear tabla estudiante
        private static final String DATABASE_CREATE_PROFE = "CREATE TABLE "+DATABASE_TABLE_PROFESOR +" " +
                "(_id integer primary key autoincrement, nombre text, edad integer,ciclo integer,tutor text,despacho text);";
        private static final String DATABASE_DROP_PROFE = "DROP TABLE IF EXISTS "+DATABASE_TABLE_PROFESOR +";";

        // Contexto de la aplicación que usa la base de datos
        private final Context context;
        // Clase SQLiteOpenHelper para crear/actualizar la base de datos
        private MyDbHelper dbHelper;
        // Instancia de la base de datos
        private SQLiteDatabase db;
        //Contructor de nuestra clase adapter al que le pasamos el contexto
        public MyBDAdapter(Context c){
            context = c;//Definimos el context
            dbHelper = new MyDbHelper(context, DATABASE_NAME, null, DATABASE_VERSION);

        }



    //Con este metodo conseguimos abrir la BD y sino la creamos
        public SQLiteDatabase open(){

            try{
                db = dbHelper.getWritableDatabase();
            }catch(SQLiteException e){
                db = dbHelper.getReadableDatabase();
            }
            return null;
        }
        //Metodo para insertar estudiantes a traves de contentValues
        public void insertarestudiante(String Nombre, String Edad, String Ciclos , String Cursos,String Nmedia){
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            if(db != null) {
                //Creamos un nuevo registro de valores a insertar
                ContentValues newValues = new ContentValues();
                //Asignamos los valores de cada campo
                newValues.put(NOMBRE, Nombre);
                newValues.put(EDAD, Edad);
                newValues.put(CICLO, Ciclos);
                newValues.put(CURSO, Cursos);
                newValues.put(NMEDIA, Nmedia);
                db.insert(DATABASE_TABLE_ESTUDIANTE, null, newValues);
                db.close();
            }
        }
        //Metodo para insertar profesores a traves de contentValues
        public void insertarprofesor(String Nombre, String Edad, String Ciclos , String CursoTutor,String Despachos){
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            if(db != null) {
                //Creamos un nuevo registro de valores a insertar
                ContentValues newValues = new ContentValues();
                //Asignamos los valores de cada campo
                newValues.put(NOMBRE, Nombre);
                newValues.put(EDAD, Edad);
                newValues.put(CICLO, Ciclos);
                newValues.put(CURSO_TUTOR, CursoTutor);
                newValues.put(DESPACHO, Despachos);
                db.insert(DATABASE_TABLE_PROFESOR, null, newValues);
                db.close();
            }
        }
        //Metodo para borrar a traves del id
        public void borrarestudiante(String id){
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            db.delete("estudiante", "_id=" + id, null);
            db.close();
        }
        //Metodo para borrar a traves del id
        public void borrarprofesor(String id){
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            db.delete("profesor","_id="+id,null);
            db.close();
        }
    /*
    ACTV5B ( Consultas con Cursor): Los dos metodos siguintes nos sirven para poder recuperar
    los datos y pasarlos a un ListView. Son parte de la ACTV5B
     */
        //Metodo para recuperar los estudiantes al que e pasamos los datos
        public  ArrayList<String>  recuperarEstudiantes(String edad2) {
            //Consulta si la BD se puede leer
            SQLiteDatabase db = dbHelper. getReadableDatabase();
            //Creamos el ArrayList de alumnos
            ArrayList<String> alumnos = new ArrayList<String>();
           //Definimos el String que contendra la clausula where
            String whereClause = "edad='"+edad2+"'";
            //Definimos nuestro cursor al que le pasamos la condicion Where
            Cursor cursor = db.query(DATABASE_TABLE_ESTUDIANTE, null, whereClause , null, null, null, null);
            //Condicion o posicionamiento de nuestro cursor
            if( cursor != null && cursor.moveToFirst()){
                do{
                    //Añadimos nuestros datos a nuestro Array
                    alumnos.add(cursor.getString(0)+ " " +cursor.getString(1));
                }while (cursor.moveToNext());
            }
            //Cerramos nuestra base de datos
            db.close();

            return alumnos;
        }
        //Metodo para poder recuperar una lista de profesores
         public  ArrayList<String>  recuperarProfesores(String NomCiclo,String CursoTuto) {
            //Consulta si la BD se puede leer
            SQLiteDatabase db = dbHelper. getReadableDatabase();
            //Creamos el ArrayList de alumnos
            ArrayList<String> Profesores = new ArrayList<String>();
            //Definimos el String que contendra la clausula where
            String whereClause = "edad='"+NomCiclo+"' AND edad='"+CursoTuto+"'";
            //Definimos nuestro cursor al que le pasamos la condicion Where
            Cursor cursor = db.query(DATABASE_TABLE_PROFESOR, null, whereClause, null, null, null, null);
            //Condicion o posicionamiento de nuestro cursor
                if(cursor != null  && cursor.moveToFirst()){
                    do{
                        //Añadimos nuestros datos a nuestro Array
                        Profesores.add(cursor.getString(0)+ " " +cursor.getString(1));
                    }while (cursor.moveToNext());
                }
            //Cerramos nuestra base de datos
            db.close();

         return Profesores;
    }
    /*******************************************************************************************************
     ****EXAMEN PARTE PRACTICA ACTIVIDAD1 : Busqueda de profesores y alumnos por edad comprendida***********
     *******************************************************************************************************
     *******************************************************************************************************
     */


    public ArrayList<String> recuperarProfesorporEdades (String edad2){
        //Consulta si la BD se puede leer
        SQLiteDatabase db = dbHelper. getReadableDatabase();
        //Creamos el ArrayList de alumnos
        ArrayList<String> alumnos = new ArrayList<String>();
        //Definimos el String que contendra la clausula where
        String whereClause = "edad='"+edad2+"'";
        //Definimos nuestro cursor al que le pasamos la condicion Where
        Cursor cursor = db.query(DATABASE_TABLE_ESTUDIANTE, null, whereClause , null, null, null, null);
        //Condicion o posicionamiento de nuestro cursor
        if( cursor != null && cursor.moveToFirst()){
            do{
                //Añadimos nuestros datos a nuestro Array
                alumnos.add(cursor.getString(0)+ " " +cursor.getString(1));
            }while (cursor.moveToNext());
        }
        //Cerramos nuestra base de datos
        db.close();

        return alumnos;
    }
    public ArrayList<String> recuperarAlumnoporEdades (String edad2){


        //Consulta si la BD se puede leer
        SQLiteDatabase db = dbHelper. getReadableDatabase();
        //Creamos el ArrayList de alumnos
        ArrayList<String> ProfesoresEdad = new ArrayList<String>();
        //Definimos el String que contendra la clausula where
        String whereClause = "edad='"+edad2+"'";
        //Definimos nuestro cursor al que le pasamos la condicion Where
        Cursor cursor = db.query(DATABASE_TABLE_ESTUDIANTE, null, whereClause , null, null, null, null);
        //Condicion o posicionamiento de nuestro cursor
        if( cursor != null && cursor.moveToFirst()){
            do{
                //Añadimos nuestros datos a nuestro Array
                ProfesoresEdad.add(cursor.getString(0)+ " " +cursor.getString(1));
            }while (cursor.moveToNext());
        }
        //Cerramos nuestra base de datos
        db.close();


        return ProfesoresEdad;
    }


        //CLASE QUE EXTIENDE DE SQLITE
        private static class MyDbHelper extends SQLiteOpenHelper {
            public MyDbHelper (Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
                super(context,name,factory,version);
            }
            //METODO DONDE CREAMOS NUESTRA BD
            @Override
            public void onCreate(SQLiteDatabase db) {
                db.execSQL(DATABASE_CREATE_ESTU);
                db.execSQL(DATABASE_CREATE_PROFE);
            }

            @Override
            //METODO PARA BORRAR O MODIFICAR LOS DATOS DE LA BD
            public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
                db.execSQL(DATABASE_DROP_ESTU);
                db.execSQL(DATABASE_DROP_PROFE);
                onCreate(db);
            }

        }
    }


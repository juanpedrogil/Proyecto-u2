package com.example.juan.proyectou2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.service.autofill.FillEventHistory;

/**
 * Created by juan on 13/03/18.
 */

public class helper extends SQLiteOpenHelper {
    private static final String DB_NAME="mydb";
    private static final int DB_VERSION=1;
    private static final String NOMBRE="nombre";
    private static final String CONTROL="noControl";
    private static final String CELULAR="celular";
    private static final String EMAIL="email";
    private static final String CARRERA="carrera";
    private static final String DESCRIPCION="desc";
    private static final String FECHA_INI="fecha_ini";
    private static final String FECHA_FIN="fecha_fin";
    private static final String CREDITOS="creditos";

    private static final String TB_ALUMNO="CREATE TABLE alumno(ID INTEGER PRIMARY KEY AUTOINCREMENT,nombre TEXT,noControl TEXT,celular TEXT, email TEXT," +
            "carrera TEXT)";
    private final String TB_ACTIVIDAD="CREATE TABLE actividad(ID INTEGER PRIMARY KEY AUTOINCREMENT,desc TEXT, fecha_ini TEXT, fecha_fin TEXT,creditos TEXT)";
    SQLiteDatabase db;
    public helper(Context context) {
        super(context, DB_NAME,null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
            db.execSQL(TB_ALUMNO);
            db.execSQL(TB_ACTIVIDAD);
    }
    public void openDB(){
        db=getWritableDatabase();
    }
    public void closeDB() {
        if (db != null && db.isOpen()) {
            db.close();

        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public boolean insertAlumno(String nombre,String noControl,String celular,String email,String carrera){
        openDB();
        ContentValues contentValues=new ContentValues();
        contentValues.put(NOMBRE,nombre);
        contentValues.put(CONTROL,noControl);
        contentValues.put(CELULAR,celular);
        contentValues.put(EMAIL,email);
        contentValues.put(CARRERA,carrera);
        long result=db.insert("alumno",null,contentValues);
        if(result==-1){
            return false;
        }else{
            return  true;
        }

    }
    public boolean insertActividad(String desc,String fecha_ini,String fecha_fin,String creditos){
        openDB();
        ContentValues contentValues=new ContentValues();
        contentValues.put(DESCRIPCION,desc);
        contentValues.put(FECHA_INI,fecha_ini);
        contentValues.put(FECHA_FIN,fecha_fin);
        contentValues.put(CREDITOS,creditos);
        long result=db.insert("actividad",null,contentValues);
        if(result==-1){
            return false;
        }else{
            return  true;
        }

    }
    public Cursor getAllData(String tabla){
        openDB();
        Cursor res=db.rawQuery("select * from "+tabla,null);
        return res;
    }
    public boolean updateActividad(String clave,String nombre,String salario){
        openDB();
        ContentValues contentValues=new ContentValues();
        contentValues.put(CLAVE_NAME,clave);
        contentValues.put(NOMBRE_NAME,nombre);
        contentValues.put(SALARIO_NAME,salario);
        db.update(TABLE_NAME,contentValues,"clave=?",new String[]{clave});
        return true;
    }
    public boolean updateAlumno(String clave,String nombre,String salario){
        openDB();
        ContentValues contentValues=new ContentValues();
        contentValues.put(CLAVE_NAME,clave);
        contentValues.put(NOMBRE_NAME,nombre);
        contentValues.put(SALARIO_NAME,salario);
        db.update(TABLE_NAME,contentValues,"clave=?",new String[]{clave});
        return true;
    }
}

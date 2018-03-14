package com.example.juan.proyectou2;

import android.content.Intent;
import android.database.Cursor;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ver_alumnos extends AppCompatActivity {
    RecyclerView lista;
    List<ItemAlumno> datos=new ArrayList<ItemAlumno>();
    RecyclerView.LayoutManager layoutManager;
    ConstraintLayout constraintLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_alumnos);
        lista=findViewById(R.id.lista);
        consultarAlumnos();
        layoutManager=new LinearLayoutManager(this);
        lista.setLayoutManager(layoutManager);
        lista.setHasFixedSize(true);
    }
    private void consultarAlumnos(){
        datos.clear();
        Cursor carrera=MainActivity.sqlite.getAllData("actividad");
        List<Item> auxiliar=new ArrayList<Item>();
        if(carrera.getCount()!=0){
            while(carrera.moveToNext()){
                Toast.makeText(getApplicationContext(),carrera.getString(5),Toast.LENGTH_LONG).show();
                Item aux=new Item(carrera.getString(1),carrera.getString(5),"","","");
                auxiliar.add(aux);
            }

        }
        Cursor actividad_data=MainActivity.sqlite.getAllDataOrder("alumno");
        if(actividad_data.getCount()==0){
            return;
        }
        while(actividad_data.moveToNext()){
            //nombre,carrera,actividad,fecha_ini,fecha_fin
            ItemAlumno aux=new ItemAlumno(actividad_data.getString(1),actividad_data.getString(5),
                    "0",actividad_data.getString(2));
            for(int j=0;j<auxiliar.size();j++){
                if(aux.getNombre().equals(auxiliar.get(j).getNombre())){
                    int a= Integer.parseInt(auxiliar.get(j).getCarrera());
                    a+=Integer.parseInt(aux.getCreditosAcumulados());
                    aux.setCreditosAcumulados(a+"");
                }
            }
            datos.add(aux);
        }

        Adapter_Alumnos adapter=new Adapter_Alumnos(datos);
        lista.setAdapter(adapter);
        lista.setLayoutManager(layoutManager);
    }
}

package com.example.juan.proyectou2;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Ver_actividad extends AppCompatActivity {
    RecyclerView lista;
    List<ItemActividad> datos=new ArrayList<ItemActividad>();
    RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_actividad);
        lista=findViewById(R.id.lista);
        consultarAlumnos();
        layoutManager=new LinearLayoutManager(this);
        lista.setLayoutManager(layoutManager);
        lista.setHasFixedSize(true);
    }
    private void consultarAlumnos(){
        datos.clear();
        Cursor actividad_data=MainActivity.sqlite.getAllDataOrderA("actividad");
        if(actividad_data.getCount()==0){
            return;
        }
        while(actividad_data.moveToNext()){
            //nombre,carrera,actividad,fecha_ini,fecha_fin
            ItemActividad aux=new ItemActividad(actividad_data.getString(1),
                    actividad_data.getString(2),actividad_data.getString(3),
                    actividad_data.getString(4),actividad_data.getString(5));
            datos.add(aux);
        }
        ordenar();
        Adapter_Actividad adapter=new Adapter_Actividad(datos);
        lista.setAdapter(adapter);
        lista.setLayoutManager(layoutManager);
    }
    private void ordenar(){

    }
}

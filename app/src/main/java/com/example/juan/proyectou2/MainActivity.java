package com.example.juan.proyectou2;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView lista;
    Button add_alumno,add_actividad,ver_alumnos,ver_actividad;
    List<Item> datos=new ArrayList<Item>();
    public static helper sqlite;
    RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        sqlite=new helper(this);
        sqlite.openDB();
        consultarAlumnos();
        layoutManager=new LinearLayoutManager(this);
        lista.setLayoutManager(layoutManager);
        lista.setHasFixedSize(true);
        add_alumno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent add_alumno_activity=new Intent(MainActivity.this,add_alumno.class);
                startActivity(add_alumno_activity);
            }
        });
        add_actividad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent add_actividad_activity=new Intent(MainActivity.this,add_actividad.class);
                startActivity(add_actividad_activity);
            }
        });
        ver_alumnos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent add_actividad_activity=new Intent(MainActivity.this,ver_alumnos.class);
                startActivity(add_actividad_activity);
            }
        });
        ver_actividad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent add_actividad_activity=new Intent(MainActivity.this,Ver_actividad.class);
                startActivity(add_actividad_activity);
            }
        });

    }
    private void init(){
        add_actividad=findViewById(R.id.add_actividad);
        add_alumno=findViewById(R.id.add_alumno);
        ver_alumnos=findViewById(R.id.ver_alumno);
        ver_actividad=findViewById(R.id.ver_actividad);
        lista=findViewById(R.id.lista);
    }
    private void consultarAlumnos(){
        datos.clear();
        Cursor carrera=sqlite.getAllData("alumno");
        List<Item> auxiliar=new ArrayList<Item>();
        if(carrera.getCount()!=0){
            while(carrera.moveToNext()){
                //Toast.makeText(getApplicationContext(),carrera.getString(5),Toast.LENGTH_LONG).show();
                Item aux=new Item(carrera.getString(1),carrera.getString(5),"","","");
                auxiliar.add(aux);
            }

        }
        Cursor actividad_data=sqlite.getAllData("actividad");
        if(actividad_data.getCount()==0){
            return;
        }
        while(actividad_data.moveToNext()){
            //nombre,carrera,actividad,fecha_ini,fecha_fin
            Item aux=new Item(actividad_data.getString(1),"",actividad_data.getString(2),
                    actividad_data.getString(3),actividad_data.getString(4));
            for(int j=0;j<auxiliar.size();j++){
                if(aux.getNombre().equals(auxiliar.get(j).getNombre())){
                   aux.setCarrera(auxiliar.get(j).getCarrera());
                }
            }
            datos.add(aux);
        }

        Adapter adapter=new Adapter(datos);
        lista.setAdapter(adapter);
        lista.setLayoutManager(layoutManager);
    }
    @Override
    public void onResume(){
        super.onResume();
        consultarAlumnos();

    }
}

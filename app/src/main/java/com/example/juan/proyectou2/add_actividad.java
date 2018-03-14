package com.example.juan.proyectou2;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

public class add_actividad extends AppCompatActivity {
    TextView actividad,fecha_ini,fecha_fin,creditos;
    Spinner alumno;
    Button add_actividad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_actividad);
        init();
        Cursor alumnos_data=MainActivity.sqlite.getAllData("alumno");
        if(alumnos_data.getCount()!=0){
            List<String> array=new ArrayList<String>();


            while(alumnos_data.moveToNext()){
                array.add(alumnos_data.getString(1));
            }
            String[] arraySpinner=new String[array.size()];
            for(int i=0;i<array.size();i++){
                arraySpinner[i]=array.get(i);
            }
            Spinner s = (Spinner) findViewById(R.id.spin_alumno);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, arraySpinner);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            s.setAdapter(adapter);
        }

        add_actividad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.sqlite.insertActividad(alumno.getSelectedItem().toString(),actividad.getText().toString(),
                        fecha_ini.getText().toString(),fecha_fin.getText().toString(),creditos.getText().toString());
                Toast.makeText(getApplicationContext(),"Actividad asignada",Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }
    private void init(){
        alumno=findViewById(R.id.spin_alumno);
        actividad=findViewById(R.id.actividad);
        fecha_fin=findViewById(R.id.fecha_fin);
        fecha_ini=findViewById(R.id.fecha_ini);
        creditos=findViewById(R.id.creditos);
        add_actividad=findViewById(R.id.add_actividad);
    }
}

package com.example.juan.proyectou2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class add_alumno extends AppCompatActivity {
    TextView nombre,noControl,carrera,celular,email;
    Button add_alumno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_alumno);
        init();
        add_alumno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.sqlite.insertAlumno(nombre.getText().toString(),noControl.getText().toString(),
                        celular.getText().toString(),email.getText().toString(),carrera.getText().toString());
                Toast.makeText(getApplicationContext(),"Alumno insertado",Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }
    private void init(){
        nombre=findViewById(R.id.nombre);
        noControl=findViewById(R.id.control);
        carrera=findViewById(R.id.carrera);
        celular=findViewById(R.id.creditos);
        email=findViewById(R.id.email);
        add_alumno=findViewById(R.id.add_alumno);
    }
}

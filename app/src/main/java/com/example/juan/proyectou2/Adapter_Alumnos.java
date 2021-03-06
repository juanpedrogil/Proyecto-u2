package com.example.juan.proyectou2;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import static android.support.v4.content.ContextCompat.startActivity;

/**
 * Created by juan on 13/03/18.
 */

public class Adapter_Alumnos extends RecyclerView.Adapter<Adapter_Alumnos.ListaAlumnosViewHolder> {
    List<ItemAlumno> datos;
    public Adapter_Alumnos(List<ItemAlumno> datos){
        this.datos=datos;
    }

    @Override
    public ListaAlumnosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_alumno,parent,false);
        Adapter_Alumnos.ListaAlumnosViewHolder listaViewHolder=new Adapter_Alumnos.ListaAlumnosViewHolder(v);
        return listaViewHolder;
    }

    @Override
    public void onBindViewHolder(ListaAlumnosViewHolder holder, int position) {
        holder.creditos.setText(datos.get(position).getCreditosAcumulados());
        holder.carrera.setText(datos.get(position).getCarrera());
        holder.noControl.setText(datos.get(position).getNoControl());
        holder.nombre.setText(datos.get(position).getNombre());

    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    public static class ListaAlumnosViewHolder extends RecyclerView.ViewHolder{
        TextView nombre,noControl,carrera,creditos;
        Button mostrar;
        Context context;
        public ListaAlumnosViewHolder(View itemView) {
            super(itemView);
            nombre=itemView.findViewById(R.id.nombre);
            noControl=itemView.findViewById(R.id.control);
            carrera=itemView.findViewById(R.id.carrera);
            creditos=itemView.findViewById(R.id.creditos);
            mostrar=itemView.findViewById(R.id.mostrar);
            context=itemView.getContext();
            mostrar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent add_actividad_activity=new Intent(context,Ver_actividad.class);
                    add_actividad_activity.putExtra("alumno",nombre.getText().toString());
                    context.startActivity(add_actividad_activity);
                }
            });
        }
    }
}

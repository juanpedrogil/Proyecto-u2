package com.example.juan.proyectou2;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by juan on 13/03/18.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.ListaViewHolder> {
    List<Item> datos;
    @Override
    public ListaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        ListaViewHolder listaViewHolder=new ListaViewHolder(v);
        return listaViewHolder;
    }

    @Override
    public void onBindViewHolder(ListaViewHolder holder, int position) {
        holder.nombre.setText(datos.get(position).getNombre());
        holder.carrera.setText(datos.get(position).getCarrera());
        holder.actividad.setText(datos.get(position).getActividad());
        holder.fecha_ini.setText(datos.get(position).getFecha_ini());
        holder.fecha_fin.setText(datos.get(position).getFecha_fin());

    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    public Adapter(List<Item> datos){
        this.datos=datos;
    }

    public static class ListaViewHolder extends RecyclerView.ViewHolder{
        TextView nombre;
        TextView carrera;
        TextView actividad;
        TextView fecha_ini;
        TextView fecha_fin;
        public ListaViewHolder(View itemView) {
            super(itemView);
            nombre=itemView.findViewById(R.id.nombre);
            carrera=itemView.findViewById(R.id.carrera);
            actividad=itemView.findViewById(R.id.actividad);
            fecha_fin=itemView.findViewById(R.id.fecha_fin);
            fecha_ini=itemView.findViewById(R.id.fecha_ini);

        }
    }
}

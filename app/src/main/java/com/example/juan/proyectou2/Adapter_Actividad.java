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

public class Adapter_Actividad extends RecyclerView.Adapter<Adapter_Actividad.ListaActividadViewHolder>{
    List<ItemActividad> datos;
    public Adapter_Actividad(List<ItemActividad> datos){
        this.datos=datos;
    }

    @Override
    public Adapter_Actividad.ListaActividadViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_actividad,parent,false);
        Adapter_Actividad.ListaActividadViewHolder listaViewHolder=new Adapter_Actividad.ListaActividadViewHolder(v);
        return listaViewHolder;
    }

    @Override
    public void onBindViewHolder(Adapter_Actividad.ListaActividadViewHolder holder, int position) {
        holder.creditos.setText(datos.get(position).getCreditos());
        holder.actividad.setText(datos.get(position).getActividad());
        holder.fecha_fin.setText(datos.get(position).getFecha_fin());
        holder.fecha_ini.setText(datos.get(position).getFecha_ini());
        holder.nombre.setText(datos.get(position).getNombre());
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    public static class ListaActividadViewHolder extends RecyclerView.ViewHolder{
        TextView nombre,actividad,fecha_ini,fecha_fin,creditos;
        public ListaActividadViewHolder(View itemView) {
            super(itemView);
            nombre=itemView.findViewById(R.id.nombre);
            actividad=itemView.findViewById(R.id.actividad);
            fecha_ini=itemView.findViewById(R.id.fecha_ini);
            fecha_fin=itemView.findViewById(R.id.fecha_fin);
            creditos=itemView.findViewById(R.id.creditos);

        }
    }
}

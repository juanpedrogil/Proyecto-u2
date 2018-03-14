package com.example.juan.proyectou2;

/**
 * Created by juan on 13/03/18.
 */

public class ItemActividad {
    String nombre,actividad,fecha_ini,fecha_fin,creditos;

    public ItemActividad(String nombre, String actividad, String fecha_ini, String fecha_fin, String creditos) {
        this.nombre = nombre;
        this.actividad = actividad;
        this.fecha_ini = fecha_ini;
        this.fecha_fin = fecha_fin;
        this.creditos = creditos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public String getFecha_ini() {
        return fecha_ini;
    }

    public void setFecha_ini(String fecha_ini) {
        this.fecha_ini = fecha_ini;
    }

    public String getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public String getCreditos() {
        return creditos;
    }

    public void setCreditos(String creditos) {
        this.creditos = creditos;
    }
}

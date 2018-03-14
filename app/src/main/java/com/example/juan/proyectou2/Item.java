package com.example.juan.proyectou2;

/**
 * Created by juan on 13/03/18.
 */

public class Item {
     private String nombre;
     private String carrera;
     private String actividad;
     private String fecha_ini;
     private String fecha_fin;
     private String creditos;

    public String getCreditos() {
        return creditos;
    }

    public void setCreditos(String creditos) {
        this.creditos = creditos;
    }

    public Item(String nombre, String carrera, String actividad, String fecha_ini, String fecha_fin) {
        this.nombre = nombre;
        this.carrera = carrera;
        this.actividad = actividad;
        this.fecha_ini = fecha_ini;
        this.fecha_fin = fecha_fin;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
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
}

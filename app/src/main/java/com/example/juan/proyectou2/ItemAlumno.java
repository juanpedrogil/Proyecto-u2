package com.example.juan.proyectou2;

/**
 * Created by juan on 13/03/18.
 */

public class ItemAlumno {
    String nombre, carrera,creditosAcumulados,noControl;

    public ItemAlumno(String nombre, String carrera, String creditosAcumulados, String noControl) {
        this.nombre = nombre;
        this.carrera = carrera;
        this.creditosAcumulados = creditosAcumulados;
        this.noControl = noControl;
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

    public String getCreditosAcumulados() {
        return creditosAcumulados;
    }

    public void setCreditosAcumulados(String creditosAcumulados) {
        this.creditosAcumulados = creditosAcumulados;
    }

    public String getNoControl() {
        return noControl;
    }

    public void setNoControl(String noControl) {
        this.noControl = noControl;
    }
}

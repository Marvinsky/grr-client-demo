package com.spring.demo.beans.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by mabisrror on 1/14/17.
 */

public class Bean {

    private int idSpringBean;
    private String nombre;
    private String apellido;
    private String dni;
    private String fechaRegistro;

    public Bean(int idSpringBean, String nombre, String apellido, String dni, String fechaRegistro) {
        this.idSpringBean = idSpringBean;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaRegistro = fechaRegistro;
    }

    public Bean() {

    }

    public int getIdSpringBean() {
        return idSpringBean;
    }

    public void setIdSpringBean(int idSpringBean) {
        this.idSpringBean = idSpringBean;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}

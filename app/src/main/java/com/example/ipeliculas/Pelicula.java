package com.example.ipeliculas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Pelicula implements Serializable {
    static ArrayList<Pelicula> listaPelicula = new ArrayList<>();
    String titulo;
    String genero;
    float valoracion;
    String descricionLarga;
    String director;
    String descripcionCorta;
    int imagenResID;
    Date fechaDeEstreno;


    public Pelicula(String titulo, String genero, float valoracion, String descricionLarga, String descripcionCorta, int imagenResID,String director, Date fechaDeEstreno) {
        this.titulo = titulo;
        this.genero = genero;
        this.valoracion = valoracion;
        this.descricionLarga = descricionLarga;
        this.descripcionCorta = descripcionCorta;
        this.imagenResID = imagenResID;
        this.director = director;
        this.fechaDeEstreno = fechaDeEstreno;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Date getFechaDeEstreno() {
        return fechaDeEstreno;
    }

    public void setFechaDeEstreno(Date fechaDeEstreno) {
        this.fechaDeEstreno = fechaDeEstreno;
    }

    public int getImagenResID() {
        return imagenResID;
    }

    public void setImagenResID(int imagenResID) {
        this.imagenResID = imagenResID;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public float getValoracion() {
        return valoracion;
    }

    public void setValoracion(float valoracion) {
        this.valoracion = valoracion;
    }

    public String getDescricionLarga() {
        return descricionLarga;
    }

    public void setDescricionLarga(String descricionLarga) {
        this.descricionLarga = descricionLarga;
    }

    public String getDescripcionCorta() {
        return descripcionCorta;
    }

    public void setDescripcionCorta(String descripcionCorta) {
        this.descripcionCorta = descripcionCorta;
    }


}

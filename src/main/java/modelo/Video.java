/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;

/**
 *
 * @author Juan Albarracin
 */
public class Video {
    
   private  int idvideo;
   private int fkseries;
   private String titulo;
   private String director;
   private Date creacion;
   private String genero;

    public int getIdvideo() {
        return idvideo;
    }

    public void setIdvideo(int idvideo) {
        this.idvideo = idvideo;
    }

    public int getFkseries() {
        return fkseries;
    }

    public void setFkseries(int fkseries) {
        this.fkseries = fkseries;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Date getCreacion() {
        return creacion;
    }

    public void setCreacion(Date creacion) {
        this.creacion = creacion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Video{" + "idvideo=" + idvideo + ", fkseries=" + fkseries + ", titulo=" + titulo + ", director=" + director + ", creacion=" + creacion + ", genero=" + genero + '}';
    }
    
   
}

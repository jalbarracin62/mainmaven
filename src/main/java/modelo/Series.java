/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

//import java.util.Date;

public class Series
{
    private int idseries;
  private int nocapitulo;
  private int temporadas;

    public int getIdseries() {
        return idseries;
    }

    public void setIdseries(int idseries) {
        this.idseries = idseries;
    }

    public int getNocapitulo() {
        return nocapitulo;
    }

    public void setNocapitulo(int nocapitulo) {
        this.nocapitulo = nocapitulo;
    }

    public int getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    @Override
    public String toString() {
        return "Series{" + "idseries=" + idseries + ", nocapitulo=" + nocapitulo + ", temporadas=" + temporadas + '}';
    }

  
  
  
  
  
}
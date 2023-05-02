package com.ucompensar.biblioteca;
/**
 * @author Neyris
 */
public class Libro {
   private int codigoLibro, numeroPaginas;
   private String nombreLibro, autorLibro, materiaLibro;

    public Libro(int codigoLibro, int numeroPaginas, String nombreLibro, String autorLibro, String materiaLibro) {
        this.codigoLibro = codigoLibro;
        this.numeroPaginas = numeroPaginas;
        this.nombreLibro = nombreLibro;
        this.autorLibro = autorLibro;
        this.materiaLibro = materiaLibro;
    }

    public int getCodigoLibro() {
        return codigoLibro;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public String getNombreLibro() {
        return nombreLibro;
    }

    public String getAutorLibro() {
        return autorLibro;
    }

    public String getMateriaLibro() {
        return materiaLibro;
    }
    

    public void setCodigoLibro(int codigoLibro) {
        this.codigoLibro = codigoLibro;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public void setNombreLibro(String nombreLibro) {
        this.nombreLibro = nombreLibro;
    }

    public void setAutorLibro(String autorLibro) {
        this.autorLibro = autorLibro;
    }

    public void setMateriaLibro(String materiaLibro) {
        this.materiaLibro = materiaLibro;
    }  
}

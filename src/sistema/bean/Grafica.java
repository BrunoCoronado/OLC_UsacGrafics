/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.bean;

/**
 *
 * @author bruno
 */
public class Grafica {
    private String id;
    private String titulo;
    private String tituloX;
    private String tituloY;
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTituloX() {
        return tituloX;
    }

    public void setTituloX(String tituloX) {
        this.tituloX = tituloX;
    }

    public String getTituloY() {
        return tituloY;
    }

    public void setTituloY(String tituloY) {
        this.tituloY = tituloY;
    }

    public Grafica() {
    }

    public Grafica(String id, String titulo, String tituloX, String tituloY) {
        this.id = id;
        this.titulo = titulo;
        this.tituloX = tituloX;
        this.tituloY = tituloY;
    }
}

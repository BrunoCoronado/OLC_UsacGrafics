/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.bean;

import java.util.HashMap;

/**
 *
 * @author bruno
 */
public class XYLine {
    private String nombre;
    private String color;
    private int Grosor;
    private HashMap<Integer, Integer> puntos;

    public XYLine() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getGrosor() {
        return Grosor;
    }

    public void setGrosor(int Grosor) {
        this.Grosor = Grosor;
    }

    public HashMap<Integer, Integer> getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntoX, int puntoY) {
        this.puntos.put(puntoX, puntoY);
    }

    public XYLine(String nombre, String color, int Grosor, HashMap<Integer, Integer> puntos) {
        this.nombre = nombre;
        this.color = color;
        this.Grosor = Grosor;
        this.puntos = puntos;
    }
    
    
}

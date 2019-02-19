/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.bean;

import java.util.ArrayList;

/**
 *
 * @author bruno
 */
public class Galeria {
    private String nombre;
    private ArrayList<String> graficas;

    public Galeria() {
        graficas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<String> getGraficas() {
        return graficas;
    }

    public void setGraficas(String grafica) {
        this.graficas.add(grafica);
    }

    public Galeria(String nombre, ArrayList<String> graficas) {
        this.nombre = nombre;
        this.graficas = graficas;
    }
}

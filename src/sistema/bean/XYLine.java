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
public class XYLine {
        private String nombre;
        private String color;
        private int Grosor;
        private ArrayList<CoordenadaXY> puntos;

        public XYLine() {
            puntos = new ArrayList<>();
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

        public ArrayList<CoordenadaXY> getPuntos() {
            return puntos;
        }

        public void setPuntos(int puntoX, int puntoY) {
            this.puntos.add(new CoordenadaXY(puntoX, puntoY));
        }

        public XYLine(String nombre, String color, int Grosor, ArrayList<CoordenadaXY> puntos) {
            this.nombre = nombre;
            this.color = color;
            this.Grosor = Grosor;
            this.puntos = puntos;
        }
    }

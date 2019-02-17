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
public class GraficaBarras{
    private String id;
    private String titulo;
    private String tituloX;
    private String tituloY;
    private ArrayList<String> ejeX;
    private ArrayList<Integer> ejeY;
    private ArrayList<CoordenadaXY> puntosXY;

    public GraficaBarras() {
        id = "";
        titulo = "";
        tituloX = "";
        tituloY = "";
        ejeX = new ArrayList<>();
        ejeY = new ArrayList<>();
        puntosXY = new ArrayList<CoordenadaXY>();
    }
    
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
    
    public ArrayList<String> getEjeX() {
        return ejeX;
    }

    public void setEjeX(String ejeX) {
        this.ejeX.add(ejeX);
    }

    public ArrayList<Integer> getEjeY() {
        return ejeY;
    }

    public void setEjeY(int ejeY) {
        this.ejeY.add(ejeY);
    }

    public ArrayList<CoordenadaXY> getPuntosXY() {
        return puntosXY;
    }

    public void setPuntosXY(int puntoX, int puntoY) {
        this.puntosXY.add(new CoordenadaXY(puntoX, puntoY));
    }

    public GraficaBarras(String id, String titulo, String tituloX, String tituloY, ArrayList<String> ejeX, ArrayList<Integer> ejeY, ArrayList<CoordenadaXY> puntosXY) {
        this.id = id;
        this.titulo = titulo;
        this.tituloX = tituloX;
        this.tituloY = tituloY;
        this.ejeX = ejeX;
        this.ejeY = ejeY;
        this.puntosXY = puntosXY;
    }
    
    public class CoordenadaXY{
        private int coordenadaX;
        private int coordenadaY;

        public CoordenadaXY() {
        }

        public int getCoordenadaX() {
            return coordenadaX;
        }

        public void setCoordenadaX(int coordenadaX) {
            this.coordenadaX = coordenadaX;
        }

        public int getCoordenadaY() {
            return coordenadaY;
        }

        public void setCoordenadaY(int coordenadaY) {
            this.coordenadaY = coordenadaY;
        }

        public CoordenadaXY(int coordenadaX, int coordenadaY) {
            this.coordenadaX = coordenadaX;
            this.coordenadaY = coordenadaY;
        }
    }
}
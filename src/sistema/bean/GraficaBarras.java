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
public class GraficaBarras extends Grafica{
    private ArrayList<String> ejeX;
    private ArrayList<Integer> ejeY;
    private ArrayList<CoordenadaXY> puntosXY;

    public GraficaBarras() {
        super();
        ejeX = new ArrayList<>();
        ejeY = new ArrayList<>();
        puntosXY = new ArrayList<CoordenadaXY>();
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

    public GraficaBarras(ArrayList<String> ejeX, ArrayList<Integer> ejeY, ArrayList<CoordenadaXY> puntosXY, String id, String titulo, String tituloX, String tituloY) {
        super(id, titulo, tituloX, tituloY);
        this.ejeX = ejeX;
        this.ejeY = ejeY;
        this.puntosXY = puntosXY;
    }
}
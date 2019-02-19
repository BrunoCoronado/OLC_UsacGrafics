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
public class GraficaLineas extends Grafica{
    private ArrayList<XYLine> lineas;
    
    public GraficaLineas() {
        super();
        lineas = new ArrayList<>();
    }
    
    public ArrayList<XYLine> getLineas() {
        return lineas;
    }

    public void setLineas(XYLine linea) {
        this.lineas.add(linea);
    }

    public GraficaLineas(ArrayList<XYLine> lineas) {
        this.lineas = lineas;
    }

    public GraficaLineas(ArrayList<XYLine> lineas, String id, String titulo, String tituloX, String tituloY) {
        super(id, titulo, tituloX, tituloY);
        this.lineas = lineas;
    }
}

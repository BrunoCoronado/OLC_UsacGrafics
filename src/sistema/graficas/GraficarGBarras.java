/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.graficas;

import java.io.File;
import java.util.ArrayList;
import main.Main;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import sistema.bean.CoordenadaXY;
import sistema.bean.GraficaBarras;

/**
 *
 * @author bruno
 */
public class GraficarGBarras {
    
    public void graficarGB(ArrayList<String> graficas, String rutaCarpeta){
        try {
            DefaultCategoryDataset dataset; 
            JFreeChart graficaBarras;
            int width = 640;    
            int height = 480;

            ArrayList<String> ejeX;
            ArrayList<Integer> ejeY;
            ArrayList<CoordenadaXY> puntosXY;

            for (String nombreGrafica : graficas) {
                for (GraficaBarras grafica : Main.graficasDeBarras) {
                    try {
                        if(nombreGrafica.equals(grafica.getId())){
                            dataset = new DefaultCategoryDataset();

                            ejeX = grafica.getEjeX();
                            ejeY = grafica.getEjeY();
                            puntosXY = grafica.getPuntosXY();

                           for (CoordenadaXY coordenadaXY : puntosXY) {
                                try {   
                                    dataset.addValue(ejeY.get(coordenadaXY.getCoordenadaY()), ejeX.get(coordenadaXY.getCoordenadaX()), ejeX.get(coordenadaXY.getCoordenadaX()));
                                } catch (Exception e) {
                                    System.err.println("ERROR AL DIBUJAR GRAFICA DE BARRAS - CONTENIDO OMITIDO");
                                }
                           }
                           graficaBarras = ChartFactory.createBarChart(grafica.getTitulo(), grafica.getTituloX(), grafica.getTituloY(), dataset, PlotOrientation.VERTICAL, true, true, false);
                           File gBarras = new File(rutaCarpeta +"\\"+grafica.getId()+".PNG");
                           ChartUtilities.saveChartAsPNG(gBarras, graficaBarras, width, height);
                        }
                    } catch (Exception e) {
                        System.err.println("ERROR AL DIBUJAR GRAFICA DE BARRAS - CONTENIDO OMITIDO");
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("ERROR AL GENERAR LAS GRAFICAS DE BARRAS");
        }
    }
}

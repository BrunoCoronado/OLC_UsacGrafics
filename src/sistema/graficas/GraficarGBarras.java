/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.graficas;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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
    public void graficarGB(ArrayList<GraficaBarras> graficas) throws IOException{
        DefaultCategoryDataset dataset; 
        JFreeChart graficaBarras;
        int width = 640;    
        int height = 480;
        
        ArrayList<String> ejeX;
        ArrayList<Integer> ejeY;
        ArrayList<CoordenadaXY> puntosXY;
        
        for (GraficaBarras grafica : graficas) {
            dataset = new DefaultCategoryDataset();
            
             ejeX = grafica.getEjeX();
             ejeY = grafica.getEjeY();
             puntosXY = grafica.getPuntosXY();
            
            for (CoordenadaXY coordenadaXY : puntosXY) {
                dataset.addValue(ejeY.get(coordenadaXY.getCoordenadaY()), ejeX.get(coordenadaXY.getCoordenadaX()), ejeX.get(coordenadaXY.getCoordenadaX()));
            }
            
            graficaBarras = ChartFactory.createBarChart(grafica.getTitulo(), grafica.getTituloX(), grafica.getTituloY(), dataset, PlotOrientation.VERTICAL, true, true, false);
            File gBarras = new File(grafica.getId());
            ChartUtilities.saveChartAsPNG(gBarras, graficaBarras, width, height);
        }
    }
}

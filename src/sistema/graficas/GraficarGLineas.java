/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.graficas;

import java.awt.BasicStroke;
import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import main.Main;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import sistema.bean.CoordenadaXY;
import sistema.bean.GraficaLineas;
import sistema.bean.XYLine;

/**
 *
 * @author bruno
 */
public class GraficarGLineas {
    
    public void graficarGB(ArrayList<String> graficas, String rutaCarpeta){
        try {
            ArrayList<XYSeries> series;
            XYSeriesCollection dataset;
            XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
            XYSeries xySeries;
            JFreeChart graficaXY;
            int width = 640;    
            int height = 480;

            for (String nombreGrafica : graficas) {
                for (GraficaLineas grafica : Main.graficasDeLineas) {
                    try {
                        if(nombreGrafica.equals(grafica.getId())){
                            series = new ArrayList<>();
                            dataset = new XYSeriesCollection();
                            for (XYLine linea : grafica.getLineas()) {
                                xySeries = new XYSeries(linea.getNombre());
                                for (CoordenadaXY coordenada : linea.getPuntos()) {
                                    xySeries.add(coordenada.getCoordenadaX(), coordenada.getCoordenadaY());
                                }
                                dataset.addSeries(xySeries);
                            }
                            graficaXY = ChartFactory.createXYLineChart(grafica.getTitulo(), grafica.getTituloX(), grafica.getTituloY(), dataset, PlotOrientation.VERTICAL, true, true, false);
                            XYPlot plot = graficaXY.getXYPlot();
                            for (int i = 0; i < grafica.getLineas().size(); i++) {
                                renderer.setSeriesPaint(i, obtenerColor(grafica.getLineas().get(i).getColor()));
                                renderer.setSeriesStroke(i, new BasicStroke(grafica.getLineas().get(i).getGrosor()));
                            }
                            plot.setRenderer(renderer);
                            File XYChart = new File(rutaCarpeta +"\\"+grafica.getId()+".PNG");
                            ChartUtilities.saveChartAsPNG(XYChart, graficaXY, width, height);
                        }
                    } catch (Exception e) {
                        System.err.println("ERROR AL DIBUJAR GRAFICA DE LINEAS - CONTENIDO OMITIDO");
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("ERROR AL GENERAR LAS GRAFICAS DE LINEAS");
        }
        
    }
    
    private Color obtenerColor(String color){
        color = color.toLowerCase();
        switch(color){
            case "azul": return Color.BLUE;
            case "amarillo": return Color.YELLOW;
            case "verde": return Color.GREEN;
            default: return Color.RED;
        }
    }
}

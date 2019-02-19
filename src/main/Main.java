/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.ArrayList;
import sistema.bean.Galeria;
import sistema.bean.GraficaBarras;
import sistema.bean.GraficaLineas;
import sistema.bean.Variable;
import sistema.ui.VentanaPrincipal;

/**
 *
 * @author bruno
 */
public class Main {
    public static ArrayList<Variable> variablesGlobales;
    public static ArrayList<GraficaBarras> graficasDeBarras;
    public static ArrayList<GraficaLineas> graficasDeLineas;
    public static ArrayList<Galeria> galerias;
    
    public static void main(String[] args) {
        VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
        ventanaPrincipal.setVisible(true);
    }
    
    public static Object buscarVariableGlobal(String identificador){
        for (Variable variableGlobal : variablesGlobales) {
            if(variableGlobal.getIdentificador().equals(identificador)){
                return variableGlobal.getValor();
            }
        }
        return null;
    }
}

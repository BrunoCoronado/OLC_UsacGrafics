/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.administracion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/**
 *
 * @author bruno
 */
public class AdministracionArchivos {
    
    public String abrirArchivo(String ruta){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(ruta));
            String texto = "";
            String linea = reader.readLine();
            while(linea != null){
                texto += linea + "\n";
                linea = reader.readLine();
            }
            return texto;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
    
    public void guardarArchivo(String ruta, String texto, int tipo){
        try {
            BufferedWriter writer;
            if(tipo == 1)
                writer = new BufferedWriter(new FileWriter(ruta, true));
           else
                writer = new BufferedWriter(new FileWriter(ruta, false));
            writer.write(texto);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

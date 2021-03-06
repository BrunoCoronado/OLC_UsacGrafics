/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.graficas;

import java.io.BufferedWriter;
import java.io.FileWriter;
import main.Main;
import sistema.bean.Token;

/**
 *
 * @author bruno
 */
public class GraficarTokens {
    public void graficarListaTokens(){
        try{
            if(Main.tokens.size() != 0){
                BufferedWriter writer = new BufferedWriter(new FileWriter("tokens.html", false));
                writer.write("<!DOCTYPE html>\n<html>\n<head>\n<title>Reporte de Tokens</title>\n</head>\n<body>\n<h1 align=\"center\">Reporte de Tokens</h1>\n<style type=\"text/css\">\n.tg  {border-collapse:collapse;border-spacing:0;margin:0px auto;}\n.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:black;}\n.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:black;}\n.tg .tg-4tse{background-color:#32cb00;color:#000000;text-align:left;vertical-align:top}\n.tg .tg-0lax{text-align:left;vertical-align:top}\nh1{font-family:Arial, sans-serif}\n</style>");
                writer.write("<table class=\"tg\">");
                writer.write("<tr>\n<th class=\"tg-4tse\">No</th>\n<th class=\"tg-4tse\">Lexema</th>\n<th class=\"tg-4tse\">Tipo</th>\n<th class=\"tg-4tse\">Columna</th>\n<th class=\"tg-4tse\">Linea</th>\n</tr>");
                int i = 0;
                for (Token token : Main.tokens) {
                    writer.write("<tr>");
                    writer.write("<td class=\"tg-0Lax\">" + i++ + "<br></td>");
                    writer.write("<td Class=\"tg-0Lax\">" + token.getLexema() + "</td>");
                    writer.write("<td class=\"tg-0Lax\">" + token.getTipo() + "</td>");
                    writer.write("<td Class=\"tg-0Lax\">" + token.getColumna() + "</td>");
                    writer.write("<td class=\"tg-0Lax\">" + token.getFila() + "</td>");
                    writer.write("</tr>");
                }
                writer.write("</body>\n</html>");
                writer.close();
                String [] cmd = {"cmd.exe", "/c", "start", "tokens.html" };
                Runtime.getRuntime().exec(cmd);
            }
        }catch(Exception ex){System.out.println("Error Graficando Tokens...");}
    }
    
    public void graficarListaErrores(){
        try{
            if(Main.errores.size() != 0){
                BufferedWriter writer = new BufferedWriter(new FileWriter("errores.html", false));
                writer.write("<!DOCTYPE html>\n<html>\n<head>\n<title>Reporte de Errores</title>\n</head>\n<body>\n<h1 align=\"center\">Reporte de Errores</h1>\n<style type=\"text/css\">\n.tg  {border-collapse:collapse;border-spacing:0;margin:0px auto;}\n.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:black;}\n.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:black;}\n.tg .tg-4tse{background-color:#cb0d00;color:#000000;text-align:left;vertical-align:top}\n.tg .tg-0lax{text-align:left;vertical-align:top}\nh1{font-family:Arial, sans-serif}\n</style>");
                writer.write("<table class=\"tg\">");
                writer.write("<tr>\n<th class=\"tg-4tse\">No</th>\n<th class=\"tg-4tse\">Lexema</th>\n<th class=\"tg-4tse\">Tipo</th>\n<th class=\"tg-4tse\">Columna</th>\n<th class=\"tg-4tse\">Linea</th>\n</tr>");
                int i = 0;
                for (Token token : Main.errores) {
                    writer.write("<tr>");
                    writer.write("<td class=\"tg-0Lax\">" + i + "<br></td>");
                    writer.write("<td Class=\"tg-0Lax\">" + token.getLexema() + "</td>");
                    writer.write("<td class=\"tg-0Lax\">" + token.getTipo() + "</td>");
                    writer.write("<td Class=\"tg-0Lax\">" + token.getColumna() + "</td>");
                    writer.write("<td class=\"tg-0Lax\">" + token.getFila() + "</td>");
                    writer.write("</tr>");
                }
                writer.write("</body>\n</html>");
                writer.close();
                String [] cmd = {"cmd.exe", "/c", "start", "errores.html" };
                Runtime.getRuntime().exec(cmd);
            }
        }catch(Exception ex){System.out.println("Error Graficando Errores...");}
    }
}

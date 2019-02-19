/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.io.StringReader;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;
import main.Main;
import sistema.administracion.AdministracionArchivos;
import sistema.analisis.scanner;
import sistema.analisis.parser;

/**
 *
 * @author bruno
 */
public class VentanaPrincipal extends javax.swing.JFrame {
    //definicion botones ui
    private JButton btnAbrir;
    private JButton btnGuardar;
    private JButton btnAnalizar;
    private JButton btnGuardarComo;
    private JButton btnReporteErrores;
    //definicion area de texto
    private JTextArea txtArea;
    //definicion del file chooser
    private JFileChooser fileChooser;
    //declaracion clase administrativa
    private AdministracionArchivos administracionArchivos;
    
    /**
     * Creates new form ventanaPrincipal
     */
    public VentanaPrincipal() {
        initComponents();
        configuracionVentana();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void configuracionVentana(){
        //propiedades de la ventana
        this.setSize(1250, 1000);
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        //elementos de la ventana
        //panel de opciones
        JPanel panelOpciones = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnAbrir = new JButton("Abrir");
        btnGuardar = new JButton("Guardar");
        btnGuardarComo = new JButton("Guardar Como");
        btnReporteErrores = new JButton("Reporte Errores");
        panelOpciones.add(btnAbrir);
        panelOpciones.add(btnGuardar);
        panelOpciones.add(btnGuardarComo);
        panelOpciones.add(btnReporteErrores);
        this.add(panelOpciones, BorderLayout.PAGE_START);
        //panel de texto
        txtArea = new JTextArea();
        JScrollPane scroll = new JScrollPane(txtArea);
        this.add(scroll, BorderLayout.CENTER);
        //pie de ventana
        JPanel panelPie = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btnAnalizar = new JButton("Analizar");
        panelPie.add(btnAnalizar);
        this.add(panelPie, BorderLayout.PAGE_END);
        //instanciacion del file chooser y la clase administrativa
        fileChooser = new JFileChooser();
        administracionArchivos = new AdministracionArchivos();
        //definicion del filtro para archivos
        FileNameExtensionFilter filtro = new FileNameExtensionFilter(".gu", "gu");
        fileChooser.setFileFilter(filtro);
        inicializarFuncionamientoBotones();
    }
    
    private void inicializarFuncionamientoBotones(){
        //funcionamiento al boton
        btnAnalizar.addActionListener((ActionEvent ae) -> {
            btnAnalizar(ae);
        });
        
        btnAbrir.addActionListener((ae) -> {
            btnAbrirArchivo(ae);
        });
        btnGuardar.addActionListener((ae) -> {
            btnGuardarArchivo(ae, 1);
        });
        btnGuardarComo.addActionListener((ae) -> {
            btnGuardarArchivo(ae, 2);
        });
    }

    private void btnAnalizar(java.awt.event.ActionEvent evt){
        try {
            limpiarContenidoGlobal();
            StringReader strReader = new StringReader(limpiarTexto(txtArea.getText())+"$");
            scanner scanner = new scanner(strReader);
            sistema.analisis.parser parser = new parser(scanner);
            parser.parse();
            if(Main.variablesGlobales.size() > 0){
                Main.variablesGlobales.forEach((v) -> {
                    System.out.println(v.getIdentificador() + " | " + v.getTipo() + " | " + v.getValor());
                });
            }
            if(Main.graficasDeBarras.size() > 0){
                Main.graficasDeBarras.forEach((g) -> {
                    System.out.println(g.getId());
                });
            }
            if(Main.graficasDeLineas.size() > 0){
                Main.graficasDeLineas.forEach((g) -> {
                    System.out.println(g.getId());
                });
            }
                if(Main.galerias.size() > 0){
                Main.galerias.forEach((g) -> {
                    System.out.println(g.getNombre());
                });
            }
        } catch (Exception e) {
            System.out.println("Error al analizar la entrada");
            e.printStackTrace();
        }
    }
    
    private void limpiarContenidoGlobal(){
        Main.variablesGlobales = new ArrayList<>();
        Main.graficasDeBarras = new ArrayList<>();
        Main.graficasDeLineas = new ArrayList<>();
        Main.galerias = new ArrayList<>();
    }
    
    private String limpiarTexto(String texto){
        if(texto.contains("“"))
            texto = texto.replace('“', '\"');
        if(texto.contains("”"))
            texto = texto.replace('”', '\"');
        return texto;
    }
    
    private void btnAbrirArchivo(java.awt.event.ActionEvent evt){
        try {
            int retorno = fileChooser.showOpenDialog(this);
            if(retorno == JFileChooser.APPROVE_OPTION){
                this.setTitle(fileChooser.getSelectedFile().getPath());
                txtArea.setText(administracionArchivos.abrirArchivo(fileChooser.getSelectedFile().getPath()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void btnGuardarArchivo(java.awt.event.ActionEvent evt, int tipo){
        switch(tipo){
                case 1://guardar normal
                    if(!this.getTitle().equals("")){
                        administracionArchivos.guardarArchivo(this.getTitle(), txtArea.getText(), 1);
                    }else{
                        JOptionPane.showMessageDialog(this, "No existe referencia a un archivo", "Error al Guardar", JOptionPane.WARNING_MESSAGE);
                    }
                    break;
                case 2://guardar como
                        int retorno = fileChooser.showSaveDialog(this);
                        if(retorno == JFileChooser.APPROVE_OPTION){
                            this.setTitle(fileChooser.getSelectedFile().getPath()+".gu");
                            administracionArchivos.guardarArchivo(fileChooser.getSelectedFile().getPath()+".gu", txtArea.getText(), 2);
                        }
                    break;
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

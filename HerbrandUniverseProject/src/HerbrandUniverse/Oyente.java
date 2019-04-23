/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HerbrandUniverse;

import Analizador.ParseException;
import Analizador.Analizador;
import Analizador.TokenMgrError;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Roman Pomares
 */
public class Oyente extends PanelEvento implements ActionListener {

    private final PanelEvento panel;
    boolean hayTexto = true;
    Date horaEje = new Date();

    public Oyente(PanelEvento panel) {
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String opcion = e.getActionCommand();
        switch (opcion) {
            case "Ejecutar":
                try {
                    analizar();
                } catch (ParseException | TokenMgrError | IOException ex) {
                    Logger.getLogger(Oyente.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case "Abrir Archivo":
                comprobarTexto();
                if (hayTexto) {
                    try {
                        guardarAbrir();
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(Oyente.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(Oyente.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    try {
                        abrirArchivo();
                        hayTexto = true;
                    } catch (IOException ex) {
                        Logger.getLogger(Oyente.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
            case "Limpiar Todo":
                panel.getAreaCodigo().setText("");
                panel.getAreaResultado().setText("");
                panel.contarFilas();
                break;
            case "Guardar Archivo":
                try {
                    guardarArchivo();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Oyente.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Oyente.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case "Información":
                mensajeVersion();
                break;
            case "Salir":
                comprobarTexto();
                if (!hayTexto) {
                    System.exit(0);
                } else {
                    try {
                        guardarSalir();
                    } catch (IOException ex) {
                        Logger.getLogger(Oyente.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
        }
    }

    private void analizar() throws ParseException, TokenMgrError, IOException {
        //String archivo_temporal = "C:/Users/Roman Pomares/OneDrive/Documentos/NetBeansProjects/HerbrandUniverseProject/src/Archivos/archivo.txt";
        String archivo_temporal = "C:/Users/roman/OneDrive/Documentos/NetBeansProjects/HerbrandUniverseProject/src/Archivos/archivo.txt";

        try {
            String[] codigo = panel.getAreaCodigo().getText().split("\n");
            File dock = new File(archivo_temporal);
            PrintWriter pw = new PrintWriter(dock);

            for (int i = 0; i < codigo.length; i++) {
                pw.println(codigo[i]);
            }
            pw.flush();

            InputStream archivo = new FileInputStream(archivo_temporal);
            Analizador analisis = new Analizador(archivo);
            Analizador.listaTokens.clear();
            Analizador.listaTokensPuros.clear();
            Analizador.listaFunciones.clear();
            Analizador.listaConstantes.clear();
            Analizador.listaVariables.clear();
            analisis.iniciar();

            panel.getAreaResultado().setText(horaEje.toLocaleString() + "\nCompilación exitosa:");
            mostrarResultados();

            //Inicia Algoritmo de Herbrand
            int nivel = (Integer) panel.getSpinnerNivel().getValue();
            generarUniverso(nivel);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Oyente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            /*String titulo = String.valueOf(panel.getMensajeSintatico().getMessage());
             int tipoMensaje = panel.getMensajeSintatico().getMessageType();
             panel.getMensajeSintatico().showMessageDialog(null, ex.getMessage(), titulo, tipoMensaje);*/
            panel.getAreaResultado().setText(horaEje.toLocaleString() + "_____ " + ex.getMessage());
            moverCursor(ex.getMessage());
            System.out.println("Algo sintactico no funciono");
        } catch (TokenMgrError ex) {
            /*String titulo = String.valueOf(panel.getMensajeLexico().getMessage());
             int tipoMensaje = panel.getMensajeLexico().getMessageType();
             panel.getMensajeLexico().showMessageDialog(null, ex.getMessage(), titulo, tipoMensaje);*/
            panel.getAreaResultado().setText(horaEje.toLocaleString() + "_____ " + ex.getMessage());
            System.out.println("Uno o mas Token invalido");
        }
    }

    private String abrirArchivo() throws FileNotFoundException, IOException {
        StringBuilder brinco = new StringBuilder();
        panel.getBuscadorAbrir().setAcceptAllFileFilterUsed(true);
        int n = panel.getBuscadorAbrir().showOpenDialog(panel);
        int m = panel.getBuscadorAbrir().getApproveButtonMnemonic();// es lo mismo que JFileChooser.APPROVE_OPTION
        String archivoNombre = panel.getBuscadorAbrir().getSelectedFile().getAbsolutePath();
        if (n == m) {

            System.out.println("Directorio: " + archivoNombre);
            BufferedReader br = new BufferedReader(new FileReader(archivoNombre));
            do {
                brinco.append(br.readLine()).append("\n");
            } while (br.ready());
            panel.getAreaCodigo().setText(brinco.toString() + "\n");
            panel.getAreaResultado().setText(horaEje.toLocaleString() + "Se abrio El archivo " + archivoNombre);
            panel.getLabelDirecctorio().setText("Directorio del Archivo: " + archivoNombre);
            panel.contarFilas();

        }
        return archivoNombre;
    }

    private void guardarArchivo() throws FileNotFoundException, IOException {

        panel.getBuscadorAbrir().setAcceptAllFileFilterUsed(true);
        int g = panel.getBuscadorAbrir().showSaveDialog(null);
        int j = panel.getBuscadorAbrir().getApproveButtonMnemonic();
        if (g == j) {
            File file = panel.getBuscadorAbrir().getSelectedFile();
            String direccion = file.getPath();
            FileOutputStream fos = new FileOutputStream(direccion);
            fos.write(panel.getAreaCodigo().getText().getBytes());
            fos.close();
            panel.getAreaResultado().setText(horaEje.toLocaleString() + "Se guardo el archivo en: " + file);
        }
    }

    private void mostrarResultados() {
        String resultado = panel.getAreaResultado().getText() + "\n";
        for (String lisTokens : Analizador.listaTokens) {
            resultado += lisTokens + "\n";
        }
        panel.getAreaResultado().setText(resultado);
    }

    private void generarUniverso(int nivel) {

        Herbrand n = new Herbrand(Analizador.listaTokensPuros, Analizador.listaFunciones, Analizador.listaConstantes, Analizador.listaVariables);
        panel.getTableUniverso().setModel(n.HerbrandAlgorithm(nivel));

//        List<Object> lista = new ArrayList<>();
//
//        funcion f1 = new funcion("f");
//        f1.getParametros().add(new String("a"));
//        f1.getParametros().add(new String("a"));
//
//        funcion f2 = new funcion("f");
//        f2.getParametros().add(new String("a"));
//        f2.getParametros().add(new String("b"));
//
//        funcion f3 = new funcion("f");
//        f3.getParametros().add(new String("b"));
//        f3.getParametros().add(new String("a"));
//
//        funcion f4 = new funcion("f");
//        f4.getParametros().add(new String("b"));
//        f4.getParametros().add(new String("b"));
//
//        funcion f5 = new funcion("f");
//        f5.getParametros().add(new String("a"));
//        f5.getParametros().add(f1);
//
//        funcion f6 = new funcion("f");
//        f6.getParametros().add(new String("a"));
//        f6.getParametros().add(f2);
//
//        funcion f7 = new funcion("f");
//        f7.getParametros().add(new String("a"));
//        f7.getParametros().add(f3);
//
//        funcion f8 = new funcion("f");
//        f8.getParametros().add(new String("a"));
//        f8.getParametros().add(f4);
//
//        lista.add(new String("a"));
//        lista.add(new String("b"));
//        lista.add(f1);
//        lista.add(f2);
//        lista.add(f3);
//        lista.add(f4);
//        lista.add(f5);
//        lista.add(f6);
//        lista.add(f7);
//        lista.add(f8);
        //f8.imprimirFuncion();
//        imprimirLista(lista);
    }

    private void mensajeVersion() {
        String titulo = String.valueOf(panel.getMensajeVersion().getMessage());
        int tipoMensaje = panel.getMensajeVersion().getMessageType();
        JOptionPane.showMessageDialog(null, "Version 1.3\n\n"
                + "Constante: [ a - e ]\n"
                + "Predicado: [ P - Z ]\n"
                + "Variable; [ w - z ]\n"
                + "Funcion: [ f - k ]\n"
                + "Negacion: [ ~ ]\n"
                + "\nAutor:\nPomares Angelino José Roman", titulo, tipoMensaje);
    }

    private void mensajeExito() {
        String titulo = String.valueOf(panel.getMesajeExito().getMessage());
        int tipoMensaje = panel.getMesajeExito().getMessageType();
        panel.getMesajeExito().showMessageDialog(null, "Compilacion exitosa", titulo, tipoMensaje);
    }

    private void moverCursor(String message) {
        String[] tokens = message.split(" ");
        int fila = -1, columna = -1;
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("line")) {
                fila = 0;
                for (int j = 0; j < tokens[i + 1].length(); j++) {
                    if (Character.isDigit(tokens[i + 1].charAt(j))) {
                        fila *= 10;
                        fila += (tokens[i + 1].charAt(j) - '0');
                    } else {
                        break;
                    }
                }
                //fila = Integer.parseInt(tokens[i+1].trim());

            } else if (tokens[i].equals("column")) {
                columna = 0;
                for (int j = 0; j < tokens[i + 1].length(); j++) {
                    if (Character.isDigit(tokens[i + 1].charAt(j))) {
                        columna *= 10;
                        columna += (tokens[i + 1].charAt(j) - '0');
                    } else {
                        break;
                    }
                }
            }
        }
        try {
            panel.getAreaCodigo().setCaretPosition(panel.getAreaCodigo().getLineStartOffset(fila - 1) + columna - 1);
        } catch (Exception ex) {
        }
    }

    private void comprobarTexto() {
        String comprobarTexto = panel.getAreaCodigo().getText();
        comprobarTexto = comprobarTexto.replaceAll(" ", "");
        comprobarTexto = comprobarTexto.replaceAll("\n", "");
        comprobarTexto = comprobarTexto.replaceAll("\t", "");
        comprobarTexto = comprobarTexto.replaceAll("\r", "");
        if (comprobarTexto.length() == 0) {
            hayTexto = false;
            System.out.println("Np hay textp -" + comprobarTexto.length() + "\t");
        }
    }

    private void guardarSalir() throws IOException {
        switch (JOptionPane.showConfirmDialog(this, "Desea Guardar Los cambios efectuados?")) {
            case JOptionPane.YES_OPTION:
                guardarArchivo();
                System.exit(0);
                break;
            case JOptionPane.NO_OPTION:
                System.exit(0);
                break;
        }
    }

    private void guardarAbrir() throws IOException {

        switch (JOptionPane.showConfirmDialog(this, "Desea Guardar Los cambios efectuados?")) {
            case JOptionPane.YES_OPTION:
                guardarArchivo();
                abrirArchivo();
                panel.getAreaResultado().setText(horaEje.toLocaleString() + "Se guardo y/o abrio archivos");
                break;
            case JOptionPane.NO_OPTION:
                abrirArchivo();
                break;
        }
    }
}

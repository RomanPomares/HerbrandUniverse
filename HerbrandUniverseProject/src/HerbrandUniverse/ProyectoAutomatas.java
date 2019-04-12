/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HerbrandUniverse;

import javax.swing.*;

/**
 *
 * @author Roman Pomares
 */
public class ProyectoAutomatas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JFrame f= new JFrame("Universo de Herbrand");
        f.setSize(900, 500);
        //f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
       
        PanelEvento panel= new PanelEvento();
        Oyente oyente=new Oyente(panel);
        panel.addEventos(oyente);
        f.setJMenuBar(panel.getBarraMenu1());
        f.setContentPane(panel);
        f.setVisible(true);
        
    }
    
}

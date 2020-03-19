/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s4;

import javax.swing.JFrame;

/**
 *
 * @author sergio
 */
public class Cliente {

    /**
     * @param args the command line arguments
     */
    
    PanelBotones panel;
    GestorFiltros gestor;
            
    public Cliente() {
        panel = new PanelBotones();
        panel.setCliente(this);
        gestor = new GestorFiltros();
        Thread hebra = new Thread(panel);
        JFrame f = new JFrame();
        f.add(panel);
        f.setSize(400, 200);
        f.setVisible(true);
        hebra.start();
    }

    void ejecutar(EstadoMotor estado){
        gestor.ejecutar(estado);
    }
    
    public static void main(String args[]){
        Cliente cliente = new Cliente();
    }
    
}



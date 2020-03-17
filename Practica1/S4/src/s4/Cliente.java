/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s4;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author sergio
 */
public class Cliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Crear objetivo (coche)
        Coche coche = new Coche();
        coche.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        
        // Iniciar gestor de filtros del coche
        GestorFiltros gestor = new GestorFiltros();
        gestor.peticionFiltros(coche);
    }
    
}

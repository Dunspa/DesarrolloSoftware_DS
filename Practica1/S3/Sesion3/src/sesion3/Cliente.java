/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sesion3;

/**
 *
 * @author sergio
 */
public class Cliente {
   
    public static void main(String[] args) {
        Termometro termo = new Termometro();
        pantallaTemperatura pantalla = new pantallaTemperatura(termo);
        termo.addObserver(pantalla);
        Thread t = new Thread(termo);
        t.start();
        pantalla.setVisible(true);
    }
    
}

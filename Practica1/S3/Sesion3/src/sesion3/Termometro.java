/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sesion3;

import static java.lang.Thread.sleep;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author sergio
 */
public class Termometro extends java.util.Observable implements Runnable{
    public Float temp;
    
    Random rand = new Random();

    public Termometro() {
        temp = new Float(0.0);
    }

    @Override
    public void run() {
        while (true){
            try {
                sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Termometro.class.getName()).log(Level.SEVERE, null, ex);
            }
            temp = new Float(rand.nextFloat());
            this.setChanged();
            this.notifyObservers();
        }
        
    }

    public float getTemperatura() {
        return temp.floatValue();
    }
    
    
    
    
}

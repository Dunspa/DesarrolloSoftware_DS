package sesion3;

import static java.lang.Thread.sleep;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Termometro extends java.util.Observable implements Runnable{
    public Float temperaturaCelsius;
    public Float temperaturaFahrenheit;
    
    Random rand = new Random();

    public Termometro() {
        temperaturaCelsius = new Float(0.0);
        temperaturaFahrenheit = new Float(0.0);
    }

    @Override
    public void run() {
        float Tmax = 100;
        float Tmin = -100;
        
        while (true){
            try {
                sleep(3000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Termometro.class.getName()).log(Level.SEVERE, null, ex);
            }
            setTemperatura(rand.nextFloat() * (Tmax - Tmin) + Tmin);
        }
        
    }

    public float getTemperaturaCelsius() {
        return temperaturaCelsius;
    }
    
    public float getTemperaturaFahrenheit() {
        return temperaturaFahrenheit;
    }
    
    public void setTemperatura(Float t) {
        temperaturaCelsius = t;
        temperaturaFahrenheit = ((temperaturaCelsius / 5) * 9) + 32; 
        this.setChanged();
        this.notifyObservers();
    }
}

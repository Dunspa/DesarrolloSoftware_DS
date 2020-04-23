package SCACV_Modelo;

import SCACV_Modelo.EstadoMotor;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;
import java.util.Random;
import javax.swing.BorderFactory;

/**
 *
 * @author jlgallego99
 */
public class Coche {
    
    double distanciaAcumulada;
    double distanciaActual;
    double velocidad;
    double velocidad_SCACV;
    double rpm;
    double combustible;
    double momentUpdate;
    double revolucionesAnteriores;
    double aumentoRev;
    double cuentaRevAceite;
    double cuentaRevFrenos;
    double cuentaRevGeneral;
    
    public Coche() {
        /*velocimetro.setBorder(BorderFactory.createTitledBorder("Velocímetro"));
        cuentakilometros.setBorder(BorderFactory.createTitledBorder("Cuentakilómetros"));
        cuentarrevoluciones.setBorder(BorderFactory.createTitledBorder("Cuentarrevoluciones"));*/
        Random random = new Random();
        distanciaAcumulada = 0.0;
        distanciaActual = 0.0;
        velocidad = 0.0;
        velocidad_SCACV = 0.0;
        rpm = 0.0;
        momentUpdate = System.currentTimeMillis();
        combustible = random.nextInt(500);
        revolucionesAnteriores = 1.0;
        aumentoRev = 0.0;
        cuentaRevAceite = 0.0;
        cuentaRevFrenos = 0.0;
        cuentaRevGeneral = 0.0;
    }
    
    public void ejecutar(double revoluciones, EstadoMotor estado, EstadoPalanca estadoPalanca){
        revolucionesAnteriores = velocidad/(2.0 * Math.PI * 0.15 * (60.0/1000.0)) * (System.currentTimeMillis()-momentUpdate)/60000;
        cuentaRevAceite += revolucionesAnteriores;
        cuentaRevFrenos += revolucionesAnteriores;
        cuentaRevGeneral += revolucionesAnteriores;
        
        momentUpdate = System.currentTimeMillis();
        
        
        if (estadoPalanca == EstadoPalanca.MANTENER) {
            velocidad_SCACV = velocidad;
        }
        else if (estadoPalanca == EstadoPalanca.REINICIAR) {
            velocidad = 2.0 * Math.PI * 0.15 * revoluciones * (60.0/1000.0);
            System.out.println(velocidad);
            System.out.println(revoluciones);
            
            if (velocidad >= velocidad_SCACV) {
                System.out.println(velocidad);
                velocidad = velocidad_SCACV;
            }
        }
        else if (estadoPalanca != EstadoPalanca.MANTENER) {
            velocidad = 2.0 * Math.PI * 0.15 * revoluciones * (60.0/1000.0);
        }
        
        double distancia_recorrida = velocidad/3600.0;
        distanciaActual += distancia_recorrida;
        distanciaAcumulada += distancia_recorrida;
        rpm = revoluciones;
        
        if(estado == EstadoMotor.APAGADO){
            distanciaActual = 0.0;
        }
        if(estado != EstadoMotor.APAGADO){
            combustible -= revolucionesAnteriores * revolucionesAnteriores * 5 * Math.pow(10, -10);
            if(combustible < 0){
                combustible = 0;
            }
        }
        
    }
    
    public double getDistanciaAcumulada() {
        return distanciaAcumulada;
    }
    
    public double getDistanciaActual() {
        return distanciaActual;
    }
    
    public double getVelocidad() {
        return velocidad;
    }
    
    public double getVelocidadSCACV() {
        return velocidad_SCACV;
    }
    
    public double getRPM() {
        return rpm;
    }
    
    public double getCombustible() {
        return combustible;
    }
    
    public void setCuentaRevAceite(double d) {
        cuentaRevAceite = d;
    }
                
    public void setCuentaRevFrenos(double d) {
        cuentaRevFrenos = d;
    }

    public void setCuentaRevGeneral(double d) {
        cuentaRevGeneral = d;
    }
    
    public double getCuentaRevAceite() {
        return cuentaRevAceite;
    }
                
    public double getCuentaRevFrenos() {
        return cuentaRevFrenos;
    }

    public double getCuentaRevGeneral() {
        return cuentaRevGeneral;
    }

    public void setCombustible(double d) {
        combustible = d;
    }
}
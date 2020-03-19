/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s4;

/**
 *
 * @author sergio
 */
public class FiltroCalcularVelocidad implements Filtro{
    
    @Override
    public double ejecutar(double revoluciones, EstadoMotor estado){
        double incrementoVelocidad = 0.0;
        if(estado == EstadoMotor.FRENANDO){
            incrementoVelocidad = -100.0;
        }
        else if(estado == EstadoMotor.ACELERANDO){
            incrementoVelocidad = 100.0;
        }    
        
        if(revoluciones+incrementoVelocidad > 5000.0){
            return(5000.0);
        }
        
        return (revoluciones+incrementoVelocidad);
    }
}

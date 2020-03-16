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
    int incrementoVelocidad;
    
    @Override
    public double ejecutar(double revoluciones, EstadoMotor estado){
        if(estado == EstadoMotor.FRENANDO){
            incrementoVelocidad = -100;
        }
        else if(estado == EstadoMotor.ACELERANDO){
            incrementoVelocidad = 100;
        }    
        else if(estado == EstadoMotor.APAGADO){
            incrementoVelocidad = 0;
        }
        if(revoluciones+incrementoVelocidad>5000){
            return(5000);
        }
        return (revoluciones+incrementoVelocidad);
    }
}

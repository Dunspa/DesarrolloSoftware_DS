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
public class FiltroRepercutirRozamiento implements Filtro{


    @Override
    public double ejecutar(double revoluciones, EstadoMotor estado) {
        revoluciones--;
        return revoluciones;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SCACV_Modelo;

/**
 *
 * @author sergio
 */
public class FiltroRepercutirRozamiento implements Filtro{


    @Override
    public double ejecutar(double revoluciones, EstadoMotor estado) {
        revoluciones -= 20;
        if(revoluciones <0){
        revoluciones = 0;
        }
        return revoluciones;
    }
    
}

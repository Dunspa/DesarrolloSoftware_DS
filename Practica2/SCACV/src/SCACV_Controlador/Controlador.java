/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SCACV_Controlador;

import SCACV_Modelo.*;

/**
 *
 * @author jlgallego99
 */
public class Controlador {
    // Partes del modelo
    GestorFiltros gestor;
    Coche coche;
    private EstadoMotor estadomotor = EstadoMotor.APAGADO;
    
    public Controlador() {
        gestor = new GestorFiltros();
        coche = new Coche();
    }
    
    public double getDistanciaAcumulada() {
        return coche.getDistanciaAcumulada();
    }
    
    public double getDistanciaActual() {
        return coche.getDistanciaActual();
    }
    
    public double getVelocidad() {
        return coche.getVelocidad();
    }
    
    public double getRPM() {
        return coche.getRPM();
    }
    
    public EstadoMotor getEstadoMotor() {
        return estadomotor;
    }
    
    public void setEstadoMotor(EstadoMotor estado) {
        this.estadomotor = estado;
    }
    
    public void ejecutar(){
        double revoluciones = gestor.ejecutar(estadomotor);
        coche.ejecutar(revoluciones, estadomotor);
    }
}

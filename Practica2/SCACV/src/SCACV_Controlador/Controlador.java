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
    private EstadoPalanca estadopalanca = EstadoPalanca.APAGADO;
    
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
    
    public double getVelocidadSCACV() {
        return coche.getVelocidadSCACV();
    }
    
    public double getRPM() {
        return coche.getRPM();
    }
    
    public double getCombustible() {
        return coche.getCombustible();
    }
    
    public EstadoMotor getEstadoMotor() {
        return estadomotor;
    }
    
    public EstadoPalanca getEstadoPalanca() {
        return estadopalanca;
    }
    
    public void setEstadoMotor(EstadoMotor estado) {
        this.estadomotor = estado;
    }
    
    public void setEstadoPalanca(EstadoPalanca estado) {
        this.estadopalanca = estado;
    }
    
      public void setCuentaRevAceite(double d) {
        coche.setCuentaRevAceite(d);
    }
    
    public void setCuentaRevGeneral(double d) {
        coche.setCuentaRevGeneral(d);
    }
    
    public void setCuentaRevFrenos(double d) {
        coche.setCuentaRevFrenos(d);
    }

    public void setCombustible(double d) {
        coche.setCombustible(d);
    }
    
    public double getCuentaRevAceite() {
        return coche.getCuentaRevAceite();
    }
                
    public double getCuentaRevFrenos() {
        return coche.getCuentaRevFrenos();
    }

    public double getCuentaRevGeneral() {
        return coche.getCuentaRevGeneral();
    }
    
    public void ejecutar(){
        double revoluciones = 1.0;
        if (estadopalanca != EstadoPalanca.MANTENER) {
            revoluciones = gestor.ejecutar(estadomotor);
        }
        
        coche.ejecutar(revoluciones, estadomotor, estadopalanca);
    }

}

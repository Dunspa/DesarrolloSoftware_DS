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
public class GestorFiltros {
    private double revoluciones;
    private CadenaFiltros filtros;

    public GestorFiltros() {
        filtros = new CadenaFiltros();
        revoluciones = 0.0;
        añadeFiltros();
    }
    
    public double ejecutar(EstadoMotor estado){
        revoluciones = filtros.ejecutar(revoluciones,estado);
        return revoluciones;
    }
            
    public void añadeFiltros(){
        FiltroCalcularVelocidad filtro1 = new FiltroCalcularVelocidad();
        FiltroRepercutirRozamiento filtro2 = new FiltroRepercutirRozamiento();
        
        filtros.añadeFiltro(filtro1);
        filtros.añadeFiltro(filtro2);
    }     
    
}

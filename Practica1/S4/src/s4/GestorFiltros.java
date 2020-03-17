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
public class GestorFiltros {
    private CadenaFiltros filtros;

    public GestorFiltros() {
        filtros = new CadenaFiltros();
        añadeFiltros();
    }
    
    void peticionFiltros(Coche coche){
        while(true){
            filtros.ejecutar(coche.getRevoluciones(), coche.getEstado());
            coche.ejecutar();
        }
    }
            
    public void añadeFiltros(){
        FiltroCalcularVelocidad filtro1 = new FiltroCalcularVelocidad();
        FiltroRepercutirRozamiento filtro2 = new FiltroRepercutirRozamiento();
        
        filtros.añadeFiltro(filtro1);
        filtros.añadeFiltro(filtro2);
    }     
    
}

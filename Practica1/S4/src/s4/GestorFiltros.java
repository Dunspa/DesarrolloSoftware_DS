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
    }
    
    void peticionFiltros(){
        filtros.ejecutar(Coche.getRevoluciones(),Coche.getEstado());
        Coche.ejecutar();
    }
            
            
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrerasbicicletas;

/**
 *
 * @author sergio
 */
public class FactoriaMontaña extends FactoriaCarreraYBicicleta{
    @Override
    public Carrera crearCarrera(){
        CarreraMontaña carrera = new CarreraMontaña();
        return carrera;
    }
    @Override
    public Bicicleta crearBicicleta(){
         BicicletaMontaña bicicleta = new BicicletaMontaña();
         return bicicleta;
    }
}



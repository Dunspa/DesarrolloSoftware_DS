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
public class FactoriaCarretera extends FactoriaCarreraYBicicleta{
    @Override
    public Carrera crearCarrera(){
        CarreraCarretera carrera = new CarreraCarretera();
        return carrera;
    }
    @Override
    public Bicicleta crearBicicleta(){
        BicicletaCarretera bicicleta = new BicicletaCarretera();
        return bicicleta;
    }
}

package carrerasbicicletas;

import java.util.ArrayList;
import java.util.Random;

public class FactoriaMontaña extends FactoriaCarreraYBicicleta{
    @Override
    public Carrera crearCarrera(FactoriaCarreraYBicicleta factoria){
        CarreraMontaña carrera = new CarreraMontaña(factoria.crearBicicletas());
        return carrera;
    }
    
    @Override
    public Bicicleta crearBicicleta(int id){
        BicicletaMontaña bicicleta = new BicicletaMontaña(id);
        return bicicleta;
    }
}



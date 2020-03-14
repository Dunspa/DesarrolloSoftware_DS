package carrerasbicicletas;

import java.util.ArrayList;
import java.util.Random;

public class FactoriaCarretera extends FactoriaCarreraYBicicleta{    
    @Override
    public Carrera crearCarrera(FactoriaCarreraYBicicleta factoria){
        CarreraCarretera carrera = new CarreraCarretera(factoria.crearBicicletas());
        return carrera;
    }
    
    @Override
    public Bicicleta crearBicicleta(int id){
        BicicletaCarretera bicicleta = new BicicletaCarretera(id);
        return bicicleta;
    }
}

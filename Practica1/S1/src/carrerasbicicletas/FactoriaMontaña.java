package carrerasbicicletas;

import java.util.ArrayList;

public class FactoriaMontaña extends FactoriaCarreraYBicicleta{
    @Override
    public Carrera crearCarrera(int numBicicletas){
        ArrayList<Bicicleta> bicicletas = new ArrayList<Bicicleta>();
        for (int i = 0 ; i < numBicicletas ; i++){
            bicicletas.add(crearBicicleta(i));
        }
        
        CarreraMontaña carrera = new CarreraMontaña(bicicletas, numBicicletas);
        return carrera;
    }
    @Override
    public Bicicleta crearBicicleta(int id){
        BicicletaMontaña bicicleta = new BicicletaMontaña(id);
        return bicicleta;
    }
}



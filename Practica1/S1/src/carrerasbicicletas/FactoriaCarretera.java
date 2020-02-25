package carrerasbicicletas;

import java.util.ArrayList;

public class FactoriaCarretera extends FactoriaCarreraYBicicleta{    
    @Override
    public Carrera crearCarrera(int numBicicletas){
        ArrayList<Bicicleta> bicicletas = new ArrayList<Bicicleta>();
        for (int i = 0 ; i < numBicicletas ; i++){
            bicicletas.add(crearBicicleta(i));
        }
        
        CarreraCarretera carrera = new CarreraCarretera(bicicletas, numBicicletas);
        return carrera;
    }
    @Override
    public Bicicleta crearBicicleta(int id){
        BicicletaCarretera bicicleta = new BicicletaCarretera(id);
        return bicicleta;
    }
}

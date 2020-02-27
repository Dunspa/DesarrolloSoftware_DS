package carrerasbicicletas;

import java.util.ArrayList;
import java.util.Random;

public class FactoriaCarretera extends FactoriaCarreraYBicicleta{    
    @Override
    public Carrera crearCarrera(){
        Random rand = new Random();
        int num_bicicletas = rand.nextInt(50);  // Máximo 50 participantes [0-49]
        
        ArrayList<Bicicleta> bicicletas = new ArrayList<Bicicleta>();
        for (int i = 0 ; i < num_bicicletas ; i++){
            bicicletas.add(crearBicicleta(i));
        }
        
        CarreraCarretera carrera = new CarreraCarretera(bicicletas, num_bicicletas);
        return carrera;
    }
    
    @Override
    public Bicicleta crearBicicleta(int id){
        BicicletaCarretera bicicleta = new BicicletaCarretera(id);
        return bicicleta;
    }
}

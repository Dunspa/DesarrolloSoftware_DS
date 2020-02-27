package carrerasbicicletas;

import java.util.ArrayList;
import java.util.Random;

public class FactoriaMontaña extends FactoriaCarreraYBicicleta{
    @Override
    public Carrera crearCarrera(){
        Random rand = new Random();
        int num_bicicletas = rand.nextInt(50);  // Máximo 50 participantes [0-49]
        
        ArrayList<Bicicleta> bicicletas = new ArrayList<Bicicleta>();
        for (int i = 0 ; i < num_bicicletas ; i++){
            bicicletas.add(crearBicicleta(i));
        }
        
        CarreraMontaña carrera = new CarreraMontaña(bicicletas, num_bicicletas);
        return carrera;
    }
    
    @Override
    public Bicicleta crearBicicleta(int id){
        BicicletaMontaña bicicleta = new BicicletaMontaña(id);
        return bicicleta;
    }
}



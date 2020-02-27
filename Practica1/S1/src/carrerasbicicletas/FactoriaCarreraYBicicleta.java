package carrerasbicicletas;

import java.util.ArrayList;
import java.util.Random;

public abstract class FactoriaCarreraYBicicleta {
    public abstract Carrera crearCarrera(FactoriaCarreraYBicicleta factoria);
    public abstract Bicicleta crearBicicleta(int id);
    
    public ArrayList<Bicicleta> crearBicicletas(){
        Random rand = new Random();
        int num_bicicletas = rand.nextInt(50);  // Máximo 50 participantes [0-49]
        ArrayList<Bicicleta> bicicletas = new ArrayList<Bicicleta>();
        
        for (int i = 0 ; i < num_bicicletas ; i++){
            bicicletas.add(crearBicicleta(i));
        }
        
        return bicicletas;
    }
}

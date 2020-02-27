package carrerasbicicletas;

import java.util.ArrayList;
import java.util.Random;

public class CarreraMontaña extends Carrera{
    CarreraMontaña(ArrayList<Bicicleta> bicicletas, int numBicicletas){
        // Número de bicicletas que participarán a la vez en la carrera
        this.numBicicletas = numBicicletas;
        this.bicicletas = bicicletas;
    }
    
    @Override
    public void iniciarCarrera(){
        // Poner tiempo de retiro
        Random rand = new Random();
        Bicicleta.settRetiro(rand.nextInt(59999));    
        
        // Inicializar bicicletas (hebras)
        int retirados = (numBicicletas * 20) / 100;
        for (int i = 0 ; i < numBicicletas ; i++){
            bicicletas.get(i).start();
            
            if (i < retirados){
                bicicletas.get(i).setRetirada(true);
            }
        }
    }
}

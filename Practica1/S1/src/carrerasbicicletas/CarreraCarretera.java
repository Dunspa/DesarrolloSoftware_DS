package carrerasbicicletas;

import java.util.ArrayList;
import java.util.Random;

public class CarreraCarretera extends Carrera{
    CarreraCarretera(ArrayList<Bicicleta> bicicletas){
        // Número de bicicletas que participarán a la vez en la carrera
        this.numBicicletas = bicicletas.size();
        this.bicicletas = bicicletas;
    }
    
    @Override
    public void iniciarCarrera(){
        // Poner tiempo de retiro
        Random rand = new Random();
        Bicicleta.settRetiro(rand.nextInt(59999));  
        
        // Inicializar bicicletas (hebras)
        int retirados = (numBicicletas * 10) / 100;
        for (int i = 0 ; i < numBicicletas ; i++){
            bicicletas.get(i).start();
            
            if (i < retirados){
                bicicletas.get(i).setRetirada(true);
            }
        }
    }
}

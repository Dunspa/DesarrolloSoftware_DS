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
        // Número de bicicletas que se retiran a mitad
        int retirados = (numBicicletas * 10) / 100;
        
        // Iniciar hebras
        super.iniciarHebras(retirados);
    }
}

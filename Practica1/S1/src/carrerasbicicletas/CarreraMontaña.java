package carrerasbicicletas;

import java.util.ArrayList;

public class CarreraMontaña extends Carrera{
    CarreraMontaña(ArrayList<Bicicleta> bicicletas, int numBicicletas){
        this.numBicicletas = numBicicletas;
        this.bicicletas = bicicletas;
    }
}

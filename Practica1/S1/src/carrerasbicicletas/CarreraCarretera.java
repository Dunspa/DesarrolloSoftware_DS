package carrerasbicicletas;

import java.util.ArrayList;

public class CarreraCarretera extends Carrera{
    CarreraCarretera(ArrayList<Bicicleta> bicicletas, int numBicicletas){
        this.numBicicletas = numBicicletas;
        this.bicicletas = bicicletas;
    }
}

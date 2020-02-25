package carrerasbicicletas;
import java.util.ArrayList;

public abstract class Carrera {
    public ArrayList<Bicicleta> bicicletas;
    public int numBicicletas;
    
    public ArrayList<Bicicleta> getBicicletas(){
        return bicicletas;
    }
}

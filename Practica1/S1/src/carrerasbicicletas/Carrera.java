package carrerasbicicletas;
import java.util.ArrayList;
import java.util.Random;

public abstract class Carrera {
    public ArrayList<Bicicleta> bicicletas;
    public int numBicicletas;
    
    public ArrayList<Bicicleta> getBicicletas(){
        return bicicletas;
    }
    
    public abstract void iniciarCarrera();
}

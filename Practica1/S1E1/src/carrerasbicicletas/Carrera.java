package carrerasbicicletas;
import java.util.ArrayList;
import java.util.Random;

public abstract class Carrera {
    public ArrayList<Bicicleta> bicicletas;
    public int numBicicletas;
    
    public ArrayList<Bicicleta> getBicicletas(){
        return bicicletas;
    }
    
    public void iniciarHebras(int retirados){
        // Poner tiempo de retiro
        Random rand = new Random();
        Bicicleta.settRetiro(rand.nextInt(59999));
        
        // Iniciar hebras
        for (int i = 0 ; i < numBicicletas ; i++){
            bicicletas.get(i).start();
            
            if (i < retirados){
                bicicletas.get(i).setRetirada(true);
            }
        }
    }
    
    public abstract void iniciarCarrera();
}

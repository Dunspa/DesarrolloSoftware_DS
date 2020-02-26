package carrerasbicicletas;

import java.util.Random;
import java.util.ArrayList;

public class CarrerasBicicletas {

    public static void main(String[] args) {
        // Número de bicicletas que participarán a la vez en la carrera
        Random rand = new Random();
        int num_bicicletas = rand.nextInt(50);  // Máximo 50 participantes [0-49]
        
        // Tipo de carrera = 0 (Montaña) y 1 (Carretera)
        int tipo_carrera = rand.nextInt(2);
        
        // Crear factoría de carreras y bicicletas
        FactoriaCarreraYBicicleta factoria = null;
        int retirados = 0;
        // De montaña
        if (tipo_carrera == 0){
            factoria = new FactoriaMontaña();
            retirados = (num_bicicletas * 20) / 100;
        }
        // De carretera
        else if (tipo_carrera == 1){
            factoria = new FactoriaCarretera();
            retirados = (num_bicicletas * 10) / 100;
        }
        
        if (factoria != null){
            // Inicializar carrera
            Carrera carrera = factoria.crearCarrera(num_bicicletas);
            
            // Inicializar bicicletas (hebras)
            ArrayList<Bicicleta> bicicletas = new ArrayList<Bicicleta>();
            bicicletas = carrera.getBicicletas();
            for (int i = 0 ; i < num_bicicletas ; i++){
                bicicletas.get(i).start();
            }
        }
    }
}

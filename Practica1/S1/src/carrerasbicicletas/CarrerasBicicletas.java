package carrerasbicicletas;

import java.util.Random;

public class CarrerasBicicletas {

    public static void main(String[] args) {        
        // Tipo de carrera = 0 (Montaña) y 1 (Carretera)
        Random rand = new Random();
        int tipo_carrera = rand.nextInt(2);
        
        // Crear factoría de carreras y bicicletas
        FactoriaCarreraYBicicleta factoria = null;
        // De montaña
        if (tipo_carrera == 0){
            System.out.println("CARRERA DE MONTAÑA.");
            factoria = new FactoriaMontaña();
        }
        // De carretera
        else if (tipo_carrera == 1){
            System.out.println("CARRERA DE CARRETERA.");
            factoria = new FactoriaCarretera();
        }
        
        if (factoria != null){
            // Inicializar carrera
            Carrera carrera = factoria.crearCarrera(factoria);
            carrera.iniciarCarrera();
        }
    }
}

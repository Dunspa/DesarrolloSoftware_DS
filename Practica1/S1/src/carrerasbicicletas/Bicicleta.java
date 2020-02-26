package carrerasbicicletas;

import java.util.Random;

public abstract class Bicicleta extends Thread{
    public int id;
    
    @Override
    public void run(){
        // Lanzar hebra
        System.out.println("Bicicleta " + this.id + " EMPIEZA la carrera.");
        
        // La hebra duerme (se realiza la carrera que dura 60 segundos)
        try {
            Thread.sleep(60000);
        } 
        catch(InterruptedException e){
            System.out.println("Error en el sleep de la hebra: " + e);
        }
        
        // La hebra finaliza
        System.out.println("Bicicleta " + this.id + " TERMINA la carrera.");
    }
}

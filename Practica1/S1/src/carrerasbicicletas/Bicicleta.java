package carrerasbicicletas;

import java.util.Random;

public abstract class Bicicleta extends Thread{
    public int id;
    public boolean retirada = false;
    private static int tRetiro;
    
    @Override
    public void run(){
        // Lanzar hebra
        System.out.println("Bicicleta " + this.id + " EMPIEZA la carrera.");
        
        // La hebra duerme (se realiza la carrera que dura 60 segundos)
        try {
            Thread.sleep(tRetiro);
            
            if(retirada){
                System.out.println("Bicicleta " + this.id + " se RETIRA.");
            }
            else{
                Thread.sleep(60000-tRetiro);
            }
        } 
        catch(InterruptedException e){
            System.out.println("Error en el sleep de la hebra: " + e);
        }
        
        // La hebra finaliza
        System.out.println("Bicicleta " + this.id + " TERMINA la carrera.");
    }

    public static void settRetiro(int tRetiro) {
        Bicicleta.tRetiro = tRetiro;
    }

    public void setRetirada(boolean retirada) {
        this.retirada = retirada;
    }
    
}

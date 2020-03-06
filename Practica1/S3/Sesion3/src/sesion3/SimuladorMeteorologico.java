package sesion3;

public class SimuladorMeteorologico {
   
    public static void main(String[] args) {
        Termometro termo = new Termometro();
        pantallaTemperatura pantalla = new pantallaTemperatura(termo);
        termo.addObserver(pantalla);
        
        Thread t = new Thread(termo);
        t.start();
        
        pantalla.setVisible(true);
    }
    
}

package sesion3;

public class SimuladorMeteorologico {
   
    public static void main(String[] args) {
        Termometro termo = new Termometro();
        pantallaTemperatura pantalla = new pantallaTemperatura(termo);
        pantalla.start();
        botonCambio boton = new botonCambio(termo);
        termo.addObserver(boton);
        graficaTemperatura grafica = new graficaTemperatura(termo);
        termo.addObserver(grafica);
        
        Thread t = new Thread(termo);
        t.start();
        
        pantalla.setVisible(true);
        boton.setVisible(true);
        grafica.setVisible(true);
    }
    
}

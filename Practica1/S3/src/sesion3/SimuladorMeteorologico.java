package sesion3;

public class SimuladorMeteorologico {
   
    public static void main(String[] args) {
        Termometro termo = new Termometro();
        TermometroEspaña termoes = new TermometroEspaña();
        TermometroAlemania termoal = new TermometroAlemania();
        TermometroNoruega termonor = new TermometroNoruega();
        pantallaTemperatura pantalla = new pantallaTemperatura(termo);
        pantalla.start();
        botonCambio boton = new botonCambio(termo);
        termo.addObserver(boton);
        graficaTemperatura grafica = new graficaTemperatura(termo);
        termo.addObserver(grafica);
        TiempoSatelital satelite= new TiempoSatelital(termoal,termoes,termonor);
        termo.addObserver(satelite);
        
        Thread t = new Thread(termo);
        Thread t1 = new Thread(termoes);
        Thread t2 = new Thread(termonor);
        Thread t3 = new Thread(termoal);
        t.start();
        t1.start();
        t2.start();
        t3.start();
        
        pantalla.setVisible(true);
        boton.setVisible(true);
        grafica.setVisible(true);
        satelite.setVisible(true);
    }
    
}

package carrerasbicicletas;

import java.util.ArrayList;

public abstract class FactoriaCarreraYBicicleta {
    public abstract Carrera crearCarrera(int numBicicletas);
    public abstract Bicicleta crearBicicleta(int id);
}

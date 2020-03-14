require_relative "FactoriaMontaña.rb"
require_relative "FactoriaCarretera.rb"
require_relative "CarreraCarretera.rb"
require_relative "CarreraMontaña.rb"

class CarrerasBicicletas
  def self.main
    # Tipo de carrera = 0 (Montaña) y 1 (Carretera)
    tipo_carrera = Random.rand(2)
    
    # Crear factoría de carreras y bicicletas
    if tipo_carrera == 0
      puts "CARRERA DE MONTAÑA"
      factoria = FactoriaMontaña.new
    else if tipo_carrera == 1
      puts "CARRERA DE CARRETERA"
    end
      factoria = FactoriaCarretera.new
    end
    
    # Empezar carrera
    if factoria != nil
      carrera = factoria.crearCarrera
      carrera.iniciar
    end
  end
end

# Invocar al main
CarrerasBicicletas.main
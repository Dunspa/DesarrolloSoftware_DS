require_relative "FactoriaCarreraYBicicleta.rb"
require_relative "CarreraCarretera.rb"
require_relative "BicicletaCarretera.rb"

class FactoriaCarretera < FactoriaCarreraYBicicleta
  def crearCarrera
    num_bicicletas = Random.rand(50) # Máximo 50 participantes [0-49]
    carrera = CarreraCarretera.new(num_bicicletas)
    
    bicicletas = Array.new
    
    # Prototipo
    bici_proto = crearBicicleta(0)
    
    for i in 1..carrera.getNumBicicletas - 1
      # Clonar prototipo
      bici_clon = bici_proto.clone
      
      # Características del clon
      if i < carrera.getRetirados
        bici_clon.setRetirada(true)
      else
        bici_clon.setRetirada(false)
      end
      
      bici_clon.setId(i)
      
      # Añadir bicicleta a la carrera
      bicicletas << bici_clon
    end
    
    carrera.setBicicletas(bicicletas)
    
    return carrera
  end
  
  def crearBicicleta(id)
    return BicicletaCarretera.new(id)
  end
end
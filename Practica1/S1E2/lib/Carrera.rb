require_relative "Bicicleta.rb"

class Carrera
  @bicicletas = Array.new
  @numBicicletas = 0
  @retirados = 0
  
  def getBicicletas
    return bicicletas
  end
  
  def iniciar
    # Poner tiempo de retiro
    Bicicleta.setRetiro(Random.rand(2))
    
    i = 0
    # Iniciar
    for b in @bicicletas
      i = i + 1
      b.run
    end
  end
  
  def getRetirados
    return @retirados
  end
  
  def getNumBicicletas
    return @numBicicletas
  end
  
  def setBicicletas(bicis)
    @bicicletas = bicis
  end
end

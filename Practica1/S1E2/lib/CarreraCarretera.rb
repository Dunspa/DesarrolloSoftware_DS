require_relative "Carrera.rb"

class CarreraCarretera < Carrera
  def initialize(num_bicicletas)
    @numBicicletas = num_bicicletas
    # Número de bicicletas que se retiran a mitad
    @retirados = (@numBicicletas * 10) / 100
  end
end

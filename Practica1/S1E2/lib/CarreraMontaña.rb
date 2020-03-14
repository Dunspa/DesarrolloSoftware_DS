require_relative "Carrera.rb"

class CarreraMontaña < Carrera
  def initialize(num_bicicletas)
    @numBicicletas = num_bicicletas
    # Número de bicicletas que se retiran a mitad
    @retirados = (@numBicicletas * 20) / 100
  end
end

require_relative "Bicicleta.rb"

class BicicletaCarretera < Bicicleta
  def initialize(num)
    @id = num
  end
  
  def clone
    return BicicletaCarretera.new(@id)
  end
end
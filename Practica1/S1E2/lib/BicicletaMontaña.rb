require_relative "Bicicleta.rb"

class BicicletaMontaña < Bicicleta
  def initialize(num)
    @id = num
  end
  
  def clone
    return BicicletaMontaña.new(@id)
  end
end
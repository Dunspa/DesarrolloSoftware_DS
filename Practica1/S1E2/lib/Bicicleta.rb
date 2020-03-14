class Bicicleta
  @id
  @retirada = false
  @@tRetiro
  
  def run
    puts "Bicicleta #{@id} EMPIEZA la carrera"
    
    sleep(5)
    
    if @retirada
      puts "Bicicleta #{@id} se RETIRA"
    else
      sleep(5-@@tRetiro)
    end
    
    if !@retirada
      puts "Bicicleta #{@id} TERMINA la carrera"
    end
  end
  
  def self.setRetiro(tr)
    @@tRetiro = tr
  end
  
  def setRetirada(r)
    @retirada = r
  end
  
  def setId(i)
    @id = i
  end
end

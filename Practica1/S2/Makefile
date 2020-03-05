SRC = src
INC = include
OBJ = obj
BIN = bin
CXX = g++


all: $(BIN)/calculaprecios\
clean

# ************ Compilación de módulos ************
$(BIN)/calculaprecios: $(OBJ)/calculaprecios.o $(OBJ)/equipo.o $(OBJ)/visitanteprecio.o $(OBJ)/visitantepreciodet.o $(OBJ)/bus.o $(OBJ)/disco.o $(OBJ)/tarjeta.o $(OBJ)/visitanteequipo.o $(OBJ)/componenteequipo.o
	$(CXX) -o $(BIN)/calculaprecios $(OBJ)/calculaprecios.o $(OBJ)/equipo.o $(OBJ)/visitanteprecio.o $(OBJ)/visitantepreciodet.o $(OBJ)/bus.o $(OBJ)/disco.o $(OBJ)/tarjeta.o $(OBJ)/visitanteequipo.o $(OBJ)/componenteequipo.o

$(OBJ)/calculaprecios.o: $(SRC)/CalculaPrecios.cc
	$(CXX) -c -o $(OBJ)/calculaprecios.o $(SRC)/CalculaPrecios.cc -I$(INC) -std=c++11

$(OBJ)/componenteequipo.o: $(SRC)/ComponenteEquipo.cc $(INC)/ComponenteEquipo.h
	$(CXX) -c -o $(OBJ)/componenteequipo.o $(SRC)/ComponenteEquipo.cc -I$(INC) -std=c++11

$(OBJ)/bus.o: $(SRC)/Bus.cc $(INC)/Bus.h
	$(CXX) -c -o $(OBJ)/bus.o $(SRC)/Bus.cc -I$(INC) -std=c++11

$(OBJ)/tarjeta.o: $(SRC)/Tarjeta.cc
	$(CXX) -c -o $(OBJ)/tarjeta.o $(SRC)/Tarjeta.cc -I$(INC) -std=c++11

$(OBJ)/Disco.o: $(SRC)/Disco.cc $(INC)/Disco.h
	$(CXX) -c -o $(OBJ)/Disco.o $(SRC)/Disco.cc -I$(INC) -std=c++11

$(OBJ)/visitanteequipo.o: $(SRC)/visitanteEquipo.cc $(INC)/visitanteEquipo.h
	$(CXX) -c -o $(OBJ)/visitanteequipo.o $(SRC)/visitanteEquipo.cc -I$(INC) -std=c++11

$(OBJ)/visitanteprecio.o: $(SRC)/visitantePrecio.cc $(INC)/visitantePrecio.h
	$(CXX) -c -o $(OBJ)/visitanteprecio.o $(SRC)/visitantePrecio.cc -I$(INC) -std=c++11

$(OBJ)/visitantepreciodet.o: $(SRC)/visitantePrecioDet.cc $(INC)/visitantePrecioDet.h
	$(CXX) -c -o $(OBJ)/visitantepreciodet.o $(SRC)/visitantePrecioDet.cc -I$(INC) -std=c++11

$(OBJ)/equipo.o: $(SRC)/Equipo.cc $(INC)/Equipo.h
	$(CXX) -c -o $(OBJ)/equipo.o $(SRC)/Equipo.cc -I$(INC) -std=c++11


# ************ Limpieza ************
clean :
	-rm $(OBJ)/*

mrproper : clean
	-rm $(BIN)/*

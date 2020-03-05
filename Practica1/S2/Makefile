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

$(OBJ)/calculaprecios.o: $(SRC)/CalculaPrecios.cpp
	$(CXX) -o $(OBJ)/calculaprecios.o $(SRC)/CalculaPrecios.cpp

$(OBJ)/equipo.o: $(SRC)/Equipo.cpp
	$(CXX) -o $(OBJ)/equipo.o $(SRC)/Equipo.cpp

$(OBJ)/bus.o: $(SRC)/Bus.cpp
	$(CXX) -o $(OBJ)/bus.o $(SRC)/Bus.cpp

$(OBJ)/disco.o: $(SRC)/Disco.cpp
	$(CXX) -o $(OBJ)/disco.o $(SRC)/Disco.cpp

$(OBJ)/tarjeta.o: $(SRC)/Tarjeta.cpp
	$(CXX) -o $(OBJ)/tarjeta.o $(SRC)/Tarjeta.cpp

$(OBJ)/componenteequipo.o: $(SRC)/componenteEquipo.cpp
	$(CXX) -o $(OBJ)/componenteequipo.o $(SRC)/componenteEquipo.cpp

$(OBJ)/visitanteequipo.o: $(SRC)/visitanteEquipo.cpp
	$(CXX) -o $(OBJ)/visitanteequipo.o $(SRC)/visitanteEquipo.cpp

$(OBJ)/visitanteprecio.o: $(SRC)/visitantePrecio.cpp
	$(CXX) -o $(OBJ)/visitanteprecio.o $(SRC)/visitantePrecio.cpp

$(OBJ)/visitantepreciodet.o: $(SRC)/visitantePrecioDet.cpp
	$(CXX) -o $(OBJ)/visitantepreciodet.o $(SRC)/visitantePrecioDet.cpp


# ************ Limpieza ************
clean :
	-rm $(OBJ)/*

mrproper : clean
	-rm $(BIN)/*

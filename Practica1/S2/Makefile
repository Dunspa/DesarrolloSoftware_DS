SRC = src
INC = include
OBJ = obj
BIN = bin
CXX = g++


all: $(BIN)/calculaprecios\
clean

# ************ Compilación de módulos ************
$(BIN)/calculaprecios: $(OBJ)/calculaprecios.o
	$(CXX) -o $(BIN)/calculaprecios $(OBJ)/calculaprecios.o


# ************ Limpieza ************
clean :
	-rm $(OBJ)/*

mrproper : clean
	-rm $(BIN)/*

#include "componenteEquipo.h"

componenteEquipo::componenteEquipo(int c, string n){
   coste = c;
   nombre = n;
}

int componenteEquipo::getCoste(){
   return coste;
}

string componenteEquipo::getNombre(){
   return nombre;
}

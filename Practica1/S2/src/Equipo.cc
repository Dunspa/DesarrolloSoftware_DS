#include "Equipo.h"
#include <stdlib.h>
#include <ctime>

Equipo::Equipo(){
   int c1 = rand() % 100 + 1;
   int c2 = rand() % 100 + 1;
   int c3 = rand() % 100 + 1;

   disco = new Disco(c1, "Disco" + to_string(c1));
   tarjeta = new Tarjeta(c2, "Tarjeta" + to_string(c2));
   bus = new Bus(c3, "Bus" + to_string(c3));
}

void Equipo::aceptar(visitanteEquipo * v){
   bus->aceptar(v);
   tarjeta->aceptar(v);
   disco->aceptar(v);
}

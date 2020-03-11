#include "Bus.h"
#include "visitanteEquipo.h"

Bus::Bus(int c, string n) : componenteEquipo(c, n){}

void Bus::aceptar(visitanteEquipo * v){
   v->visitarBus(this);
}

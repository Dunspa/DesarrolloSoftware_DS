#include "Bus.h"

void Bus::aceptar(visitanteEquipo v){
   v.visitarBus(*this);
}

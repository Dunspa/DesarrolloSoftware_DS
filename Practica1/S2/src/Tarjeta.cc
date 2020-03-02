#include "Tarjeta.h"

void Tarjeta::aceptar(visitanteEquipo v){
   v.visitarTarjeta(*this);
}

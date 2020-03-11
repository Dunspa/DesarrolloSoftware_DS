#include "Tarjeta.h"
#include "visitanteEquipo.h"

Tarjeta::Tarjeta(int c, string n) : componenteEquipo(c, n){}

void Tarjeta::aceptar(visitanteEquipo * v){
   v->visitarTarjeta(this);
}

#include "visitantePrecio.h"

void VisitantePrecio::visitarDisco(Disco * d){
   costeNeto += d->getCoste();
}

void VisitantePrecio::visitarTarjeta(Tarjeta * t){
   costeNeto += t->getCoste();
}

void VisitantePrecio::visitarBus(Bus * b){
   costeNeto += b->getCoste();
}

int VisitantePrecio::getCosteNeto(){
   int c = costeNeto;
   costeNeto = 0;
   return c;
}

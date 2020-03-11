#include "visitantePrecioDet.h"
#include <iostream>

using namespace std;

void VisitantePrecioDet::visitarDisco(Disco * d){
   cout << " -Coste de " << d->getNombre() << " : " << d->getCoste() << endl;
}

void VisitantePrecioDet::visitarBus(Bus * b){
   cout << " -Coste de " << b->getNombre() << " : " << b->getCoste() << endl;
}

void VisitantePrecioDet::visitarTarjeta(Tarjeta * t){
  cout << " -Coste de " << t->getNombre() << " : " << t->getCoste() << endl;
}

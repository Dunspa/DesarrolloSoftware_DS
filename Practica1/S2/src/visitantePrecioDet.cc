#include "visitantePrecioDet.h"
#include <iostream>

using namespace std;

void visitantePrecioDet::visitarDisco(Disco d){
   cout << " -Coste de " << d.getNombre() << " : " << d.getCoste() << endl;
}

void visitantePrecioDet::visitarBus(Bus b){
   cout << " -Coste de " << b.getNombre() << " : " << b.getCoste() << endl
}

void visitantePrecioDet::visitarTarjeta(Tarjeta t){
  cout << " -Coste de " << t.getNombre() << " : " << t.getCoste() << endl;
}

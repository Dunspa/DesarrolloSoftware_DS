#include <iostream>
#include <ctime>
#include <vector>
#include "Equipo.h"
#include "visitantePrecio.h"
#include "visitantePrecioDet.h"
using namespace std;

int main(){
   // Crear varios equipos
   srand (time(0));
   int numEquipos = rand() % 10 + 1;

   vector<Equipo> equipos;
   for (int i = 0 ; i < numEquipos ; i++){
      equipos.push_back(Equipo());
   }

   // Llamar a visitantePrecio
   VisitantePrecio * v = new VisitantePrecio();
   for (int i = 0 ; i < numEquipos ; i++){
      equipos[i].aceptar(v);
      cout << "Coste neto equipo " << i << ": " << v->getCosteNeto() << endl;
   }

   // Llamar a visitantePrecioDet
   VisitantePrecioDet * vdet = new VisitantePrecioDet();
   for (int i = 0 ; i < numEquipos ; i++){
      cout << "Precio detallado equipo " << i << ": " << endl;
      equipos[i].aceptar(vdet);
   }
}

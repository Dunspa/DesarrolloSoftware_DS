#include <iostream>
#include <vector>
#include "Equipo.h"
#include "visitantePrecio.h"
#include "visitantePrecioDet.h"
using namespace std;

int main(){
   // Crear varios equipos
   srand (time(NULL));
   int numEquipos = rand() % 10 + 1;

   vector<Equipo> equipos;
   for (int i = 0 ; i < numEquipos ; i++){
      equipos.push_back(Equipo());
   }

   // Llamar a visitantePrecio
   VisitantePrecio v;
   for (int i = 0 ; i < numEquipos ; i++){
      equipos[i].aceptar(v);
      cout << "Coste neto equipo " << i << ": " << v.getCosteNeto();
   }

   // Llamar a visitantePrecioDet
   VisitantePrecioDet vdet;
   for (int i = 0 ; i < numEquipos ; i++){
      cout << "Precio detallado equipo " << i << ": " << endl;
      equipos[i].aceptar(vdet);
   }
}

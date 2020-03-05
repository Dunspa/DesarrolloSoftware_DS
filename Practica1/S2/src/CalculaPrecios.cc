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
   visitantePrecio v;
   for (int i = 0 ; i < numEquipos ; i++){
      equipos[i].aceptar(v);
      cout << "Coste neto equipo " << i << ": " << v.getCosteNeto();
   }

   // Llamar a visitantePrecioDet
   visitantePrecioDet vdet;
   for (int i = 0 ; i < numEquipos ; i++){
      equipos[i].aceptar(v);
      cout << "Precio detallado equipo " << i << ": " << endl
           << " -Coste de " << v.getNombreBus() << " : " << v.getCosteBus() << endl
           << " -Coste de " << v.getNombreTarjeta() << " : " << v.getCosteTarjeta() << endl
           << " -Coste de " << v.getNombreDisco() << " : " << v.getCosteDisco() << endl
   }
}

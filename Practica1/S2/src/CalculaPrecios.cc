#include <iostream>
#include <vector>
#include "Equipo.h"
#include "visitanteEquipo.h"
using namespace std;

int main(){
   // Crear varios equipos
   srand (time(NULL));
   int numEquipos = rand() % 10 + 1;

   vector<Equipo> equipos;
   for (int i = 0 ; i < numEquipos ; i++){
      equipos.push(Equipo());
   }

   // Llamar a visitantePrecio
   for (int i = 0 ; i < numEquipos ; i++){
      
   }

   // Llamar a visitantePrecioDet
}


#ifndef COMPONENTEEQUIPO_H_INCLUDED
#define	COMPONENTEEQUIPO_H_INCLUDED

#include "visitanteEquipo.h"
#include <string>
using namespace std;

class componenteEquipo {
private:
  int coste;
  string nombre;

public:
   componenteEquipo(int c, string n);
   virtual void aceptar(visitanteEquipo v);
   int getCoste();
   string getNombre();
};

#endif

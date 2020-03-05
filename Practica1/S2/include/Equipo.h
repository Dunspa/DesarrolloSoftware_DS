#ifndef EQUIPO_H_INCLUDED
#define EQUIPO_H_INCLUDED

#include "Bus.h"
#include "Tarjeta.h"
#include "Disco.h"
#include <vector>

class Equipo {
private:
  Disco * disco;
  Tarjeta * tarjeta;
  Bus * bus;

public:
   Equipo();
   void aceptar(visitanteEquipo v);
};

#endif

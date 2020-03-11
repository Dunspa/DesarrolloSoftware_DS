#ifndef EQUIPO_H_INCLUDED
#define EQUIPO_H_INCLUDED

#include <vector>
#include "visitanteEquipo.h"

class Equipo {
private:
  Disco * disco;
  Tarjeta * tarjeta;
  Bus * bus;

public:
   Equipo();
   void aceptar(visitanteEquipo * v);
};

#endif

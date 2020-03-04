#ifndef EQUIPO_H_INCLUDED
#define EQUIPO_H_INCLUDED

#include "componenteEquipo.h"
#include <vector>

class Equipo {
private:
  Disco * disco;
  Tarjeta * tarjeta;
  Bus * bus;

public:
   Equipo();
};

#endif

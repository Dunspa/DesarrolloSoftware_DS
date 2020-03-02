#ifndef TARJETA_H_INCLUDED
#define TARJETA_H_INCLUDED

#include "componenteEquipo.h"
#include "visitanteEquipo.h"

class Tarjeta : componenteEquipo {
   void aceptar(visitanteEquipo v);
};

#endif

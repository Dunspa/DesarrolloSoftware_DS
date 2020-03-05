#ifndef BUS_H_INCLUDED
#define BUS_H_INCLUDED

#include "componenteEquipo.h"
#include "visitanteEquipo.h"

class Bus : public componenteEquipo {
   void aceptar(visitanteEquipo v);
};

#endif

#ifndef TARJETA_H_INCLUDED
#define TARJETA_H_INCLUDED

#include "componenteEquipo.h"

class Tarjeta : public componenteEquipo {
public:
   Tarjeta(int c, string n);
   void aceptar(visitanteEquipo * v);
};

#endif

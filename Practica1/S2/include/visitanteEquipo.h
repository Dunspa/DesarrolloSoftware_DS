#ifndef VISITANTEEQUIPO_H_INCLUDED
#define VISITANTEEQUIPO_H_INCLUDED

#include "Bus.h"
#include "Tarjeta.h"
#include "Disco.h"

class visitanteEquipo {
public:
   virtual void visitarDisco(Disco * d) = 0;
   virtual void visitarBus(Bus * b) = 0;
   virtual void visitarTarjeta(Tarjeta * t) = 0;
};

#endif

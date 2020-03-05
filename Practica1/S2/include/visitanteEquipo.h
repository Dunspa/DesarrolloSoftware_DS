#ifndef VISITANTEEQUIPO_H_INCLUDED
#define	VISITANTEEQUIPO_H_INCLUDED

#include "Disco.h"
#include "Bus.h"
#include "Tarjeta.h"

class Bus;

class visitanteEquipo {
public:
   virtual void visitarDisco(Disco d);
   virtual void visitarBus(Bus b);
   virtual void visitarTarjeta(Tarjeta t);
};

#endif

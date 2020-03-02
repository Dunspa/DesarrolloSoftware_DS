#ifndef VISITANTEPRECIO_H_INCLUDED
#define	VISITANTEPRECIO_H_INCLUDED

#include "visitanteEquipo.h"

class VisitantePrecio : visitanteEquipo {
   void visitarDisco(Disco d);
   void visitarBus(Bus b);
   void visitarTarjeta(Tarjeta t);
};

#endif

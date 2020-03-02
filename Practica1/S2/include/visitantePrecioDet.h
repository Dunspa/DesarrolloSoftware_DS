#ifndef VISITANTEPRECIODET_H_INCLUDED
#define	VISITANTEPRECIODET_H_INCLUDED

#include "visitanteEquipo.h"

class VisitantePrecioDet : visitanteEquipo {
   void visitarDisco(Disco d);
   void visitarBus(Bus b);
   void visitarTarjeta(Tarjeta t);
};

#endif

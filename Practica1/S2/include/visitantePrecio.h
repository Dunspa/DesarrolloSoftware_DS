#ifndef VISITANTEPRECIO_H_INCLUDED
#define	VISITANTEPRECIO_H_INCLUDED

#include "visitanteEquipo.h"

class VisitantePrecio : visitanteEquipo {
private:
   int costeNeto = 0;

public:
   void visitarDisco(Disco d);
   void visitarBus(Bus b);
   void visitarTarjeta(Tarjeta t);
   int getCosteNeto();
};

#endif

#ifndef VISITANTEPRECIODET_H_INCLUDED
#define	VISITANTEPRECIODET_H_INCLUDED

#include "visitanteEquipo.h"

class VisitantePrecioDet : visitanteEquipo {
private:
   string nombreDisco;
   string nombreTarjeta;
   string nombreBus;
   int costeDisco;
   int costeTarjeta;
   int costeBus;

public:
   void visitarDisco(Disco d);
   void visitarBus(Bus b);
   void visitarTarjeta(Tarjeta t);
   string getNombreDisco();
   string getNombreBus();
   string getNombreTarjeta();
   int getCosteDisco();
   int getCosteBus();
   int getCosteTarjeta();
};

#endif

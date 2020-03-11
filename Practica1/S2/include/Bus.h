#ifndef BUS_H_INCLUDED
#define BUS_H_INCLUDED

#include "componenteEquipo.h"

class Bus : public componenteEquipo {
public:
   Bus(int c, string n);
   void aceptar(visitanteEquipo * v);
};

#endif

#ifndef DISCO_H_INCLUDED
#define DISCO_H_INCLUDED

#include "componenteEquipo.h"

class Disco : public componenteEquipo {
public:
   Disco(int c, string n);
   void aceptar(visitanteEquipo * v);
};

#endif

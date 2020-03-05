#ifndef DISCO_H_INCLUDED
#define DISCO_H_INCLUDED

#include "componenteEquipo.h"
#include "visitanteEquipo.h"

class componenteEquipo;
class visitanteEquipo;

class Disco : public componenteEquipo {
   void aceptar(visitanteEquipo v);
};

#endif

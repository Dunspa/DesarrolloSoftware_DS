
#ifndef COMPONENTEEQUIPO_H_INCLUDED
#define	COMPONENTEEQUIPO_H_INCLUDED

#include "visitanteEquipo.h"
#include <string>

class componenteEquipo {
private:
  double precio;
  string nombre;

public:
  virtual void aceptar(visitanteEquipo v);
};

#endif

#include "Disco.h"
#include "visitanteEquipo.h"

Disco::Disco(int c, string n) : componenteEquipo(c, n){}

void Disco::aceptar(visitanteEquipo * v){
   v->visitarDisco(this);
}

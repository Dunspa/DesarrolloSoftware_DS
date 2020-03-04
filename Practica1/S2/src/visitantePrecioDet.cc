#include "visitantePrecioDet.h"

void visitantePrecioDet::visitarDisco(Disco d){
   nombreDisco = d.getNombre();
   costeDisco = d.getCoste();
}

void visitantePrecioDet::visitarBus(Bus b){
   nombreBus = b.getNombre();
   costeBus = b.getCoste();
}

void visitantePrecioDet::visitarTarjeta(Tarjeta t){
   nombreTarjeta = t.getNombre();
   costeTarjeta = t.getCoste();
}

string visitantePrecioDet::getNombreDisco(){
   return nombreDisco;
}

string visitantePrecioDet::getNombreBus(){
   return nombreBus;
}

string visitantePrecioDet::getNombreTarjeta(){
   return nombreTarjeta;
}

int visitantePrecioDet::getCosteDisco(){
   return costeDisco;
}

int visitantePrecioDet::getCosteBus(){
   return costeBus;
}

int visitantePrecioDet::getCosteTarjeta(){
   return costeTarjeta;
}

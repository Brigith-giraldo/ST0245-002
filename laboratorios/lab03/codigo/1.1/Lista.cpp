#include <iostream>
#include "Lista.h"
#include "Nodo.h"

using namespace std;

typedef Nodo *apNodo;

void Lista::insertarCola(int id, int x, int y, string nombre){
    apNodo aux = new Nodo(id,x,y,nombre);
    if (!this->primero){
        this->primero = aux; 
    }else {
        apNodo temp = this->primero;
        while (temp->next){
            temp = temp->next;
        }
        temp->next = aux;
    }
}

void Lista::insertarCola(apNodo nodo){
    if (!this->primero){
        this->primero = nodo; 
    }else {
        apNodo temp = this->primero;
        while (temp->next){
            temp = temp->next;
        }
        temp->next = nodo;
    }
}

void Lista::insertar(apNodo nodo){
    nodo->next = this->primero;
    this->primero = nodo;
}

void Lista::insertar(int id, int x, int y, string nombre){
    apNodo nodo = new Nodo(id,x,y,nombre);
    nodo->next = this->primero;
    this->primero = nodo;
}

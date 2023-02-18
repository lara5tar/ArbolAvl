package arbolavl;

import java.util.LinkedList;
import java.util.Queue;

public class ArbolAvl {

    Nodo raiz;

    void insertarBin(int num) {
        if (raiz == null) raiz = new Nodo(num);
        else raiz = insertarBin(raiz, num);
    }

    Nodo insertarBin(Nodo aux, int num) {
        if (aux == null) return new Nodo(num);
        else if (num < aux.num) aux.izq = insertarBin(aux.izq, num);
        else aux.der = insertarBin(aux.der, num);
        
        altura(aux);
        int factor = aux.factor();
        if(factor < -1) aux = rotacionIzq(aux, aux.der.factor());
        if(factor >  1) aux = rotacionDer(aux, aux.izq.factor());
        return aux;
    }
    
    Nodo rotacionIzq(Nodo nodo, int factor){
        if(factor > 0) nodo.der = rotacionDer(nodo.der, 0);
        Nodo medio = nodo.der;
        nodo.der = medio.izq;
        medio.izq = nodo;
        return medio;
    }
    
    Nodo rotacionDer(Nodo nodo, int factor){
        if(factor < 0) nodo.izq = rotacionIzq(nodo.izq, 0);
        Nodo medio = nodo.izq;
        nodo.izq = medio.der;
        medio.der = nodo;
        return medio;
    }

    void imprimir() {
        Queue<Nodo> cola = new LinkedList<Nodo>();
        if (raiz != null) {
            cola.add(raiz);
            while (!cola.isEmpty()) {
                if (cola.element().izq != null) cola.add(cola.element().izq);
                if (cola.element().der != null) cola.add(cola.element().der);
                System.out.print("[" + cola.element().num + " - " + cola.poll().altura + "]");
            }
        }
        System.out.println("");
    }
    
    int altura (Nodo n){
        if(n != null) return n.altura = Integer.max(altura(n.izq), altura(n.der)) + 1;
        else  return 0;
    }
}

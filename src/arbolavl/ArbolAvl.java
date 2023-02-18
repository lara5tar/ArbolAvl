package arbolavl;

import java.util.LinkedList;
import java.util.Queue;

public class ArbolAvl {

    Nodo raiz;

    void insertarBin(int num) {
        if (raiz == null) {
            raiz = new Nodo(num);
        } else {
            raiz = insertarBin(raiz, num);
        }
    }

    Nodo insertarBin(Nodo aux, int num) {
        if (aux == null) {
            return new Nodo(num);
        } else if (num < aux.num) {
            aux.izq = insertarBin(aux.izq, num);
        } else {
            aux.der = insertarBin(aux.der, num);
        }
        
        int izq = altura(aux.izq);
        int der = altura(aux.der);
        
        if(izq - der < -1){ //carga a la derecha -2
            aux = rotacionIzq(aux, altura(aux.der.izq), altura(aux.der.der));
        }
        if(izq - der > 1){ // carga a la izquierda 2
            aux = rotacionDer(aux, altura(aux.izq.izq), altura(aux.izq.der));
        }
        
        return aux;
    }
    
    Nodo rotacionIzq(Nodo nodo, int izq, int der){
        int factor = izq - der;
        if(factor > 0) nodo.der = rotacionDer(nodo.der, 0, 0);
        
        Nodo medio = nodo.der;
        nodo.der = medio.izq;
        medio.izq = nodo;
        
        return medio;
    }
    
    Nodo rotacionDer(Nodo nodo, int izq, int der){
        int factor = izq - der;
        if(factor < 0) nodo.izq = rotacionIzq(nodo.izq, 0, 0);
        
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
                if (cola.element().izq != null) {
                    cola.add(cola.element().izq);
                }

                if (cola.element().der != null) {
                    cola.add(cola.element().der);
                }

                System.out.print("[" + cola.element().num + " " + cola.poll().altura + "]");

            }
        }

        System.out.println("");

    }
    
    void altura(){
        System.out.println(altura(raiz));
    }
    
    int altura (Nodo nodo){
        if(nodo != null){
            int izq = altura(nodo.izq);
            int der = altura(nodo.der);
            int mayor = Integer.max(izq, der);
            nodo.altura = mayor + 1;
            return nodo.altura; 
        } else {
            return 0;
        }
    }
}

package arbolavl;

import java.util.LinkedList;
import java.util.Queue;

public class ArbolAvl {

    Nodo raiz;

    void insertarBin(int num) {
        if (raiz == null) {
            raiz = new Nodo(num);
        } else {
            insertarBin(raiz, num);
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
        return aux;
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

    void altura() {
        altura(raiz);
    }
    
    int altura (Nodo nodo){
        if(nodo != null){
            int izq = 0, der = 0;
            izq = altura(nodo.izq);
            der = altura(nodo.der);
            
            if(nodo.izq != null) izq = nodo.izq.altura;
            if(nodo.der != null) der = nodo.der.altura;
            nodo.altura = Integer.max(izq, der) + 1;
            return nodo.altura;
        } else {
            return 0;
        }
        
    }
}

/*
if (nodo.der == null && nodo.izq == null) { //si es hoja
                nodo.altura = 1;
            } else if (nodo.izq == null) { //si no es hoja y no tiene hijo izq
                nodo.altura = nodo.der.altura + 1;
            } else if (nodo.der == null) {//si no tiene hijo der
                nodo.altura = nodo.izq.altura + 1;
            } else if (nodo.izq.altura > nodo.der.altura) { // si no es hoja, compara quien es el mayor de lso hijos
                nodo.altura = nodo.izq.altura + 1;
            } else {
                nodo.altura = nodo.der.altura + 1;
            }


int alto = 0;
            if (nodo.izq == null) {//puede ser una hoja
                alto = 1;
                if (nodo.der != null)//si la derecha no es null entonces no es hoja y solo tiene dercha
                    alto = nodo.der.altura + 1;
            } else {//no es hoja pero puede no tener un hijo
                alto = nodo.izq.altura + 1;
                if (nodo.der != null) //si tiene los dos hijos
                    alto = Integer.max(nodo.izq.altura, nodo.der.altura) + 1;
            }
            nodo.altura = alto;

<<<<<<< patch-1
    int altura(nodo n) {
        if(n!=null) //soy hijo
        {
            return n.altura;
        }else return 0; //tengo altura 0 porque no soy hijo valido
=======
    void altura() {
        altura1(raiz);
>>>>>>> master
    }



 */

package arbolavl;

import java.util.LinkedList;
import java.util.Queue;

public class ArbolAvl {

    Nodo raiz;

    void insertar(int num) {
        if (raiz == null) raiz = new Nodo(num);
        else raiz = insertar(raiz, num);
    }

    Nodo insertar(Nodo aux, int num) {
        if (aux == null) return new Nodo(num);
        else if (num < aux.num) aux.izq = insertar(aux.izq, num);
        else aux.der = insertar(aux.der, num);
        altura(aux);
        int factor = aux.factor();
        if(factor < -1) aux = rotacionIzq(aux, aux.der.factor());
        if(factor >  1) aux = rotacionDer(aux, aux.izq.factor());
        return aux;
    }
    Nodo balancear(Nodo n){
        altura(n);
        int factor = n.factor();
        if(factor < -1) n = rotacionIzq(n, n.der.factor());
        if(factor >  1) n = rotacionDer(n, n.izq.factor());
        return n;
    }
    
    void eliminar(int num){
        System.out.println(num);
        raiz = eliminar(raiz, num);
        altura(raiz);
    }
    
    Nodo eliminar(Nodo n, int num){
        if (n == null) System.out.println("No se encontro el numero...");
        else if (n.num == num) { //n = eliminar(n.izq, n.der);
            if (n.izq != null) {
                if (n.izq.der == null) {
                    n.izq.der = n.der;
                    n = balancear(n.izq);
                } else {
                    n.izq.der = mayor(n, n.izq.der);
                    n.izq = balancear(n.izq);
                } 
            } else return n.der;
        }
        else if (num < n.num) n.izq = eliminar(n.izq, num);
        else n.der = eliminar(n.der, num);
        
        if(n == null) return n;
        return balancear(n);
    }
    
    Nodo mayor(Nodo e, Nodo mayor){
        if(mayor.der != null) {
            mayor.der = mayor(e, mayor.der);
            return mayor;
        } else {
            e.num = mayor.num;
            return mayor.izq;
        }
    }

    Nodo eliminarBin(Nodo i, Nodo d) {
        if (i != null) {
            Nodo mayor = i;
            if (i.der != null) {
                Nodo padreM = i;
                mayor = i.der;
                while (padreM.der.der != null) {
                    padreM = padreM.der;
                    mayor = mayor.der;
                }
                padreM.der = mayor.izq;
                mayor.izq = i;
            }
            mayor.der = d; //derecha puede ser null 
            return mayor; 
        }
        return d; // si es hoja, la derecha es null
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
        Queue<Nodo> cola = new LinkedList<>();
        if (raiz != null) {
            cola.add(raiz);
            while (!cola.isEmpty()) {
                if (cola.element().izq != null) cola.add(cola.element().izq);
                if (cola.element().der != null) cola.add(cola.element().der);
                System.out.print("[" + cola.element().num + " - " + cola.poll().altura + "]");
            }
            System.out.println("");
        }else{
            System.out.println("Lista vacia...");
        }
        
    }
    
    int altura (Nodo n){
        if(n != null) return n.altura = Integer.max(altura(n.izq), altura(n.der)) + 1;
        else  return 0;
    }
    
}
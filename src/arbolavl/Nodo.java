package arbolavl;

public class Nodo {

    int num = 0;
    Nodo izq = null;
    Nodo der = null;
    int altura = 0;

    Nodo(int num) { this.num = num; }
    
    int factor(){
        int izq = 0, der = 0;
        if (this.izq != null) izq = this.izq.altura;
        if (this.der != null) der = this.der.altura;
        return izq - der;
    }

}

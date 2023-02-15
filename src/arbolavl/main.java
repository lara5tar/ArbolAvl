package arbolavl;

public class main {

    public static void main(String[] args) {
        ArbolAvl a = new ArbolAvl();
        a.insertarBin(50);
        a.insertarBin(25);
        a.insertarBin(75);
        a.insertarBin(10);
        a.insertarBin(30);
        a.insertarBin(35);
        a.insertarBin(60);
        a.insertarBin(100);
        a.insertarBin(90);
        a.insertarBin(120);
        a.insertarBin(80);
        
        a.altura();
        a.imprimir();
        
        
    }
}

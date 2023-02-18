package arbolavl;

public class main {

    public static void main(String[] args) {
        ArbolAvl a = new ArbolAvl();

       //15 20 17 30 35 18 11 13 4 12
       a.insertarBin(15);
       a.insertarBin(20);
       a.insertarBin(17);
       a.insertarBin(30);
       a.insertarBin(35);
       a.insertarBin(18);
       a.insertarBin(11);
       a.insertarBin(13);
       a.insertarBin(4);
       a.insertarBin(12);
        
       a.imprimir();
        
    }
}

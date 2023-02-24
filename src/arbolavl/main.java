package arbolavl;

public class main {

    public static void main(String[] args) {
        ArbolAvl a = new ArbolAvl();

       //15 20 17 30 35 18 11 13 4 12
       a.insertar(650);
       a.insertar(600);
       a.insertar(800);
       a.insertar(550);
       a.insertar(610);
       a.insertar(700);
       a.insertar(900);
       a.insertar(505);
       a.insertar(605);
       a.insertar(620);
       a.insertar(850);
       a.insertar(615);

       a.imprimir();
       //20 18 17 11 35 4 30 13 15 12 100
       a.eliminar(650);
       a.imprimir();
       
      
        
    }
}

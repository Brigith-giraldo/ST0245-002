
/**
 *
 * @author Kevin Sossa, Dixon
 */
public class Main {

    public static void main(String[] args) {
        
        Contador c = new Contador("test");
        for (int i = 0; i < 10; ++i)
            c.incrementar();
        // 10
        System.out.println(c);

        System.out.println();
        
        
        Punto p = new Punto(1, 1);
        // 0,0
        System.out.printf("Punto: {%f, %f}\n", p.x(), p.y());
        // 1*sqrt(2)
        System.out.println("Radio Polar: " + p.radioPolar());
        // -45
        System.out.println("Angulo Polar: " + Math.toDegrees(p.anguloPolar()));
        // 2
        System.out.println("Distancia euclidiana: " + p.distanciaEuclidiana(new Punto(0, 0)));

        System.out.println();
        
        Fecha f1 = new Fecha(1, 8, 2017);
        Fecha f2 = new Fecha(2, 5, 2016);
        System.out.println(f1);
        System.out.println(f2);
        // 1
        System.out.println(f1.comparar(f2));
        
        System.out.println();
        Line2D l1 = new Line2D(new Punto2D(0, 0), new Punto2D(1,2));
        l1.generarPuntos();
        System.out.println(l1.toString());
    }

}

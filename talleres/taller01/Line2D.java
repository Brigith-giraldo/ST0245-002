
import java.util.ArrayList;


/**
 *
 * @author sossa
 */
public class Line2D {
    
    private final Punto2D inicial;
    private final Punto2D finall;
    private final ArrayList<Punto2D> intermedios;
    
    public Line2D(Punto2D p1, Punto2D p2){
        intermedios = new ArrayList<>();
        if (p1.getX() < p2.getX()){
            this.inicial = p1;
            this.finall = p2;
        }else {
            this.inicial = p2;
            this.finall = p1;
        }
        
    }
    
    public Punto2D getInicial(){
        return this.inicial;
    }
    
    public Punto2D getFinal(){
        return this.finall;
    }
    
    public void generarPuntos(){
        double x1,y1,x2,y2,m;
        x1 = this.inicial.getX();
        y1 = this.inicial.getY();
        x2 = this.finall.getX();
        y2 = this.finall.getY();
        m = (y2 - y1) / (x2 - x1);
        while (true){
            x1 += 1;
            if (x1 == x2) {
                break;
            }
            
            y1 += m;
            if (y1 % 1 == 0){
                intermedios.add(new Punto2D((int)x1, (int)y1));
            }

        }
    }
    
    public String toString(){
        String out = this.inicial.toString() + "\n";
        for (Punto2D puntos : intermedios) {
            out += puntos.toString() + "\n";
        }
        out += this.finall.toString();
        return out;
    }
}

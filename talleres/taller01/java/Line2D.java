
import java.util.ArrayList;


/**
 *
 * @author Kevin Sossa, Dixon
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
        m = Math.ceil((y2 - y1) / (x2 - x1));
        while (x1 < x2){
            x1 += 1;
	    y1 -= 1;
            for (int i = 0; i <= m; i++){
		y1 += 1;
		intermedios.add(new Punto2D((int)x1, (int)y1));
	    }
        }
    }
    
    public String toString(){
        String out = this.inicial.toString() + "\n";
        for (Punto2D puntos : intermedios) {
            out += puntos.toString() + "\n";
        }
        return out;
    }
}

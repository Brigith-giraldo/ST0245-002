
import java.util.ArrayList;


/**
 *
 * @author Kevin Sossa, Dixon Calderon
 */
public class Line2D {
    
    private final Punto inicial;
    private final Punto finall;
    private final ArrayList<Punto> intermedios;
    
    public Line2D(Punto p1, Punto p2){
        intermedios = new ArrayList<>();
        if (p1.x() < p2.y()){
            this.inicial = p1;
            this.finall = p2;
        }else {
            this.inicial = p2;
            this.finall = p1;
        }
        
    }
    
    public Punto getInicial(){
        return this.inicial;
    }
    
    public Punto getFinal(){
        return this.finall;
    }
    
    public void generarPuntos(){
        double x1,y1,x2,y2,m;
        x1 = this.inicial.x();
        y1 = this.inicial.y();
        x2 = this.finall.x();
        y2 = this.finall.y();
        m = Math.ceil((y2 - y1) / (x2 - x1));
        while (x1 < x2){
            x1 += 1;
	    y1 -= 1;
            for (int i = 0; i <= m; i++){
		y1 += 1;
		intermedios.add(new Punto((int)x1, (int)y1));
	    }
        }
    }
    
    public String toString(){
        String out = this.inicial.toString() + "\n";
        for (Punto puntos : intermedios) {
            out += puntos.toString() + "\n";
        }
        return out;
    }
}


/**
 *
 * @author sossa
 */
public class Punto2D {
    private int x, y;

    public Punto2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    @Override
    public String toString(){
        return "("+x+","+y+")";
    }
}

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class DatosEstu{
    
    

    //estrato -> gini = puro ->
    // p0 = bajo prom
    // p1 = sobre prom

    // P0 = n0/n = 10/30
    // P1 = n1/(n) = 20/30

    // lg = 1 -(P0^2 + P1^2)

    // lp = (n0*l0 + n1*l1) / n

    public static void leerArchivo(){
        List<String[]> data = new ArrayList<>();

        File dataFile = new File("4_train_balanced_135000.csv");
        try {
            FileReader fr = new FileReader(dataFile);
            BufferedReader bf = new BufferedReader(fr);
            String line;
            while ((line = bf.readLine())!=null) {
                data.add(line.split(";"));
            }
        } catch (IOException e) {
            System.out.println(e);
        }

        Gini.rows(data);
    }

    

    public static void main(String[] args) {
        DatosEstu.leerArchivo();
        /*for (String[] s : data) {
            for (String s2 : s) {
                System.out.println(s2+" : 0 ");
            }
            System.out.println();
            break;
        }*/
    }
}
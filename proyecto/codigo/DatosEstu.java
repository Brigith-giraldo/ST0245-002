import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class DatosEstu{

    public static List<String[]> leerArchivo(String s){
        List<String[]> data = new ArrayList<>();

        File dataFile = new File(s);
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
        return data;
    }

    

    public static void main(String[] args) {
        long start,end;
        start = System.currentTimeMillis();
        DecisionTree tree = new DecisionTree(DatosEstu.leerArchivo("4_train_balanced_135000.csv"));
        end = System.currentTimeMillis();
        System.out.println("Tree time: "+(end-start));
        List<String[]> test = DatosEstu.leerArchivo("4_test_balanced_45000.csv");

        int yes=0,not=0,cant=0;
        start = System.currentTimeMillis();
        //tree.print();
        //System.out.println(4998+" "+tree.use(test.get(4998)));
        String aux;
        for (int i = 1; i < test.size(); i++){
            aux = tree.use(test.get(i));
            //System.out.println(i+": "+aux);
            cant += 1;
            if (aux.equals("Correct")){
                yes+=1;
            }else {
                not +=1;
            }
        }//*/
        end = System.currentTimeMillis();
        System.out.println("test: "+(end-start));
        System.out.println("Yes: "+yes
                        +"\nNot: "+not
                        +"\nCant: "+cant);
        System.out.println("Porcentaje: "+(100/(float)cant)*yes+"%");
    }
}
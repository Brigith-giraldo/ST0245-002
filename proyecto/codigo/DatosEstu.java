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
        DecisionTree tree = new DecisionTree(DatosEstu.leerArchivo("4_train_balanced_135000.csv"));
        List<String[]> test = DatosEstu.leerArchivo("4_test_balanced_45000.csv");
        //tree.print();
        String aux;
        int yes=0,not=0,cant=0;
        for (int i = 1; i < test.size(); i++){
            aux = tree.use(test.get(i));
            //System.out.println(i+": "+aux);
            cant += 1;
            if (aux.equals("Correct")){
                yes+=1;
            }else {
                not +=1;
            }
        }
        System.out.println("Yes: "+yes
                        +"\nNot: "+not
                        +"\nCant: "+cant);
    }
}
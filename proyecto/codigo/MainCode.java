
import src.*;
import java.util.List;

public class MainCode {
    public static void main(String[] args) {
        long start,end;
        start = System.currentTimeMillis();
        Forest f1 = new Forest(DatosEstu.leerArchivo("data/4_train_balanced_135000.csv"),100);
        end = System.currentTimeMillis();
        System.out.println("Forest time: "+(end-start));

        start = System.currentTimeMillis();
        List<String[]> test = DatosEstu.leerArchivo("data/4_test_balanced_45000.csv");
        int yes=0,not=0,cant=0;
        
        //tree.print();
        for (int i = 1; i < test.size(); i++){
            //System.out.println(i+": "+aux);
            cant += 1;
            if (f1.use(test.get(i))){
                yes+=1;
            }else {
                not +=1;
            }
        }
        end = System.currentTimeMillis();
        System.out.println("Test time: "+(end-start));
        System.out.println("Correct: "+yes
                        +"\nIncorrect: "+not
                        +"\nCant: "+cant);
        System.out.println("Precision: "+(100/(float)cant)*yes+"%");
    }
}

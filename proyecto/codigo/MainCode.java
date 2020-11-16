
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
        float falsepositive = 0,falsenegative=0,truepositive=0,truenegative=0,cant=0;
        //tree.print();
        for (int i = 1; i < test.size(); i++){
            //System.out.println(i+": "+aux);
            cant += 1;
            if (f1.use(test.get(i)).equals(test.get(i)[test.get(0).length-1])){
                if (test.get(i)[test.get(0).length-1].equals("1")){
                    truepositive+=1;
                }else{
                    truenegative+=1;
                }
            }else {
                if (test.get(i)[test.get(0).length-1].equals("1")){
                    falsenegative+=1;
                }else{
                    falsepositive+=1;
                }
            }
        }
        end = System.currentTimeMillis();
        System.out.println("Test time: "+(end-start));
        //System.out.println("truepositives: "+truepositive);
        //System.out.println("truenegatives: "+truenegative);
        //System.out.println("falsepositives: "+falsepositive);
        //System.out.println("falsenegative: "+falsenegative);
        //System.out.println("Correct: "+yes
        //                +"\nIncorrect: "+not
        //                +"\nCant: "+cant);
        System.out.println("Accuracy: "+( (truepositive+truenegative) / (cant))*100);
        System.out.println("Recall: "+(truepositive/(truepositive+falsenegative))*100);
        System.out.println("Precision: "+(truepositive/(truepositive+falsepositive))*100+"%");
    }
}

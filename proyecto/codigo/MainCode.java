
import src.*;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.util.List;

/**
 * This class allows you to run the whole project and
 * calculate its execution time as the memory it consumes
 * @author Kevin Sossa
 * @author Dixon Calderon
 * @version 1
 */
public class MainCode {
    public static void main(String[] args) {
        MemoryMXBean mbean = ManagementFactory.getMemoryMXBean();
        MemoryUsage memoryStart , memoryEnd;
        long start,end;

        System.gc();
        start = System.currentTimeMillis();
        memoryStart = mbean.getHeapMemoryUsage();

        Forest f1 = new Forest(DatosEstu.leerArchivo("data/4_train_balanced_135000.csv"),100);

        System.gc();
        end = System.currentTimeMillis();
        memoryEnd = mbean.getHeapMemoryUsage();

        System.out.println("\n#############################");
        System.out.println("Forest time: "+(end-start)/1000+"s");
        System.out.println("Forest memory: "+(memoryEnd.getUsed()-memoryStart.getUsed())/1000000+"mb");
        System.out.println("#############################\n");

        System.gc();
        start = System.currentTimeMillis();
        memoryStart = mbean.getHeapMemoryUsage();

        List<String[]> test = DatosEstu.leerArchivo("data/4_test_balanced_45000.csv");
        float falsepositive = 0,falsenegative=0,truepositive=0,truenegative=0,cant=0;
        for (int i = 1; i < test.size(); i++){
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
        System.gc();
        end = System.currentTimeMillis();
        memoryEnd = mbean.getHeapMemoryUsage();

        System.out.println("\n#############################");
        System.out.println("Test time: "+(end-start)/1000+"s");
        System.out.println("Test memory: "+(memoryEnd.getUsed()-memoryStart.getUsed())/1000000+"mb");
        System.out.println("#############################\n");

        System.out.println("Accuracy: "+( (truepositive+truenegative) / (cant))*100);
        System.out.println("Recall: "+(truepositive/(truepositive+falsenegative))*100);
        System.out.println("Precision: "+(truepositive/(truepositive+falsepositive))*100+"%");
    }
}


import java.util.ArrayList;
import java.util.List;
import java.util.HashSet; 



public class Gini {
    
    public static void rows(List<String[]> data){
        HashSet<String> save;
        float pondered;
        for (int j = 1; j < data.get(0).length;j++){
            save = new HashSet<String>();
            for (int i = 1; i < data.size();i++){
                if (!save.contains(data.get(i)[j])){
                    save.add(data.get(i)[j]);
                    pondered = ponderedGiniValue(data, j, data.get(i)[j]);
                    System.out.println(data.get(0)[j]+" = "+data.get(i)[j]+" -> "+pondered);
                }
            }
            System.out.println("***************************");
        }
    }
    
    public static float ponderedGiniValue(List<String[]> data, int row, String value){
        List<String[]> yes = new ArrayList<>();
        List<String[]> no = new ArrayList<>();

        for (int i = 1; i < data.size(); i++){
            
            if (data.get(i)[row].equalsIgnoreCase(value)){
                
                yes.add(data.get(i));
            }else{
                //System.out.println(i+" "+data.get(i)[row]+" "+value);
                no.add(data.get(i));
            }
        }
        float giniYes = gini(yes);
        float giniNo = gini(no);
        return ((yes.size()*giniYes + no.size()*giniNo) / (data.size() -1));
    }

    public static float gini(List<String[]> data){
        float p0=0,p1=0;
        for (int i = 0; i < data.size(); i++){
            if (data.get(i)[data.get(0).length-1].equalsIgnoreCase("1")){
                p1 += 1;
            }else{
                p0 += 1;
            }
        }
        p0 /= data.size();
        p1 /= data.size();
        //System.out.println(1-(p0*p0 + p1*p1));
        return (1-(p0*p0 + p1*p1));
    }
}

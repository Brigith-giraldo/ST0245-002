
import java.util.AbstractMap; 
import java.util.List;
import java.util.HashSet; 

public class Gini {
    
    public static AbstractMap.SimpleEntry<String,Integer> bestOption(List<String[]> data, HashSet<String> ignore){
        String decision="";
        int decisionRow = -1;
        float pondered = 10;
        float aux;
        for (int j = 0; j < data.get(0).length;j++){
            
            if (ignore.contains(data.get(0)[j].toUpperCase())){
                continue;
            }
            aux = ponderedGini(data, j);
            //System.out.println(data.get(0)[j].toUpperCase()+" -> "+aux);
            if (aux<=pondered){
                decisionRow = j;
                pondered = aux;
                decision = data.get(0)[j].toUpperCase();
            }
        }
        //System.out.println("Mejor es: "+decision+" = "+pondered);
        return new AbstractMap.SimpleEntry<>(decision,decisionRow);
    }
    
    public static float ponderedGini(List<String[]> data, int row){
        HashSet<String> save = new HashSet<>();
        float pondered = 0;
        AbstractMap.SimpleEntry<Integer,Float> aux;
        for (int i = 1; i < data.size(); i++){
            if (!save.contains(tools.generateOption(data.get(i)[row],row))){
                save.add(tools.generateOption(data.get(i)[row],row));
                aux = gini(data, row, tools.generateOption(data.get(i)[row],row));
                pondered += ((float)aux.getKey()/((float)data.size()-1)) * aux.getValue();
            }
        }
        return pondered;
    }

    public static AbstractMap.SimpleEntry<Integer,Float> gini(List<String[]> data,int row, String value){
        float p0=0,p1=0;
        int cant = 0;
        for (int i = 1; i < data.size(); i++){
            if (tools.generateOption(data.get(i)[row],row).equalsIgnoreCase(value)){
                cant += 1;
                if (data.get(i)[data.get(0).length-1].equalsIgnoreCase("1")){
                    p1 += 1;
                }else{
                    p0 += 1;
                }
            }
        }
        p0 /= cant;
        p1 /= cant;
        //System.out.println(data.get(0)[row] + " = "+ value +" gini: "+(1-(p0*p0) - (p1*p1)));
        return new AbstractMap.SimpleEntry<>(cant, (1-(p0*p0) - (p1*p1)) );
    }
}

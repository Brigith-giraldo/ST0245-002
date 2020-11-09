import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet; 
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;

public class Node {
    private List<String[]> data;
    private HashMap<String,Node> options;
    private HashSet<String> ignore;
    private String decision;
    private int rowDecision;
    
    public Node(String decision, int rowDecision,HashSet<String> ignore, List<String[]> data){
        //System.out.println(decision);
        this.decision = decision;
        this.rowDecision = rowDecision;
        this.ignore = ignore;
        this.ignore.add(decision.toUpperCase());
        this.data = data;
        if(!isPure() && rowDecision != -1){
            addOptions();
        }
    }

    public static void print(Node n){
        Queue<Node> q = new LinkedList<>();
        q.add(n);
        Node curr;
        Node next;
        while (!q.isEmpty()){
            curr = q.poll();
            if (curr.options != null){
                for (String keys: curr.options.keySet()){
                    next = curr.options.get(keys);
                    q.add(next);
                    System.out.println("\""+curr.decision+"\"" +" -> "+"\""+next.decision+"\" [ label = \""+keys+"\"]");
                }
            }
        }
    }

    private boolean isPure(){
        String aux = data.get(1)[data.get(0).length -1];
        for (int i = 1; i < data.size(); i++){
            if (!data.get(i)[data.get(0).length -1].equals(aux)){
                return false;
            }
        }
        return true;
    }
    
    private void addOptions(){
        HashMap<String,List<String[]>> newData = divideData();
        this.options = new HashMap<>();
        AbstractMap.SimpleEntry<String,Integer> best;
        Node n;
        for (String keys : newData.keySet()) {
            best = Gini.bestOption(newData.get(keys),this.ignore);
            
            if (best.getValue() == -1 || newData.get(keys).size() == 2){
                //System.out.println("-> \""+this.decision+"\"" +" -> "+"\""+best.getKey()+"\" [ label = \""+keys+"\"]");
                n = new Node("null",best.getValue(), ignore, newData.get(keys));
            }else{
                n = new Node(best.getKey(),best.getValue(),ignore, newData.get(keys));
            }
            
             
            options.put(keys, n);
        }
    }

    private HashMap<String,List<String[]>> divideData(){
        HashMap<String,List<String[]>> newData = new HashMap<>();
        for (int i = 1; i < data.size(); i++){
            if (newData.containsKey(data.get(i)[rowDecision])){
                newData.get(data.get(i)[rowDecision]).add(data.get(i));
            }else{
                List<String[]> aux = new ArrayList<>();
                aux.add(data.get(0));
                aux.add(data.get(i));
                newData.put(data.get(i)[rowDecision], aux);
            }
        }
        return newData;
    }

    public String getDecision(){
        return this.decision;
    }
    public int getRowDecision(){
        return this.rowDecision;
    }
    public boolean notNull(){
        return this.options == null;
    }
    public Node getNextNode(String s){
        return this.options.get(s);
    }
    public boolean getResponse(){
        return this.data.get(1)[data.get(0).length-1].equals("1");
    }
}

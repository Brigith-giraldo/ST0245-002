package src;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;
import java.io.*;

/**
 * this class is where the data of the node and its respective
 * methods necessary for its creation and use are stored
 * @author Kevin Sossa
 * @author Dixon Calderon
 * @version 1
 */
public class Node {
    private List<String[]> data;
    private HashMap<String,Node> options;
    private HashSet<String> ignore;
    private String decision;
    private int rowDecision;

	/**
	 * Method constructor
	 * @param decision - question to ask in this node
	 * @param rowDecision - row where the question is located
	 * @param data - student data
	 * @param ignore - questions I don't have to ask
	 */
    public Node(String decision, int rowDecision,HashSet<String> ignore, List<String[]> data){
        //System.out.println(decision);
        this.options = null;
        this.decision = decision;
        this.rowDecision = rowDecision;
        this.ignore = (HashSet<String>)ignore.clone();
        this.ignore.add(decision.toUpperCase());
        this.data = data;
        if(data.size() >  2&& !decision.equals("null") && !isPure()){
            addOptions();
        }
    }

	/**
	 * Method for print the tree
	 * @param n - node from which you will start printing
	 */
    public static void print(Node n){

		try {
            File file = new File("./../tree.txt");
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw= new BufferedWriter(fw);
            Queue<Node> q = new LinkedList<>();
            q.add(n);
            Node curr;
            Node next;
            while (!q.isEmpty()){
                curr = q.poll();
                if (curr.options != null){
                    for (String keys: curr.options.keySet()){
                        next = curr.options.get(keys);
                        if (next!=null){
                            q.add(next);
                            bw.write("\""+curr.decision+"\"" +" -> "+"\""+next.decision+"\" [ label = \""+keys+"\"]\n");
                        }

                        //System.out.println("\""+curr.decision+"\"" +" -> "+"\""+next.decision+"\" [ label = \""+keys+"\"]");
                    }
                }
            }
		} catch (IOException e) {
			e.printStackTrace();
		}

    }

	/**
	 * method to calculate if the node has data from students with different outcomes
	 * @return returns if all have the same result or not
	 */
    private boolean isPure(){
        String aux = data.get(1)[data.get(0).length -1];
        for (int i = 1; i < data.size(); i++){
            if (!data.get(i)[data.get(0).length -1].equals(aux)){
                return false;
            }
        }
        return true;
    }

	/**
	 * Method to add branches to the node
	 */
    private void addOptions(){
        HashMap<String,List<String[]>> newData = divideData();
        this.options = new HashMap<>();
        AbstractMap.SimpleEntry<String,Integer> best;
        Node n;
        for (String keys : newData.keySet()) {
            best = Gini.bestOption(newData.get(keys),this.ignore);

            if (best.getValue() == -1){
                //System.out.println("-> \""+this.decision+"\"" +" -> "+"\""+best.getKey()+"\" [ label = \""+keys+"\"]");
                n = new Node("null",best.getValue(),ignore, newData.get(keys));
            }else{
                n = new Node(best.getKey(),best.getValue(),ignore, newData.get(keys));
            }


            options.put(keys, n);
        }
    }

	/**
	 * method to divide students into different sub-sets
	 * according to their answer to the node question
	 * @return a map with the different sub-sets
	 */
    private HashMap<String,List<String[]>> divideData(){
        HashMap<String,List<String[]>> newData = new HashMap<>();
        for (int i = 1; i < data.size(); i++){
            if (newData.containsKey(tools.generateOption(data.get(i)[rowDecision],rowDecision))){
                newData.get(tools.generateOption(data.get(i)[rowDecision],rowDecision)).add(data.get(i));
            }else{
                List<String[]> aux = new ArrayList<>();
                aux.add(data.get(0));
                aux.add(data.get(i));
                newData.put(tools.generateOption(data.get(i)[rowDecision],rowDecision), aux);
            }
        }
        return newData;
    }

	/**
	 * method to return the private variable "decision"
	 * @return decision
	 */
    public String getDecision(){
        return this.decision;
    }

	/**
	 * method to return the private variable "rowdecisio"
	 * @return rowdecision
	 */
    public int getRowDecision(){
        return this.rowDecision;
    }

	/**
	 * method to know if the node does not have a question or more branches
	 * @return true if the node has more branches and a question, false if not
	 */
    public boolean notNull(){
        return (this.options != null && !this.decision.equals("null"));
    }

	/**
	 * method to take the next node depending on an answer
	 * @param s - answer to a question
	 * @return next nodo depending on a answer
	 */
    public Node getNextNode(String s){
        return this.options.get(s);
    }

	/**
	 * method to define in that node if the majority is successful or not
	 * @return if majority is successful return 1 else return 0
	 */
    public String getResponse(){
        int yes = 0,no = 0;
        for (int i = 1; i < this.data.size(); i++){
            if (this.data.get(1)[data.get(i).length-1].equals("1")){
                yes += 1;
            }else{
                no += 1;
            }
        }
        return (yes > no) ? "1" : "0";
    }
}

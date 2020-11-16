package src;

import java.util.ArrayList;
import java.util.List;

public class Forest {
    private DecisionTree trees[];
    public Forest (List<String[]> data, int Ntrees){
        trees = new DecisionTree[Ntrees];
        List<String[]> DividedData[] = new List[Ntrees];
        int aux = Ntrees;
        for (int i = 0; i < Ntrees; i++){
            DividedData[i] = new ArrayList<>();
            DividedData[i].add(data.get(0));
        }
        for (int i = 1; i < data.size(); i++){
            DividedData[aux-1].add(data.get(i));
            aux -= 1;
            if (aux == 0){
                aux = Ntrees;
            }
        }
        for (int i = 0; i < Ntrees; i++){
            trees[i] = new DecisionTree(DividedData[i]);
        }
    }

    public String use(String[] s){
        int yes = 0, no = 0;
        for (int i = 0; i < trees.length; i++){
            if (trees[i].use(s).equals("1")){
                yes += 1;
            }else {
                no += 1;
            }
        } 
        return yes > no ? "1" : "0";
    }
}

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.HashSet; 
import java.util.HashMap;

class Node {
    private List<String[]> data;
    private HashMap <String,Node> options;
    private HashSet<String> ignore;
    private String decision;
    private int rowDecision;
    
    public Node(String decision, int rowDecision,HashSet<String> ignore, List<String[]> data){
        System.out.println(decision);
        this.decision = decision;
        this.rowDecision = rowDecision;
        this.ignore = ignore;
        ignore.add(decision.toUpperCase());
        this.data = data;
        addOptions();
    }

    private void addOptions(){
        HashMap<String,List<String[]>> newData = divideData();
        /*for (String keys : newData.keySet()){
            System.out.println("====================  "+keys+"  ====================");
            List<String[]> aux = newData.get(keys);
            for (int i = 0; i < aux.size(); i++){
                System.out.println(aux.get(i)[0]);
            }
        }*/
        for (String keys : newData.keySet()) {
            AbstractMap.SimpleEntry<String,Integer> best = Gini.bestOption(newData.get(keys),ignore);
            if (best.getValue() == -1) {
                continue;
            }
            options.put(keys, new Node(best.getKey(),best.getValue(), ignore, newData.get(keys)));
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
}
public class DecisionTree {
    private Node root;
    public DecisionTree(List<String[]> data){
        HashSet<String> ignore = new HashSet<String>(Arrays.asList("ESTU_TIPODOCUMENTO.1","ESTU_NACIONALIDAD.1","ESTU_GENERO.1",
        "ESTU_FECHANACIMIENTO.1","PERIODO.1","ESTU_CONSECUTIVO.1","ESTU_ESTUDIANTE.1","ESTU_PAIS_RESIDE.1","ESTU_TIENEETNIA","ESTU_ETNIA",
        "ESTU_LIMITA_MOTRIZ","ESTU_LIMITA_INVIDENTE","ESTU_LIMITA_CONDICIONESPECIAL","ESTU_LIMITA_SORDO","ESTU_LIMITA_SDOWN",
        "ESTU_LIMITA_AUTISMO","ESTU_DEPTO_RESIDE.1","ESTU_COD_RESIDE_DEPTO.1","ESTU_MCPIO_RESIDE.1","ESTU_COD_RESIDE_MCPIO.1",
        "ESTU_AREARESIDE","ESTU_MESTERMINOBACHILLER","ESTU_ANOTERMINOBACHILLER","ESTU_VALORPENSIONCOLEGIO","ESTU_FECHAGRADOBACHILLER",
        "FAMI_ESTRATOVIVIENDA.1","FAMI_PISOSHOGAR","FAMI_NIVELSISBEN","FAMI_TIENELAVADORA","FAMI_TIENEHORNOMICROOGAS","FAMI_TIENEMICROONDAS",
        "FAMI_TIENEHORNO","FAMI_TIENEDVD","FAMI_INGRESOFMILIARMENSUAL","FAMI_COMELECHEDERIVADOS","FAMI_COMECARNEPESCADOHUEVO",
        "FAMI_COMECEREALFRUTOSLEGUMBRE","ESTU_TIPOREMUNERACION","ESTU_ANOMATRICULAPRIMERO","ESTU_ANOTERMINOQUINTO","ESTU_ANOMATRICULASEXTO",
        "ESTU_ANOSCOLEGIOACTUAL","ESTU_TOTALALUMNOSCURSO","ESTU_IESDESEADA","ESTU_COD_IESDESEADA","ESTU_MCPIOIESDESEADA","ESTU_COD_MCPIOIESDESEADA",
        "ESTU_INSTPORPRESTIGIO","ESTU_INSTPORCOSTOMATRICULA","ESTU_INSTPORUNICAQUEOFRECE","ESTU_INSTPOROPORTUNIDADES","ESTU_INSTPORAMIGOSESTUDIANDO",
        "ESTU_INSTPOROTRARAZON","ESTU_COD_PROGRAMADESEADO","ESTU_PROGRAMADESEADO","ESTU_PROGORIENTACIONVOCACIONAL","ESTU_PROGPORBUSCANDOCARRERA",
        "ESTU_PROGPORCOLOMBIAAPRENDE","ESTU_PROGPORINTERESPERSONAL","ESTU_PROGPORTRADICIONFAMILIAR","ESTU_PROGPORMEJORARPOSICSOCIAL",
        "ESTU_PROGPORINFLUENCIAALGUIEN","COLE_CODIGO_ICFES","COLE_COD_DANE_ESTABLECIMIENTO","COLE_NOMBRE_ESTABLECIMIENTO","COLE_GENERO",
        "COLE_CALENDARIO","COLE_COD_DANE_SEDE","COLE_NOMBRE_SEDE","COLE_SEDE_PRINCIPAL","COLE_AREA_UBICACION","COLE_COD_MCPIO_UBICACION",
        "COLE_MCPIO_UBICACION","COLE_COD_DEPTO_UBICACION","COLE_DEPTO_UBICACION","ESTU_COD_MCPIO_PRESENTACION","ESTU_MCPIO_PRESENTACION",
        "ESTU_DEPTO_PRESENTACION","ESTU_COD_DEPTO_PRESENTACION","EXITO"));
        AbstractMap.SimpleEntry<String,Integer> best = Gini.bestOption(data, ignore);
        root = new Node(best.getKey(), best.getValue(),ignore,data);
    }
}

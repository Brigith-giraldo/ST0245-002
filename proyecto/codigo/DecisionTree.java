import java.util.AbstractMap;
import java.util.List;
import java.util.Arrays;
import java.util.HashSet;

public class DecisionTree {
    private Node root;
    public DecisionTree(List<String[]> data){
        HashSet<String> ignore = new HashSet<String>(Arrays.asList("COLE_NOMBRE_SEDE","ESTU_TIPODOCUMENTO.1","ESTU_NACIONALIDAD.1","ESTU_GENERO.1",
        "ESTU_FECHANACIMIENTO.1","PERIODO.1","ESTU_CONSECUTIVO.1","ESTU_ESTUDIANTE.1","ESTU_TIENEETNIA","ESTU_ETNIA",
        "ESTU_LIMITA_MOTRIZ","ESTU_LIMITA_INVIDENTE","ESTU_LIMITA_CONDICIONESPECIAL","ESTU_LIMITA_SORDO","ESTU_LIMITA_SDOWN",
        "ESTU_LIMITA_AUTISMO","ESTU_COD_RESIDE_DEPTO.1","ESTU_COD_RESIDE_MCPIO.1","ESTU_MESTERMINOBACHILLER",
        "ESTU_ANOTERMINOBACHILLER","ESTU_VALORPENSIONCOLEGIO","ESTU_FECHAGRADOBACHILLER","FAMI_ESTRATOVIVIENDA.1",
        "FAMI_PISOSHOGAR","FAMI_NIVELSISBEN","FAMI_INGRESOFMILIARMENSUAL","FAMI_COMELECHEDERIVADOS","FAMI_COMECARNEPESCADOHUEVO",
        "FAMI_COMECEREALFRUTOSLEGUMBRE","ESTU_TIPOREMUNERACION","ESTU_ANOMATRICULAPRIMERO","ESTU_ANOTERMINOQUINTO","ESTU_ANOMATRICULASEXTO",
        "ESTU_ANOSCOLEGIOACTUAL","ESTU_TOTALALUMNOSCURSO","ESTU_IESDESEADA","ESTU_COD_IESDESEADA","ESTU_MCPIOIESDESEADA","ESTU_COD_MCPIOIESDESEADA",
        "ESTU_INSTPORCOSTOMATRICULA","ESTU_INSTPORUNICAQUEOFRECE","ESTU_INSTPOROTRARAZON","ESTU_COD_PROGRAMADESEADO",
        "ESTU_PROGPORTRADICIONFAMILIAR","COLE_CODIGO_ICFES","COLE_COD_DANE_ESTABLECIMIENTO","COLE_GENERO","COLE_COD_DANE_SEDE",
        "COLE_COD_MCPIO_UBICACION","COLE_COD_DEPTO_UBICACION","ESTU_COD_MCPIO_PRESENTACION","ESTU_COD_DEPTO_PRESENTACION",
        "EXITO","PUNT_INGLES","PUNT_QUIMICA","PUNT_BIOLOGIA","PUNT_CIENCIAS_SOCIALES","PUNT_MATEMATICAS","PUNT_FISICA",
        "PUNT_LENGUAJE","PUNT_FILOSOFIA","ESTU_INST_COD_DEPARTAMENTO","PUNTAJE_PROF","COLE_NOMBRE_ESTABLECIMIENTO",
        "ESTU_MCPIO_RESIDE.1","COLE_MCPIO_UBICACION","COLE_DEPTO_UBICACION","ESTU_DEPTO_RESIDE.1","PERIODO","ESTU_EXTERIOR"));
        AbstractMap.SimpleEntry<String,Integer> best = Gini.bestOption(data,ignore);
        root = new Node(best.getKey(), best.getValue(),ignore,data);
    }

    public void print(){
        Node.print(root);
    }

    public String use(String[] s){
        Node n = root;
        int rowDecision;
        while (!n.getDecision().equals("null") && n.notNull()){
            rowDecision = n.getRowDecision();
            n = n.getNextNode(s[rowDecision]);
        }
        if ( ( s[s.length-1].equals("1") && n.getResponse()) || (s[s.length-1].equals("1") && !n.getResponse()) ){
            return("Correct");
        }else {
            return("Incorrect");
        }
    }
}

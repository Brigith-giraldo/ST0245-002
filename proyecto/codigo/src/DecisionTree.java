package src;

import java.util.AbstractMap;
import java.util.List;
import java.util.Arrays;
import java.util.HashSet;

/**
 * this class is where you start creating the decision tree
 * @author Kevin Sossa
 * @author Dixon Calderon
 * @version 1
 */
public class DecisionTree {
    private Node root;

	/**
	 * Method constructor
	 * @param data - student data
	 */
    public DecisionTree(List<String[]> data){
        HashSet<String> ignore;
        ignore = new HashSet<String>(Arrays.asList("COLE_NOMBRE_SEDE","ESTU_TIPODOCUMENTO.1","ESTU_NACIONALIDAD.1","ESTU_GENERO.1",
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
        "EXITO","ESTU_INST_COD_DEPARTAMENTO","COLE_NOMBRE_ESTABLECIMIENTO",
        "ESTU_MCPIO_RESIDE.1","COLE_MCPIO_UBICACION","COLE_DEPTO_UBICACION","ESTU_DEPTO_RESIDE.1","PERIODO","ESTU_EXTERIOR",
        "FAMI_EDUCACIONPADRE.1","FAMI_TRABAJOLABORMADRE","FAMI_TRABAJOLABORPADRE","FAMI_EDUCACIONMADRE.1","COLE_AREA_UBICACION",
        "FAMI_OCUPACIONMADRE.1","FAMI_TIENE_CELULAR.1","FAMI_OCUPACIONPADRE.1","FAMI_TIENECOMPUTADOR.1","FAMI_TIENEINTERNET.1",
        "COLE_SEDE_PRINCIPAL","FAMI_TELEFONO.1","FAMI_TIENE_NEVERA.1","FAMI_TIENEAUTOMOVIL.1","ESTU_PAIS_RESIDE.1","ESTU_AREARESIDE",
        "FAMI_TIENEHORNO","ESTU_PAIS_RESIDE.1","FAMI_TIENEDVD","FAMI_TIENEMICROONDAS"));

        AbstractMap.SimpleEntry<String,Integer> best = Gini.bestOption(data,ignore);
        root = new Node(best.getKey(), best.getValue(),ignore,data);
    }

	/**
	 * method to print the tree from the root
	 */
    public void print(){
        Node.print(root);
    }

	/**
	 *  method to evaluate a student's results
	 * @param s - student results
	 * @return the response that the tree should have
	 */
    public String use(String[] s){
        Node n = this.root;
        int rowDecision;
        while (n.notNull()){
            rowDecision = n.getRowDecision();
            if (n.getNextNode(tools.generateOption(s[rowDecision],rowDecision)) != null){
                n = n.getNextNode(tools.generateOption(s[rowDecision],rowDecision));
            }else{
                break;
            }
        }
        return n.getResponse();
    }
}

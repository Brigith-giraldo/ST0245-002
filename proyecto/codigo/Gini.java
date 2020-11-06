
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.HashSet; 



public class Gini {
    
    public static void rows(List<String[]> data){
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
        HashSet<String> save;
        String d1="",d2="";
        float d3 = 1;
        float pondered;
        for (int j = 0; j < data.get(0).length;j++){
            save = new HashSet<String>();
            
            if (ignore.contains(data.get(0)[j].toUpperCase())){
                continue;
            }
            System.out.println(data.get(0)[j].toUpperCase());
            for (int i = 1; i < data.size();i++){
                if (!save.contains(data.get(i)[j])){
                    save.add(data.get(i)[j]);
                    pondered = ponderedGiniValue(data, j, data.get(i)[j]);
                    //System.out.println(data.get(0)[j]+" = "+data.get(i)[j]+" -> "+pondered);
                    if (pondered < d3){
                        d1 = data.get(0)[j];
                        d2 = data.get(i)[j];
                        d3 = pondered;
                    }
                }
            }
            //System.out.println("***************************");
        }
        System.out.println("Mejor es: "+d1+" = "+d2+" -> "+d3);
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

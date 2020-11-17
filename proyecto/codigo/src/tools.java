package src;

/**
 * class to have tools needed in various parts of the project
 * @author Kevin Sossa
 * @author Dixon Calderon
 * @version 1
 */
public class tools {
    private static String[] data = {"estu_consecutivo.1","estu_exterior","periodo","estu_tieneetnia","estu_tomo_cursopreparacion",
    "estu_cursodocentesies","estu_cursoiesapoyoexterno","estu_cursoiesexterna","estu_simulacrotipoicfes",
    "estu_actividadrefuerzoareas","estu_actividadrefuerzogeneric","fami_trabajolaborpadre","fami_trabajolabormadre",
    "fami_numlibros","estu_inst_cod_departamento","estu_tipodocumento.1","estu_nacionalidad.1","estu_genero.1",
    "estu_fechanacimiento.1","periodo.1","estu_estudiante.1","estu_pais_reside.1","estu_depto_reside.1","estu_cod_reside_depto.1",
    "estu_mcpio_reside.1","estu_cod_reside_mcpio.1","estu_areareside","estu_valorpensioncolegio","fami_educacionpadre.1",
    "fami_educacionmadre.1","fami_ocupacionpadre.1","fami_ocupacionmadre.1","fami_estratovivienda.1","fami_nivelsisben",
    "fami_pisoshogar","fami_tieneinternet.1","fami_tienecomputador.1","fami_tienemicroondas","fami_tienehorno",
    "fami_tieneautomovil.1","fami_tienedvd","fami_tiene_nevera.1","fami_tiene_celular.1","fami_telefono.1",
    "fami_ingresofmiliarmensual","estu_trabajaactualmente","estu_antecedentes","estu_expectativas","cole_codigo_icfes",
    "cole_cod_dane_establecimiento","cole_nombre_establecimiento","cole_genero","cole_naturaleza","cole_calendario",
    "cole_bilingue","cole_caracter","cole_cod_dane_sede","cole_nombre_sede","cole_sede_principal","cole_area_ubicacion",
    "cole_jornada","cole_cod_mcpio_ubicacion","cole_mcpio_ubicacion","cole_cod_depto_ubicacion","cole_depto_ubicacion",
    "punt_lenguaje","punt_matematicas","punt_biologia","punt_quimica","punt_fisica","punt_ciencias_sociales","punt_filosofia",
    "punt_ingles","desemp_ingles","profundiza","puntaje_prof","desemp_prof","exito"
    };

	/**
	 * method to convert score variables into a range and the rest do nothing
	 * @param s - student answer
	 * @param row - row question
	 * @return answer converted into a range if is necessary
	 */
    public static String generateOption(String s,int row){
        if (data[row].startsWith("punt")){
            double punt = Double.parseDouble(s);
            if (punt >= 0 && punt < 10){
                return "0-10";
            }else if (punt >= 10 && punt < 20){
                return "10-20";
            }else if (punt >= 20 && punt < 30){
                return "20-30";
            }else if (punt >= 30 && punt < 40){
                return "30-40";
            }else if (punt >= 40 && punt < 50){
                return "40-50";
            }else if (punt >= 50 && punt < 60){
                return "50-60";
            }else if (punt >= 60 && punt < 70){
                return "60-70";
            }else if (punt >= 70 && punt < 80){
                return "70-80";
            }else if (punt >= 80 && punt < 90){
                return "80-90";
            }else {
                return "90-100";
            }
        }else{
            return s;
        }
    }
}

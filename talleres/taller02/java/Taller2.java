
/**
 * La clase taller dos tiene como objetivo dar solución
 * a 3 problemas recursivos
 *
 * @autor Kevin Sossa, Dixon Calderon
 * @version 1
 */

public class Taller2 {
	
	/**
	* @param p entrada 1 entero positivo, mayor que q
	* @param q entrada 2 entero positivo, menor que p
	*
	* El método gcd tiene como objetivo ecnontrar el
	* máximo común divisor de dos números, por medio del
	* algoritmo de euclides
	* @see <a href="https://www.youtube.com/watch?v=Q9HjeFD62Uk"> Explicación </a>
	* @see <a href="https://visualgo.net/en/recursion"> Funcionamiento </a>
	*
	* @return el máximo común divisor
	*/
	public static int gcd(final int p, final int q){
		if (q == 0){
			return p;
		}else {
			return gcd(q, p % q);
		}
	}

	/**
	* @param nums entrada 2 arreglo de enteros positivos, sobre el cual vamos a interar 
	* @param target entrada 3 entero positivo, determina el valor de referencia 
	* El método SumaGrupo tiene como objetivo darnos a conocer si hay 
	* algun subconjunto el cual su suma = target.
	* 
	*
	* @return verdadero si hay un subconjunto el cual su suma = target
	*/
	public static boolean SumaGrupo(final int[] nums, final int target) {
		return SumaGrupo(0, nums, target);
	}	
	
	/**
	* @param start entrada 1 entero positivo, determina un índice dentro del proceso
	* @param nums entrada 2 arreglo de enteros positivos, sobre el cual vamos a interar 
	* @param target entrada 3 entero positivo, determina el valor de referencia 
	* El método SumaGrupo tiene como objetivo darnos a conocer si hay 
	* algun subconjunto el cual su suma = target.
	* 
	* Este método SumaGrupo es "private" de modo que solo se puede llamar desde el interior de la clase pues
	* el método que lo representa es el SumaGrupo público.
	* Para más detalles sobre modificadores de acceso:
	* @see <a href="http://ayudasprogramacionweb.blogspot.com/2013/02/modificadores-acceso-public-protected-private-java.html"> modificadores </a>
	*
	*
	* @return verdadero si hay un subconjunto el cual su suma = target
	*/
	private static boolean SumaGrupo(final int start, final int[] nums, final int target) {
		if (target == 0){
			return true;
		} else if(start == nums.length){
			return false;
		} else {
			return SumaGrupo(start+1, nums, target-nums[start]) || SumaGrupo(start+1, nums, target);
		}
	}
	
	/**
	* @param s se trata de una cadena de caracteres sobre la cual hallaremos las posibles combinaciones.
	*
	* El método combinations se define para que solo se tenga que pasar el parametro s y no la cadena 
	* vacía necesaria para el metodo reursivo combinationsAux. Este metodo no se modifica.
	* 
	*/
	public static void combinations(final String s) { 
		combinationsAux("", s); 
		System.out.println();
	}
	
	/**
	* @param prefix, se utiliza como una variable auxiliar para guardar datos sobre el proceso.
	* @param s se trata de una cadena de caracteres sobre la cual hallaremos las posibles combinaciones.
	*
	*
	* El método combinationsAux se encarga de encontrar las posibles combinaciones en la cadena s
	* notese que el método es "private" de modo que solo se puede llamar desde el interior de la clase pues
	* el método que lo representa es combinations.
	* Para más detalles sobre modificadores de acceso:
	* @see <a href="http://ayudasprogramacionweb.blogspot.com/2013/02/modificadores-acceso-public-protected-private-java.html"> modificadores </a>
	*
	*/

	private static void combinationsAux(final String prefix, final String s) {
		if (s.isEmpty()){
			if (!prefix.isEmpty()){
				System.out.print(prefix+", ");
			}
		}else {
			combinationsAux(prefix+s.charAt(0), s.substring(1));
			combinationsAux(prefix, s.substring(1));
		}
	}
	public static void sub(String s1, String s2){
		int max_len=0;
		for (int i = 0; i < s1.length(); i++){
			int max = subSequence(i, 0, s1, s2);
			if (max > max_len){
				max_len = max;
			}
		}
		System.out.println("Mayor largo del subString: "+max_len);
	}

	public static int subSequence(int i,int len,String s1, String s2){
		if (i < s1.length()){
			int s = s2.indexOf(s1.charAt(i));
			if (s >= 0){
				return subSequence(i+1, len+1, s1, s2.substring(s));
			}
		}
		return len;
	}
}
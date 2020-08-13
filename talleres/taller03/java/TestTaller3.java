



public class TestTaller3 {
	
	public static void ejercicio1(){
		System.out.println("Para 2 discos la secuencia debe quedar as�");
		System.out.println("Disco 1 de 1 a 2   \nDisco 2 de 1 a 3  \nDisco 1 de 2 a 3");
		Taller3.torresDeHannoi(2);


		System.out.println("Para 3 discos la secuencia debe quedar as�");
		System.out.println("Disco 1 de 1 a 3  \nDisco 2 de 1 a 2  \nDisco 1 de 3 a 2  \nDisco 3 de 1 a 3  \nDisco 1 de 2 a 1  \nDisco 2 de 2 a 3  \nDisco 1 de 1 a 3  \n");
		Taller3.torresDeHannoi(3);


		System.out.println("Para 4 discos la secuencia debe quedar as�");
		System.out.println("Disco 1 de 1 a 2  \nDisco 2 de 1 a 3  \nDisco 1 de 2 a 3  \nDisco 3 de 1 a 2  \nDisco 1 de 3 a 1  \nDisco 2 de 3 a 2  \nDisco 1 de 1 a 2  \nDisco 4 de 1 a 3  \nDisco 1 de 2 a 3  \nDisco 2 de 2 a 1  \nDisco 1 de 3 a 1  \nDisco 3 de 2 a 3  \nDisco 1 de 1 a 2  \nDisco 2 de 1 a 3  \nDisco 1 de 2 a 3  \n");
		Taller3.torresDeHannoi(4);

	}
	
	
	public static void ejercicio2(){
		System.out.println("Las permutaciones de la cadena 'abc' son:");
		System.out.println("abc, acb, bac, bca, cab, cba");
		System.out.println("");
		Taller3.permutation("abc");

		System.out.println("Las permutaciones de la cadena 'Hola' son:");
		System.out.println("Hola, Hoal, Hloa, Hlao, Haol, Halo, oHla, oHal, olHa, olaH, oaHl, oalH, lHoa, lHao, loHa, loaH, laHo, laoH, aHol, aHlo, aoHl, aolH, alHo, aloH");
		System.out.println("");
		Taller3.permutation("Hola");

		System.out.println("Las permutaciones de la cadena 'Dato' son:");
		System.out.println("Dato, Daot, Dtao, Dtoa, Doat, Dota, aDto, aDot, atDo, atoD, aoDt, aotD, tDao, tDoa, taDo, taoD, toDa, toaD, oDat, oDta, oaDt, oatD, otDa, otaD");
		System.out.println("");
		Taller3.permutation("Dato");

		System.out.println("El archivo descifrado es:");
		Taller3.permutation2("","abcd");
		for (int i = 0; i < Taller3.permutations.size();i++){
			String s = AdvancedEncryptionStandard.desencriptarArchivo(Taller3.permutations.get(i));
			if (s != ""){
				System.out.println(s);
				break;
			}
		}
	}
	
	public static void main(String[] args){	
        //Ejercicio1
		System.out.println("");
        System.out.println("Ejercicio 1");
        ejercicio1();
        
        //Ejercicio2
        System.out.println("");
        System.out.println("Ejercicio 2");
		ejercicio2();
		
		System.out.println(AdvancedEncryptionStandard.desencriptarArchivo("abcd"));
    }
}
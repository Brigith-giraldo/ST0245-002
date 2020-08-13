import java.util.ArrayList;

public class Taller3 {
    public static void torresDeHannoi(int n){
        torresDeHannoi(n,"Torre1", "Torre2", "Torre3");
    }

    public static void torresDeHannoi(int n, String t1, String t2, String t3){
        if (n == 1){
            System.out.println("Disco "+n+" de "+t1+" -> "+t3);
        }else{
            torresDeHannoi(n-1, t1, t3, t2);
            System.out.println("Disco "+n+" de "+t1+" -> "+t3);
            torresDeHannoi(n-1, t2, t1, t3);
        }
    }

    public static void permutation(String s){
        permutation("", s);
    }

    public static void permutation(String prefix, String s){
        int len = s.length();
        if (len == 0){
            System.out.println(prefix);
        }else {
            for (int i = 0; i < len; i++){
                permutation(prefix+s.charAt(i), s.substring(0, i)+s.substring(i+1));
            }
        }
    }

    public static ArrayList<String> permutations = new ArrayList<>();

    public static void permutation2(String prefix, String s){
        int len = s.length();
        if (len == 0){
            permutations.add(prefix);
        }else {
            for (int i = 0; i < len; i++){
                permutation(prefix+s.charAt(i), s.substring(0, i)+s.substring(i+1));
            }
        }
    }
}
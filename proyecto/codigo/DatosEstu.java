import java.util.ArrayList;


import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class DatosEstu {
    private static List<String[]> data = new ArrayList<>();

    public static void leerArchivo(){
        File dataFile = new File("lite.csv");
        try {
            FileReader fr = new FileReader(dataFile);
            BufferedReader bf = new BufferedReader(fr);
            String line;
            while ((line = bf.readLine())!=null) {
                data.add(line.split(";"));
            } 
        } catch (IOException e) {
            System.out.println(e);
        }

    }

    public static void main(String[] args) {
        DatosEstu.leerArchivo();
        for (String[] s : data) {
            for (String s2 : s) {
                System.out.print(s2);
            }
            System.out.println();
        }
    }
}
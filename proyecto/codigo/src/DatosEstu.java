package src;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * class where the necessary for reading the data from a file will be
 * @author Kevin Sossa
 * @author Dixon Calderon
 * @version 1
 */
public class DatosEstu{

	/**
	 * method for reading data from a file
	 * @param s - location of the file to be read
	 * @return all data in a data structure
	 */
    public static List<String[]> leerArchivo(String s){
        List<String[]> data = new ArrayList<>();

        File dataFile = new File(s);
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
        return data;
    }

}

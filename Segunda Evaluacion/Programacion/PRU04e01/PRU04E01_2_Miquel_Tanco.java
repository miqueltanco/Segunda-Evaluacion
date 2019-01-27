package PRU04e01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class PRU04E01_2_Miquel_Tanco {

	public final static String SEPARATOR = System.getProperty("line.separator");

	public static void main (String[]args) {

		ArrayList<String> listaPalabras = new ArrayList<String>();	
		String linia = "";

		try {

			BufferedReader javaWcomments = new BufferedReader(new FileReader(args[0]));
			BufferedWriter javaNcomments = new BufferedWriter(new FileWriter(args[1]));

			do {
				linia = javaWcomments.readLine();
				if (linia !=null)
					linia = linia.replaceAll("(?:/\\*(?:[^*]|(?:\\*+[^*/]))*\\*+/)|(?://.*)","");
				listaPalabras.add(linia);

			} while (linia != null);

			for(String palabra: listaPalabras) {
				System.out.println(palabra);
				javaNcomments.write(palabra + SEPARATOR);
			}

			javaWcomments.close();
			javaNcomments.close();

		}
		catch(FileNotFoundException e) {
			System.out.println("El archivo no ha sido encontrado");
		}
		catch(IOException e) {
			System.out.println("El archivo no se puede abrir");
		}
	}
}

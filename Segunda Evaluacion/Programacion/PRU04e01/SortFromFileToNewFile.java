package PRU04e01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class SortFromFileToNewFile {

	public final static String SEPARATOR = System.getProperty("line.separator");
	public final static String FICHERO_WORDS = ("C:\\Temp\\words.dat");
	public final static String FICHERO_SORT = ("C:\\Temp\\words_sort.dat");

	public static void main (String[]args) {

		ArrayList<String> listaPalabras = new ArrayList<String>();	
		String linia = "";

		try {

			BufferedReader words = new BufferedReader(new FileReader(FICHERO_WORDS));
			BufferedWriter words_sort = new BufferedWriter(new FileWriter(FICHERO_SORT));

			do {
				linia = words.readLine();
				if (linia !=null)
					listaPalabras.add(linia);

			} while (linia != null);

			Collections.sort(listaPalabras);
			for(String palabra: listaPalabras) {
				System.out.println(palabra);
				words_sort.write(palabra + SEPARATOR);
			}


			words.close();
			words_sort.close();

		}
		catch(FileNotFoundException e) {
			System.out.println("El archivo no ha sido encontrado");
		}
		catch(IOException e) {
			System.out.println("El archivo no se puede abrir");
		}
	}
}
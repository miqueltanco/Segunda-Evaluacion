package PRU04e01;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class PRU04E01_3_Miquel_Tanco {

	public final static String SEPARATOR = System.getProperty("line.separator");

	public static void main (String[]args) {

		Scanner sc = new Scanner(System.in);
		ArrayList<String> listaPalabras = new ArrayList<String>();	
		String linia = "";
		int contador=0;
		String input=sc.nextLine();

		try {

			BufferedReader words = new BufferedReader(new FileReader(args[0]));

			do {
				linia = words.readLine();
				if (linia !=null)
					listaPalabras.add(linia);

			} while (linia != null);

			for(String palabra: listaPalabras) {
				if(palabra.equals(input))
					contador++;
			}

			words.close();
			sc.close();

			System.out.println("La palabra " + input + " aparece " + contador + " veces.");

		}
		catch(FileNotFoundException e) {
			System.out.println("El archivo no ha sido encontrado");
		}
		catch(IOException e) {
			System.out.println("El archivo no se puede abrir");
		}
	}
}
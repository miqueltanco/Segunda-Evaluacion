package PRU04E03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Pru04E03Investigation1_Miquel_Tanco {

	public final static String UBICACION_IMAGEN = "C:\\Temp\\Image.jpg";
	public final static String UBICACION_FINAL = "C:\\Temp\\ImagenPorBr.txt";

	public static void main (String[]args) {

		String linia = "";
		
		try {

			BufferedReader br = new BufferedReader(new FileReader(UBICACION_IMAGEN));
			BufferedWriter bw = new BufferedWriter(new FileWriter(UBICACION_FINAL));
			linia = br.readLine();
			
			do {
				bw.write(linia);
				System.out.println(linia);
				linia = br.readLine();
			} while (linia != null);

			br.close();
			bw.close();

		}
		catch(FileNotFoundException e) {
			System.out.println("El archivo no ha sido encontrado");
		}
		catch(IOException e) {
			System.out.println("El archivo no se puede abrir");
		}
	}
}
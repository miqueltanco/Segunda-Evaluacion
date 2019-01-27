package PRU04E03;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Pru04E03Investigation2_Miquel_Tanco {
	
	public final static String UBICACION_IMAGEN = "C:\\Temp\\Image.jpg";
	public final static String UBICACION_FINAL = "C:\\Temp\\ImagenPorDos.txt";

	public static void main (String[]args) {

		String linia = "";

		try {
			
			DataInputStream dis = new DataInputStream(new FileInputStream(UBICACION_IMAGEN));
			DataOutputStream dos = new DataOutputStream(new FileOutputStream(UBICACION_FINAL));
		
			linia = dis.readLine();
			
			do {
				System.out.println(linia);
				dos.writeUTF(linia);
				linia = dis.readLine();
			} while (linia != null);

			dis.close();
			dos.close();

		}
		catch(FileNotFoundException e) {
			System.out.println("El archivo no ha sido encontrado");
		}
		catch(IOException e) {
			System.out.println("El archivo no se puede abrir");
		}
	}
}

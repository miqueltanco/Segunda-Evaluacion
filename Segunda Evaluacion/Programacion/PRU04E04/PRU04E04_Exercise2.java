package PRU04E04;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class PRU04E04_Exercise2 {

	final static String RUTA_TEMP = "C:\\Temp\\";

	public static void main(String[] args) {

		try {

			/*		Utilizamos inputstream para interpretar con bytes
					Nombre del archivo, pero usando String[] args 			*/
			
			InputStream IS = new FileInputStream(RUTA_TEMP + args[0]);
			
			//Leemos una vez fuera del bucle para asi poder detectar si un archivo esta vacio
			
			int character = IS.read();
			
			//Creamos la array, yo he usado arraylist ya que no se que tamaño va a tener el archivo y asi no tengo que inicializarla con un tamaño excesivo o insuficiente
			
			ArrayList<Byte> arrayByte = new ArrayList<Byte>();

			do {
				arrayByte.add((byte) character);
				character = IS.read();				
			}while (character != -1);
			
			System.out.println(arrayByte);

			IS.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("El archivo no se encontro");
		}
		catch(IOException e) {
			System.out.println("El archivo no se puede abrir");
		}
	}
}

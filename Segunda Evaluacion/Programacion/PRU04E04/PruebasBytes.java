package PRU04E04;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class PruebasBytes {

	public static void main(String[] args) {

		try {

			InputStream IS = new FileInputStream(args[0]);
			int character = IS.read();
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


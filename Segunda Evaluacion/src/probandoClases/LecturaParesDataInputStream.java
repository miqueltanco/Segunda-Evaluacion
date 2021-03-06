package probandoClases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class LecturaParesDataInputStream {
	
	public static final String FICHERO_PARES="C:\\temp\\pares.dat";

	public static void main (String[]args) {
		
		try {
			InputStream is = new  FileInputStream(FICHERO_PARES);
			int linia = is.read();
			do {
				System.out.print((char)linia);
				linia = is.read();
			} while(linia != -1);
			
		}
		catch(FileNotFoundException e) {
			System.out.println("Archivo no encontrado");			
		}
		catch(IOException e) {
			System.out.println("Archivo no se puede abrir");
		}		
	}
}
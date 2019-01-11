package escripturaylectura;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

public class EscripturaPares {
	
public static final String FICHERO_PARES="C:\\temp\\pares.dat";
	
	public static void main (String[]args) {
		
		String linia;
		String sl = System.getProperty("line.separator");
		
		try {
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(FICHERO_PARES));
		
		for(int i=0; i<=500; i+=2) {
			linia=(Integer.toString(i) + sl);
			System.out.println(linia);
			bw.write(linia);
		}
		
		bw.close();
		}
		catch(FileAlreadyExistsException e) {
			System.out.println("ja existeix");
		}
		catch(IOException e) {
			System.out.println("ja existeix");
		}
	}
}
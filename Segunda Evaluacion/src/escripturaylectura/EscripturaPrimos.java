package escripturaylectura;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

public class EscripturaPrimos {
	
	public static void main (String[]args) {
		String n;
		try {
		
		BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\temp\\primos.dat"));
		
		for(int i=1; i<500; i+=2) {
			n=(Integer.toString(i) + "\n");
			bw.write(n);
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

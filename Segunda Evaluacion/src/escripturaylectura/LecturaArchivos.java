package escripturaylectura;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LecturaArchivos {

	public static final String FICHERO_PARES="C:\\temp\\pares.dat";
	public static final String FICHERO_IMPARES="C:\\temp\\impares.dat";
	public static final String FICHERO_JUNTOS="C:\\temp\\juntos.dat";

	public static void main(String[]args) {

		String linia1="";
		String linia2="";
		String sl = System.getProperty("line.separator");

		try {

			BufferedWriter bw = new BufferedWriter(new FileWriter(FICHERO_JUNTOS));
			BufferedReader brpares = new BufferedReader(new FileReader(FICHERO_PARES));
			BufferedReader brprimos = new BufferedReader(new FileReader(FICHERO_IMPARES));

			if(linia1!=null||linia2!=null) {
				for(int i=0;i<=500;i=i+2) {
					linia1=brpares.readLine();
					linia2=brprimos.readLine();
					System.out.println(linia1);
					if(i!=500) 
						System.out.println(linia2);
					bw.write(linia1+sl);
					if(i!=500) 
						bw.write(linia2+sl);
				}
			}

			bw.close();
			brpares.close();
			brprimos.close();

		}
		catch(FileNotFoundException e) {
			System.out.println("El archivo no ha sido encontrado");
		}
		catch(IOException e) {
			System.out.println("El archivo no se puede abrir");
		}

	}
}

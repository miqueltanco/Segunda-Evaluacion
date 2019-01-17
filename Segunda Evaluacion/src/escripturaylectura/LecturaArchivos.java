package escripturaylectura;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LecturaArchivos {

	public static final String FICHERO_PARES="C:\\Temp\\pares.dat";
	public static final String FICHERO_IMPARES="C:\\Temp\\impares.dat";
	public static final String FICHERO_JUNTOS="C:\\Temp\\juntos.dat";

	public static void main(String[]args) {

		String linia1;
		String linia2;
		String sl = System.getProperty("line.separator");

		try {

			BufferedWriter bw = new BufferedWriter(new FileWriter(FICHERO_JUNTOS));
			BufferedReader brpares = new BufferedReader(new FileReader(FICHERO_PARES));
			BufferedReader brprimos = new BufferedReader(new FileReader(FICHERO_IMPARES));

			linia1=brpares.readLine();
			linia2=brprimos.readLine();
			
			while(linia1!=null||linia2!=null) {
					bw.write(linia1+sl);
					System.out.println(linia1);
					linia1=brpares.readLine();
					if(linia2!=null){
					bw.write(linia2+sl);
					System.out.println(linia2);
					linia2=brprimos.readLine();
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

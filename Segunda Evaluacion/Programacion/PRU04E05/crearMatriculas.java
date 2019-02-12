package PRU04E05;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.util.Scanner;

public class crearMatriculas {

	final static String PATH_MATRICULAS = "C:\\Temp\\matriculas.txt";
	final static String SL = System.getProperty("line.separator");

	private	String crearMatricula() {

		char c = 0;
		String letras = "";
		String numeros="";
		String matricula;

		/* A = 65 , Z = 90 en ASCII */

		for(int i = 0; i < 3; i++) {
			int x = (int)(Math.random()*26)+65;
			do {
				x = (int)(Math.random()*26)+65;
			} while(x == 65 /* A */ || x == 69 /* E */ || x == 73 /* I */ || x == 79 /* O */ || x == 85 /* U */); 
			c = (char) x;
			letras = letras+c;
		}

		/* RANDOMS DEL 0 AL 9 */

		for(int i = 0; i < 4; i++) {
			int x = (int)(Math.random()*10);
			numeros = numeros+(Integer.toString(x));
		}

		matricula = numeros+letras;

		return matricula;
	}

	public void imprimirMatriculas(int cantidad) {
		

		try {

			BufferedWriter bw = new BufferedWriter(new FileWriter(PATH_MATRICULAS));

			for(int i = 0; i < cantidad; i++) {
				if(i != (cantidad-1))
					bw.write(crearMatricula()+SL);
				else bw.write(crearMatricula());
			}


			bw.close();

		}
		catch (FileAlreadyExistsException e) {
			System.out.println("El fichero ya existe");
		}
		catch (IOException e) {
			System.out.println("Fallo al escribir el fichero");
		}
	}
	
	public static void main(String[]args) {

		crearMatriculas cm = new crearMatriculas();
		
		Scanner sc = new Scanner(System.in);
		
		int cantidad = sc.nextInt();
		
		cm.imprimirMatriculas(cantidad);

		System.out.println("Se han creado " + cantidad + " matriculas." );
		
	}

}

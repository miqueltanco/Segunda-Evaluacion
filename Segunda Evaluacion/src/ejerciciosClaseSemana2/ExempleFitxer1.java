package ejerciciosClaseSemana2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ExempleFitxer1 {

	

	public static void main (String[]args) {

		Scanner sc = new Scanner(System.in);

		String ubicacion="C:\\temp\\";
		String archivo="";
		
		archivo = sc.nextLine();

		try {

			String linia="";
			BufferedReader bf = new BufferedReader(new FileReader(ubicacion+archivo));

			while(linia!=null) {
				linia = bf.readLine();
				if(linia!=null)
					System.out.println(linia);
			}

			bf.close();
			sc.close();

		}
		catch(FileNotFoundException e) {
			System.out.println("El archiu no trobat");
		}
		catch(IOException e) {
			System.out.println("No es pot obrir");
		}
	}
}

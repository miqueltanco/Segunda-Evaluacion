package PRU04e01;

import java.util.Scanner;

public class PRU04E01_Pruebas_Miquel_Tanco {
	
	public final static String SEPARATOR = System.getProperty("line.separator");

	public static void main (String[]args) {
			
		if(args[0].isEmpty()||args[1].isEmpty()) {
			System.out.println("Faltan parametros");
		}
		else {
			System.out.println("El primer parametro es: " + args[0]);
			System.out.println("El segundo parametro es: " + args[1]);
		}
		
	}
}

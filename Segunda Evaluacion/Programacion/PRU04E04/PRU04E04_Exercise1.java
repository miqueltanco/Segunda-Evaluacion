package PRU04E04;

import java.io.File;

public class PRU04E04_Exercise1 {

	final static String RUTA_TEMP = "C:\\Temp\\";
	
	public static void main (String[] args) {
		
		//Nombre del archivo, pero usando String[] args
		
		File archivo = new File(RUTA_TEMP + args[0]);
		
		//A la variable x le damos el valor del tamaño del archivo
		
		long x = archivo.length();
		
		//Hacemos conversiones
		
		long conversionKB = x/1024;
		long conversionMB = (x/1024)/1024;
		System.out.println(x + " B");
		System.out.println(conversionKB + " KB");
		System.out.println(conversionMB + " MB");
		
	}	
}

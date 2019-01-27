package PRU04e02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PRU04E02Position_Miquel_Tanco {

	public final static String SEPARATOR = System.getProperty("line.separator");

	//EN ESTE METODO COGEMOS UNA POSICION INICIAL Y UNA FINAL PARA IR SEPARANDO LAS DIFERENTES COLUMNAS DEL ARCHIVO

	public String trocejarCamp(String cadena, int posicio_inicial, int posicio_final) {

		String palabra="";
		for(int i = posicio_inicial; i<=posicio_final;i++) {
			palabra = (palabra+cadena.charAt(i));
		}
		return palabra;
	}

	//ESTE METODO UTILIZA EL METODO ANTERIOR Y VA JUNTANDO LA LINIA ENTERA ADEMÁS DE AÑADIR LAS COMAS Y EL PUNTO Y COMA FINAL, EL PROBLEMA ES QUE NO HE SABIDO
	//COMO GESTIONAR LAS POSICIONES Y ASI PODER HACER UN METODO REUTILIZABLE PARA EL FUTURO, TRISTEMENTE ME HA SALIDO UNO EXCLUSIVAMENTE PARA ESTE PROGRAMA, Y ESO NO ESTA BIEN

	public String completarLinia(String linia) {

		PRU04E02Position_Miquel_Tanco ClaseP = new PRU04E02Position_Miquel_Tanco();
		String liniacompleta;
		liniacompleta = (ClaseP.trocejarCamp(linia, 0,5) + "," + ClaseP.trocejarCamp(linia, 6,15)+ "," + ClaseP.trocejarCamp(linia, 16,26)+ "," + ClaseP.trocejarCamp(linia, 27,40)+ "," + ClaseP.trocejarCamp(linia, 41,47)+ "," + ClaseP.trocejarCamp(linia, 48,57) + ";");
		return liniacompleta;

	}

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		PRU04E02Position_Miquel_Tanco ClaseP = new PRU04E02Position_Miquel_Tanco();
		String linia = "";
		String FICHERO_TXT = sc.nextLine();
		String FICHERO_CSV = sc.nextLine();

		try {

			BufferedReader br = new BufferedReader(new FileReader(FICHERO_TXT));
			BufferedWriter bw = new BufferedWriter(new FileWriter(FICHERO_CSV));

			//SI AL LEER LA PRIMERA LINEA ESTUVIERA NULL SALTARIA EXCEPTION NULLPOINTER Y SE INDICARIA QUE EL ARCHIVO ESTA VACIO

			linia = br.readLine();

			//CON 1 LLAMADA AL METODO HACEMOS EL EJERCICIO

			do {
				bw.write(ClaseP.completarLinia(linia) + SEPARATOR);
				System.out.println(ClaseP.completarLinia(linia));
				linia = br.readLine();
			} while (linia != null);

			br.close();
			bw.close();
			sc.close();

		}
		catch(FileNotFoundException e) {
			System.out.println("El archivo no ha sido encontrado.");
		}
		catch(IOException e) {
			System.out.println("El archivo no se puede abrir.");
		}
		catch(NullPointerException e) {
			System.out.println("El archivo esta vacio.");
		}
	}
}
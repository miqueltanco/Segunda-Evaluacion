package pru03e07;

import java.util.ArrayList;
import java.util.Scanner;

public class pruebas1 {

	
	
public static void main (String[]args) {
	
	Scanner sc = new Scanner(System.in);	
	ArrayList<Article> listaArticulo = new ArrayList<Article>();

	
	boolean salir = false;
	int decision;

		System.out.println("	MENU ARTICULO");
		System.out.println("1. Lista de articulos");
		System.out.println("2. Alta");
		System.out.println("3. Baja");
		System.out.println("4. Modificacion");
		System.out.println("5. Entrada de mercancia");
		System.out.println("6. Salida de mercancia");
		System.out.println("7. Salir");

		decision = sc.nextInt();
		
		while (!salir) {
			
			System.out.println("	MENU ARTICULO");
			System.out.println("1. Lista de articulos");
			System.out.println("2. Alta");
			System.out.println("3. Baja");
			System.out.println("4. Modificacion");
			System.out.println("5. Entrada de mercancia");
			System.out.println("6. Salida de mercancia");
			System.out.println("7. Salir");
			
		switch (decision) {
		case 1:
			System.out.println(listaArticulo);
			break;
		case 2:

			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
			break;
		case 7:
			salir=true;
			break;
		default:
			System.out.println("Introduce un número correcto.");
			decision = sc.nextInt();
			}	
		}
	}
}

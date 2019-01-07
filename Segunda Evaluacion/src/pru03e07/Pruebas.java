package pru03e07;
import java.util.Scanner;
public class Pruebas {

public static void main (String[]args) {
	
	Scanner sc = new Scanner(System.in);
	
		Article Articulo1;
		Articulo1 = new Article();
		
		Articulo1.setCodi("1");
		Articulo1.setDescripcio("Cucharas de plastico");
		Articulo1.setPreuDeCompra(0.80);
		Articulo1.setPreuDeVenda(1.20);
		Articulo1.setStock(400);
		
		boolean salir = false;
		int decision;

while (!salir) {
			
			//**PRIMERA ENTRADA AL MENU, DESPUES LO HE PUESTO EN EL CASO 0, ASI SIEMPRE ESTA DENTRO DEL SWITCH**
			
			System.out.println("**********************************");
			System.out.println("	MENU ARTICULO");
			System.out.println("1. Lista de articulos");
			System.out.println("2. Alta");
			System.out.println("3. Baja");
			System.out.println("4. Modificacion");
			System.out.println("5. Entrada de mercancia");
			System.out.println("6. Salida de mercancia");
			System.out.println("7. Salir");
			System.out.println("**********************************");
			System.out.print("	Escoges: ");
			decision = sc.nextInt();
			
			switch (decision) {
				case 1:
					System.out.println(Articulo1.toString());
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
			}
		}
	}
}
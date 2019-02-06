package pru03e06;

import java.util.Scanner;

public class Pruebas {

	public static void main (String[]Args){
		
		Scanner sc = new Scanner(System.in);
		
		//**INSTANCIAS**
		
		Zona ZonaPlatea;
		ZonaPlatea = new Zona(1000);
		
		Zona ZonaAnfi;
		ZonaAnfi = new Zona(200);
		
		Zona ZonaVIP;
		ZonaVIP = new Zona(25);
		
		//**VARIABLES UTILIZADAS EN LA CLASE**
		
		boolean salir = false;
		int decision;
		int subDecision;
		int subDecisionCompra;
		int n;
		
		while (!salir) {
			System.out.println("**********************************");
			System.out.println("	MENU COMPRA TICKETS");
			System.out.println("1. Mostrar el número de entradas.");
			System.out.println("2. Comprar entradas.");
			System.out.println("3. Salir del menú");
			System.out.println("**********************************");
			System.out.print("	Escoges: ");
			decision = sc.nextInt();
			
			
			switch (decision) {
				case 0:
							System.out.println("**********************************");
							System.out.println("	MENU COMPRA TICKETS");
							System.out.println("1. Mostrar el número de entradas.");
							System.out.println("2. Comprar entradas.");
							System.out.println("3. Salir del menú");
							System.out.println("**********************************");
							System.out.print("	Escoges: ");
							decision = sc.nextInt();
							break;
				case 1:
							System.out.println("********************************************************************");
							System.out.println("		MENU MOSTRAR ENTRADAS");
							System.out.println("1. Mostrar el número de entradas libres de la zona Platea.");
							System.out.println("2. Mostrar el número de entradas libres de la zona Anfiteatro.");
							System.out.println("3. Mostrar el número de entradas libres de la zona VIP.");
							System.out.println("********************************************************************");
							System.out.print("	Escoges: ");
							subDecision = sc.nextInt();
							
						switch (subDecision) {
							case 1:
								System.out.println("De la zona Platea quedan " + ZonaPlatea.getEntradesPerVendre() + " entradas.");
								decision=0;
								break;
							case 2:
								System.out.println("De la zona Anfiteatro quedan " + ZonaAnfi.getEntradesPerVendre() + " entradas.");
								decision=0;
								break;
							case 3:
								System.out.println("De la zona VIP quedan " + ZonaVIP.getEntradesPerVendre() + " entradas.");
								decision=0;
								break;
							default:
								System.out.println( );
								System.out.println("Por favor introduce un numero correcto.");
								System.out.println( );
								break;
						}
							break;
				case 2:
							
							System.out.println("********************************************************************");
							System.out.println("		MENU COMPRAR ENTRADAS");
							System.out.println("1. Comprar entradas libres de la zona Platea.");
							System.out.println("2. Comprar entradas libres de la zona Anfiteatro.");
							System.out.println("3. Comprar entradas libres de la zona VIP.");
							System.out.println("********************************************************************");
							System.out.print("	Escoges: ");
							subDecisionCompra = sc.nextInt();
							
						switch (subDecisionCompra) {
								case 1:
									System.out.println("¿Cuantas entradas quiere?");
									n = sc.nextInt();
									ZonaPlatea.vendre(n);
									decision=0;
									break;
								case 2:
									System.out.println("¿Cuantas entradas quiere?");
									n = sc.nextInt();
									ZonaAnfi.vendre(n);
									decision=0;
									break;
								case 3:
									System.out.println("¿Cuantas entradas quiere?");
									n = sc.nextInt();
									ZonaVIP.vendre(n);
									decision=0;
									break;
								default:
								System.out.println( );
								System.out.println("Por favor introduce un numero correcto.");
								System.out.println( );
								break;
						}
								break;
				case 3: 
								System.out.println("¡Hasta luego!");
								salir = true;
								break;
				default:
								System.out.println( );
								System.out.println("Por favor introduce un numero correcto.");
								System.out.println( );
								break;
			}
		}
	}
}
     


		
		
		
		
		
		
		
		
		
		
		
		
	
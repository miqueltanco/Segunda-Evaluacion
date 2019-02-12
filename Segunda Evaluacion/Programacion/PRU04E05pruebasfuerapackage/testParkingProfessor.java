package PRU04E05pruebasfuerapackage;

import java.util.Scanner;

import pru04e05ParkingClasses.ParkingProfessor;
import pru04e05ParkingClasses.TipusPlacesParking;

public class testParkingProfessor {

	public static void main(String[]args) throws Exception{

		/* VARIABLES */

		Scanner sc = new Scanner(System.in);
		boolean salir = false;
		int decision;
		String path;
		String matricula;

		System.out.println("Introduce cantidad de plazas normales.");
		int plazasNormales = Integer.valueOf(sc.nextLine());

		System.out.println("Introduce cantidad de plazas de discapacitados.");
		int plazasMinus = Integer.valueOf(sc.nextLine());

		ParkingProfessor MT = new ParkingProfessor(plazasNormales, plazasMinus);

		while(!salir){
			System.out.println("==========================================================");
			System.out.println("1. Llenar parking a partir de un fichero de texto plano.");
			System.out.println("2. Entrar un coche.");
			System.out.println("3. Entrar un coche en plaza de discapacitados.");
			System.out.println("4. Sacar un coche");
			System.out.println("5. Sacar un coche en plaza de discapacitados.");
			System.out.println("6. Mostrar plazas ocupadas.");
			System.out.println("7. Mostrar plazas libres.");
			System.out.println("8. Guardar listado de matriculas en un fichero de texto plano.");
			System.out.println("9. Salir");
			System.out.println("==========================================================");

			System.out.println("Escribe una de las opciones:");
			decision = Integer.valueOf(sc.nextLine());

			switch(decision){
			case 1:
				System.out.println("Indica el path del fichero");
				path = sc.nextLine();
				try {
					MT.llegirMatricules(path);
				}
				catch(Exception e){
					System.out.println("El fallo es:" + e);
				}
				break;
			case 2:
				System.out.println("Indica la matricula");
				matricula = sc.nextLine();
				try {
					System.out.println("El coche ha aparcado en la plaza: " + MT.entraCotxe(matricula));
					System.out.println("Quedan "+ MT.getPlacesLliures(TipusPlacesParking.No_Discapacitat)  + " plazas libres.");
				}
				catch(Exception e){
					System.out.println("El fallo es: " + e);
				}
				break;
			case 3:
				System.out.println("Indica la matricula");
				matricula = sc.nextLine();
				try {
					System.out.println("El coche ha aparcado en la plaza: " + MT.entraCotxeDiscapacitat(matricula));
					System.out.println("Quedan "+ MT.getPlacesLliures(TipusPlacesParking.Discapacitat)  + " plazas libres.");
				}
				catch(Exception e){
					System.out.println("El fallo es: " + e);
				}
				break;
			case 4:
				System.out.println("Indica la matricula");
				matricula = sc.nextLine();
				try {
					MT.surtCotxe(matricula);
					System.out.println("El coche con matricula: " + matricula + " ha salido del parking.");
				}
				catch(Exception e){
					System.out.println("El fallo es:" + e);
				}
				break;
			case 5:
				System.out.println("Indica la matricula");
				matricula = sc.nextLine();
				try {
					MT.surtCotxeDiscapacitats(matricula);
				}
				catch(Exception e){
					System.out.println("El fallo es:" + e);
				}
				break;
			case 6:
				System.out.println("1. Plaza normal");
				System.out.println("2. Plaza discapacitados");
				System.out.println("Selecciona el tipo de parking:");
				decision = Integer.valueOf(sc.nextLine());

				switch (decision) {
				case 1:
					System.out.println("Hay "+ MT.getPlacesOcupades(TipusPlacesParking.No_Discapacitat) + " plazas ocupadas.");
					break;
				case 2:
					System.out.println("Hay "+ MT.getPlacesOcupades(TipusPlacesParking.Discapacitat) + " plazas ocupadas.");
					break;
				default:
					System.out.println("Solo números entre el 1 y 2");
					break;
				}

				break;
			case 7:
				System.out.println("1. Plaza normal");
				System.out.println("2. Plaza discapacitados");
				System.out.println("Selecciona el tipo de parking:");
				decision = Integer.valueOf(sc.nextLine());

				switch (decision) {
				case 1:
					System.out.println("Quedan "+ MT.getPlacesLliures(TipusPlacesParking.No_Discapacitat)  + " plazas libres.");
					break;
				case 2:
					System.out.println("Quedan "+ MT.getPlacesLliures(TipusPlacesParking.Discapacitat)  + " plazas libres.");
					break;
				default:
					System.out.println("Solo números entre el 1 y 2");
					break;
				}
				break;
			case 8:
				System.out.println("Indica el path del fichero");
				path = sc.nextLine();
				MT.guardarMatricules(path);
				System.out.println("El fichero se ha guardado en la ruta: " + path);
				break;
			case 9:
				salir=true;
				System.out.println("BEEP BEEP ");
				System.out.println(". . . .");
				System.out.println(". . .");
				System.out.println(". .");
				System.out.println("Saliendo del programa.");
				break;
			default:
				System.out.println("Solo números entre 1 y 9");
			}

		}			
	}
}

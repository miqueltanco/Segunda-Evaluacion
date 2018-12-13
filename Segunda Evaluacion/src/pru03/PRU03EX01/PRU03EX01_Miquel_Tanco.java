package pru03.PRU03EX01;

import java.util.Scanner;

public class PRU03EX01_Miquel_Tanco extends AlumneReal{

	public PRU03EX01_Miquel_Tanco(String nom) {
		super(nom);
	}
	
	public static void main (String[] Args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		//Intanciamos AlumneReal, dos veces para crear 2 alumnos
		
		AlumneReal Alumne1;
		Alumne1 = new AlumneReal("Jose"); // JOSE Y MARIA SON NOMBRES PREDETERMINADOS

		AlumneReal Alumne2;
		Alumne2 = new AlumneReal("Maria"); // JOSE Y MARIA SON NOMBRES PREDETERMINADOS
		
		//Introducimos los nombres de los alumnos
		
		System.out.print("Introduce el nombre del primer alumno: ");
		Alumne1.nom = sc.nextLine();
		
		System.out.print("Introduce el nombre del segundo alumno: ");
		Alumne2.nom = sc.nextLine();
				
		//La variable decision se utiliza para elegir en el menu
			
			int decision=0;
			
			//Menu en el cual el usuario selecciona lo que quiere hacer
		
		while (!(decision == 5)) {
			System.out.println("_______________________________________________");
			System.out.println("		MENU ALUMNOS");
			System.out.println("1. Matricular a " + Alumne1.nom + " a todas las asignaturas.");
			System.out.println("2. Matricular a " + Alumne2.nom + " a todas las asignaturas.");
			System.out.println("3. Las notas de " + Alumne1.nom + " en todas las asignaturas.");
			System.out.println("4. Las notas de " + Alumne2.nom + " en todas las asignaturas.");
			System.out.println("5. Cerrar el programa.");
			System.out.println("_______________________________________________");
			System.out.print("		Escoges: ");
			decision = sc.nextInt();
			
			switch (decision) {
				case 1:
					//MATRICULAMOS ALUMNE1 A TODAS LAS LAS ASIGNATURAS
					Alumne1.matricularModul("Programacio");
					Alumne1.matricularModul("Llenguatge de marques");
					Alumne1.matricularModul("FOL");
					Alumne1.matricularModul("Entorns de desenvolupament");
					Alumne1.matricularModul("Base de dades");
					Alumne1.matricularModul("Sistemes Informatics");
					System.out.println( );
					System.out.println("El alumno " + Alumne1.nom + " se ha matriculado en todas las asignaturas de 1DAM");
					System.out.println( );
					break;
				case 2:
					//MATRICULAMOS ALUMNE2 A TODAS LAS LAS ASIGNATURAS
					Alumne2.matricularModul("Programacio");
					Alumne2.matricularModul("Llenguatge de marques");
					Alumne2.matricularModul("FOL");
					Alumne2.matricularModul("Entorns de desenvolupament");
					Alumne2.matricularModul("Base de dades");
					Alumne2.matricularModul("Sistemes Informatics");
					System.out.println( );
					System.out.println("El alumno " + Alumne2.nom + " se ha matriculado en todas las asignaturas de 1DAM");
					System.out.println( );
					break;
				case 3:
					//ENSEÑAMOS LAS NOTAS DE ALUMNE1 DE TODOS LOS EXAMENES
					System.out.println( );
					System.out.println("La nota del examen Programacion de " +Alumne1.nom + " es un " + Alumne1.ferExamen("Programacio") + ".");
					System.out.println("La nota del examen Lenguaje de Marcas de " +Alumne1.nom + " es un " + Alumne1.ferExamen("Llenguatge de marques") + ".");
					System.out.println("La nota del examen FOL de " +Alumne1.nom + " es un " + Alumne1.ferExamen("FOL") + ".");
					System.out.println("La nota del examen EDD de " +Alumne1.nom + " es un " + Alumne1.ferExamen("Entorns de desenvolupament") + ".");
					System.out.println("La nota del examen Base de datos de " +Alumne1.nom + " es un " + Alumne1.ferExamen("Base de dades") + ".");
					System.out.println("La nota del examen Sistemas informáticos de " +Alumne1.nom + " es un " + Alumne1.ferExamen("Sistemes Informatics") + ".");
					System.out.println( );
					break;
				case 4:
					//ENSEÑAMOS LAS NOTAS DE ALUMNE1 DE TODOS LOS EXAMENES
					System.out.println( );
					System.out.println("La nota del examen Programacion de " +Alumne2.nom + " es un " + Alumne2.ferExamen("Programacio") + ".");
					System.out.println("La nota del examen Lenguaje de Marcas de " +Alumne2.nom + " es un " + Alumne2.ferExamen("Llenguatge de marques") + ".");
					System.out.println("La nota del examen FOL de " +Alumne2.nom + " es un " + Alumne2.ferExamen("FOL") + ".");
					System.out.println("La nota del examen EDD de " +Alumne2.nom + " es un " + Alumne2.ferExamen("Entorns de desenvolupament") + ".");
					System.out.println("La nota del examen Base de datos de " +Alumne2.nom + " es un " + Alumne2.ferExamen("Base de dades") + ".");
					System.out.println("La nota del examen Sistemas informáticos de " +Alumne2.nom + " es un " + Alumne2.ferExamen("Sistemes Informatics") + ".");
					System.out.println( );
					break;
				case 5:
					System.out.println("¡Hasta luego!");
					break;
				default:
					System.out.println( );
					System.out.println("Por favor introduce un numero correcto.");
					System.out.println( );
			}
		}
	}
}
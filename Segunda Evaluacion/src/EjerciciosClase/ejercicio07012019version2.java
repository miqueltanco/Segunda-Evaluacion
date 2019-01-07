package EjerciciosClase;

import java.util.Scanner;

public class ejercicio07012019version2 {
	
	public static void main (String[]args) {
		
		convertir Conver;
		Conver = new convertir();
			
		Scanner sc = new Scanner(System.in);
//		System.out.print("Introduce el numero deseado: ");
		String numero=sc.nextLine();
		int suma=0;
		
		String[] Texto;
		Texto = new String[100];
		
		int[] NumSeparado;
		NumSeparado = new int[numero.length()];
		
		for(int i=0; numero.length() > i; i++){
			//NumSeparado[i] = numero.charAt(i);
			NumSeparado[i]=Conver.conversion(numero.charAt(i));
				
			suma=suma+NumSeparado[i];
			
			System.out.print(numero.charAt(i));
			
			if(!(i==numero.length()-1)) {
				System.out.print(" + ");
			}
			
		}

/**		System.out.println("Tu numero es: " + numero);
		System.out.print("La suma de cada caracter es: ");
		for  (int i=0; i<NumSeparado.length; i++)
			  System.out.print(Texto[i]); **/
		System.out.print(" = " + suma);
		
		
	}
		
}

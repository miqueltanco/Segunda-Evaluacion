package EjerciciosClase;
import java.util.Scanner;

public class reto140version1 {

	public static void main(String[] args) {
		
		convertir Conver;
		Conver = new convertir();
		
		Scanner sc = new Scanner(System.in);
		String numero=sc.nextLine();
		int suma=0;
		
		
		
		for(int i=0; numero.length() > i; i++){
			
			Conver.conversion(numero.charAt(i));
			
			suma+=Conver.conversion(numero.charAt(i));
			
			if(i<(numero.length()-1)) {
			System.out.print(numero.charAt(i) + " + ");
			}
			else {
				System.out.print(numero.charAt(i));
			}
		}
		System.out.println(" = " + suma);
				
	}	
}


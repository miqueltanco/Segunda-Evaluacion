package EjerciciosClase;
import java.util.Scanner;

public class ejercicio07012019 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduce el numero deseado: ");
		String numero=sc.nextLine();
		int suma=0;
		
		String[] Texto;
		Texto = new String[100];
		
		int[] NumSeparado;
		NumSeparado = new int[numero.length()];
		
		for(int i=0; numero.length() > i; i++){
			NumSeparado[i] = numero.charAt(i);			
			switch (NumSeparado[i]) {
				case 48:
					NumSeparado[i]=0;
					break;
				case 49:
					NumSeparado[i]=1;
					break;
				case 50:
					NumSeparado[i]=2;
					break;
				case 51:
					NumSeparado[i]=3;
					break;
				case 52:
					NumSeparado[i]=4;
					break;
				case 53:
					NumSeparado[i]=5;
					break;
				case 54:
					NumSeparado[i]=6;
					break;
				case 55:
					NumSeparado[i]=7;
					break;
				case 56:
					NumSeparado[i]=8;
					break;
				case 57:
					NumSeparado[i]=9;
					break;
			}		
			suma=suma+NumSeparado[i];
		}
		
		for(int i=0; numero.length() > i; i++){
			if(i>0) {
			Texto[i]=("+" + NumSeparado[i]);
			}
			else {
			Texto[i]=(NumSeparado[i] + "");
			}
		}
		System.out.println("Tu numero es: " + numero);
		System.out.print("La suma de cada caracter es: ");
		for  (int i=0; i<NumSeparado.length; i++)
			  System.out.print(Texto[i]);
		System.out.print(" = " + suma);
	}	
}


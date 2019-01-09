package EjerciciosClase;

import java.util.Scanner;

public class reto140version2 {
	
	public static void main (String[]args) {
		
			Scanner sc = new Scanner(System.in);
			 int n = sc.nextInt(); //NUMERO QUE INTRODUCES
			 int l = Integer.toString(n).length(); //PARA SABER LA LONGITUD DE TU NUMERO
			 int s = 0; //VARIABLE DONDE SE ALMACENA LA SUMA DE LOS DIGITOS
			 
			 while(n>=0) { //SI n ES MENOR QUE 0 EL PROGRAMA SE PARA
			 
			 for (int i = 0; i < l; i++) {
				 String num = String.valueOf(Integer.toString(n).charAt(i));
				 s+=Integer.parseInt(num);
				 
				 System.out.print(num);
							 
				 if(!(i==l-1)) {
						System.out.print(" + ");
					}
				 
			 }
			 System.out.println(" = " + s); 
			 
			 //SE TIENE QUE REINICIAR LA LONGITUD Y LA SUMA
			 
			 n = sc.nextInt();
			 l = Integer.toString(n).length();
			 s = 0;
			 }
		}
	}
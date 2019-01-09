package EjerciciosClase;

import java.util.Scanner;

public class ejercicio07012019version3dia08 {

	public static void main (String[]args) {
	
		Scanner sc = new Scanner(System.in);
		 int n = sc.nextInt();
		 int l = Integer.toString(n).length();
		 int s = 0;
		 
		 while(n>=0) {
		 
		 for (int i = 0; i < l; i++) {
			 String num = String.valueOf(Integer.toString(n).charAt(i));
			 s+=Integer.parseInt(num);
			 
			 System.out.print(num);
						 
			 if(!(i==l-1)) {
					System.out.print(" + ");
				}
			 
		 }
		 System.out.println(" = " + s); 
		 
		 n = sc.nextInt();
		 l = Integer.toString(n).length();
		 s = 0;
		 }
	}
}

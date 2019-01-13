package ejerciciosClaseSemana1;

public class Conversion {
	
	//METODO QUE CONVIERTE LOS NUMEROS(String) A NUMEROS(int)   ******** (LAS POSICIONES EN ASCII SON DEL 48 AL 57) 
	
	public int convertir(char numero) {
		
			switch (numero) {
				case 48:
					numero=0;
					break;
				case 49:
					numero=1;
					break;
				case 50:
					numero=2;
					break;
				case 51:
					numero=3;
					break;
				case 52:
					numero=4;
					break;
				case 53:
					numero=5;
					break;
				case 54:
					numero=6;
					break;
				case 55:
					numero=7;
					break;
				case 56:
					numero=8;
					break;
				case 57:
					numero=9;
					break;
			}			
		return numero;
	}
}


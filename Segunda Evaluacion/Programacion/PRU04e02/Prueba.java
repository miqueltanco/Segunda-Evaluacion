package PRU04e02;

public class Prueba {


	public String trocejarCamp(String cadena, int posicio_inicial, int posicio_final) {

		String palabra="";
		for(int i = posicio_inicial; i<=posicio_final;i++) {
			palabra = (palabra+cadena.charAt(i));
		}
		return palabra;
	}

	public String completarLinia(String linia) {

		Prueba ClaseP = new Prueba();
		String liniacompleta;
		liniacompleta = (ClaseP.trocejarCamp(linia, 0,5) + ";" + ClaseP.trocejarCamp(linia, 6,15)+ ";" + ClaseP.trocejarCamp(linia, 16,26)+ ";" + ClaseP.trocejarCamp(linia, 27,40)+ ";" + ClaseP.trocejarCamp(linia, 41,47)+ ";" + ClaseP.trocejarCamp(linia, 48,57));
		return liniacompleta;
		
	}

	public static void main(String args[]) {

		Prueba ClaseP = new Prueba();
		String linia = "emp_nobirth_datefirst_name last_name     gender hire_date ";
		System.out.println(ClaseP.completarLinia(linia));

	}	
}
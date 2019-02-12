package PRU04E05;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Clase Parking con los metodos correspondientes
 * @author Yugen
 *
 */

public class PRU04E05Parking_Miquel_Tanco {

	/* VARIABLES */

	private int places_no_discapacitats;
	private int places_discapacitats;
	private int plazaslibresNormales = 0;
	private int plazaslibresDisc = 0;
	private int contadorPlazasNormales;
	private int contadorPlazasDisc;
	private HashMap<String, Integer> plazasNormales = new HashMap<String, Integer>();
	private HashMap<String, Integer> plazasDisc = new HashMap<String, Integer>();
	private ArrayList<String> matriculasParking = new ArrayList<String>();
	private boolean[] booleanPlazasNormales;
	private boolean[] booleanPlazasDisc;

	/*    ENUM     */

	public enum TipusPlacesParking {
		Discapacitat,
		No_Discapacitat;
	}

	/* CONSTRUCTOR */

	public PRU04E05Parking_Miquel_Tanco (int places_no_discapacitats, int places_discapacitats) {
		this.places_no_discapacitats=places_no_discapacitats;
		this.places_discapacitats=places_discapacitats;
		booleanPlazasNormales = new boolean[places_no_discapacitats];
		booleanPlazasDisc = new boolean[places_discapacitats];
		contadorPlazasDisc = places_discapacitats;
		contadorPlazasNormales = places_no_discapacitats;
	}

	/* METODOS PUBLICOS */

	/**
	 * Metodo para leer matriculas de un archivo de texto plano y meter dichas matriculas en el parking
	 * @param path
	 * @throws Exception
	 */
	public void llegirMatricules(String path) throws Exception{

		String matricula;
		
		try {
			
			BufferedReader br = new BufferedReader(new FileReader(path));

			matricula=br.readLine();
			
				do {
					
					/* ALEATORIO ENTRA EN DISCAPACITADO CON UN 2% */
					
					if(((int)Math.random()*100) > 2) {
					entrarCocheFichero(matricula);
					}
					else entraCotxeDiscapacitat(matricula);
					
					matricula = br.readLine();
					
				}while(matricula != null);
			
				br.close();
		}
		catch(IOException e) {
			System.out.println("ALERTA =====> Fitxer incorrecte o inexistent.");
		}
	}

	/**
	 * Metodo para meter un coche en una plaza normal
	 * @param matricula
	 * @return
	 * @throws Exception
	 */
	public int entraCotxe(String matricula) throws Exception {

		int plazaParking = 0;

		/* COMPRUEBA MATRICULA */

		if(matricula.matches("[0-9]{4}[A-Z]{3}")) {

			/* COMPROBAR SI LA MATRICULA YA ESTA EN EL PARKING */

			if( !(plazasNormales.containsKey(matricula)) && !(plazasDisc.containsKey(matricula)) ) {

				/* GARRULO Y ENTRADA AL PARKING */

				if(contadorPlazasDisc >= 1 && (int)(Math.random()*10) == 8) {

					plazaParking = entradaParkingDisc(matricula, plazaParking);

					/* COMPROBAMOS SI ESTA OCUPADO UN 85% DE SU CAPACIDAD */

					if(avisoOcupacionDisc() == true) {
						throw new Exception("ALERTA =====> Ocupació de places per discapacitats supera el 85%.");
					}

					throw new Exception("ALERTA =====> Garrulo detected!!! Ha aparcat a la plaça: " + plazaParking);

				}
				else if(contadorPlazasNormales >= 1){

					plazaParking = entradaParkingNormal(matricula, plazaParking);

					/* COMPROBAMOS SI ESTA OCUPADO UN 85% DE SU CAPACIDAD */

					if(avisoOcupacionNormal() == true) {
						throw new Exception("ALERTA =====> Ocupació de places per no discapacitats supera el 85%.");
					}

				}
				else throw new Exception("ALERTA =====> Parking per no discapacitats ple.");

			} else throw new Exception("El cotxe ja està al parking. No pot entrar.");

		} else throw new Exception ("ALERTA =====> Matrícula incorrecte.");

		return plazaParking;				
	}

	/**
	 * Metodo para meter un coche en una plaza de discapacitados
	 * @param matricula
	 * @return
	 * @throws Exception
	 */
	public int entraCotxeDiscapacitat(String matricula) throws Exception {

		int plazaParking = 0;

		/* COMPRUEBA MATRICULA */

		if(matricula.matches("[0-9]{4}[A-Z]{3}")) {

			/* COMPROBAR SI LA MATRICULA YA ESTA EN EL PARKING */

			if( !(plazasDisc.containsKey(matricula)) ) {

				/* ENTRADA AL PARKING */

				if(contadorPlazasDisc >= 1) {

					plazaParking = entradaParkingDisc(matricula, plazaParking);

					/* COMPROBAMOS SI ESTA OCUPADO UN 85% DE SU CAPACIDAD */

					if(avisoOcupacionDisc() == true) {
						throw new Exception("ALERTA =====> Ocupació de places per discapacitats supera el 85%.");
					}

				}
				else if(contadorPlazasDisc == 0) {

					plazaParking = entradaParkingNormal(matricula, plazaParking);

					throw new Exception("ALERTA =====> Parking per discapacitats ple. Ha ocupat plaça normal num: " + plazaParking);

				}
				else throw new Exception("ALERTA =====> Parking per discapacitats ple.");

			} else throw new Exception ("El cotxe ja està al parking. No pot entrar.");

		} else throw new Exception ("ALERTA =====> Matrícula incorrecte.");

		return plazaParking;		
	}

	/**
	 * Metodo para sacar un coche de una plaza normal
	 * @param matricula
	 * @throws Exception
	 */
	public void surtCotxe(String matricula) throws Exception {

		/* COMPRUEBA MATRICULA */

		if(matricula.matches("[0-9]{4}[A-Z]{3}")) {

			/* COMPRUEBA MATRICULA ESTA EN EL PARKING */

			if(plazasNormales.containsKey(matricula)) {

				booleanPlazasNormales[plazasNormales.get(matricula)] = false;

				plazasNormales.remove(matricula);

				contadorPlazasNormales++;

				matriculasParking.remove(matricula);

			}
			else throw new Exception("El cotxe no és al parking.");

		} else throw new Exception ("ALERTA =====> Matrícula incorrecte.");
	}

	/**
	 * Metodo para sacar un coche de una plaza de discapacitados
	 * @param matricula
	 * @throws Exception
	 */
	public void surtCotxeDiscapacitats(String matricula) throws Exception {

		/* COMPRUEBA MATRICULA */

		if(matricula.matches("[0-9]{4}[A-Z]{3}")) {

			/* COMPRUEBA MATRICULA ESTA EN EL PARKING */

			if(plazasDisc.containsKey(matricula)) {

				booleanPlazasDisc[plazasDisc.get(matricula)] = false;

				plazasDisc.remove(matricula);

				contadorPlazasDisc++;

				matriculasParking.remove(matricula);

			}
			else throw new Exception("El cotxe no és al parking.");

		} else throw new Exception ("ALERTA =====> Matrícula incorrecte.");
	}

	/**
	 * Metodo para conseguir el numero de plazas ocupadas
	 * @param tipus
	 * @return
	 */
	public int getPlacesOcupades(TipusPlacesParking tipus) {
		if(tipus.equals(tipus.No_Discapacitat)) {

			/* CANTIDAD MAXIMA - CANTIDAD LIBRE = CANTIDAD OCUPADA */

			int x = places_no_discapacitats;
			int i = x - contadorPlazasNormales;
			return i;

		} else {

			/* CANTIDAD MAXIMA - CANTIDAD LIBRE = CANTIDAD OCUPADA */

			int x = places_discapacitats;
			int i = x - contadorPlazasDisc;
			return i;

		}	
	}

	/**
	 * Metodo para conseguir el numero de plazas libres
	 * @param tipus
	 * @return
	 */
	public int getPlacesLliures(TipusPlacesParking tipus) {

		/* EL CONTADOR EMPIEZA CON LA CANTIDAD MAXIMA Y SE VA RESTANDO LA PLAZA OCUPADA ENTONCES QUEDA LA CANTIDAD LIBRE */

		if(tipus.equals(tipus.No_Discapacitat)) {
			return contadorPlazasNormales;
		} else {
			return contadorPlazasDisc;
		}	
	}

	/**
	 * Metodo para guardar las matriculas en un archivo de texto plano (.txt)
	 * @param path
	 * @throws Exception
	 */
	public void guardarMatricules(String path) throws Exception {

		/* SALTO DE LINEA */

		String sl = System.getProperty("line.separator");

		try {

			BufferedWriter bw = new BufferedWriter(new FileWriter(path));

			for(int i = 0; i < matriculasParking.size(); i++) {
				bw.write(matriculasParking.get(i)+sl);
			}

			bw.close();
		}
		catch(IOException e) {
			System.out.println("ALERTA =====> Fitxer incorrecte o inexistent.");
		}
	}

	/* METODOS PRIVADOS */

	/**
	 * Metodo para encontrar la plaza del parking mas cercana a la "entrada" suponemos que es donde va a aparcar el coche
	 * @param tipus
	 * @return
	 * @throws Exception
	 */
	private int encontrarPlaza(TipusPlacesParking tipus) throws Exception {

		/* CON ESTE IF DETERMINAMOS QUE TIPO DE PLAZA ES */

		/* CON EL FOR PODEMOS SABER QUE POSICION MAS CERCANA AL 0 ESTA LIBRE */

		if(tipus.equals(tipus.No_Discapacitat)) {

			for(int i = 0; i < booleanPlazasNormales.length; i++) {
				if(booleanPlazasNormales[i] == false)
					return i;
			}

		} else {

			for(int i = 0; i < booleanPlazasDisc.length; i++) {

				if(booleanPlazasDisc[i] == false)
					return i;
			}
		}

		/* SI EL ENUM PETA (ESTAMOS JODIDOS) */

		return -1;
	}

	/**
	 * Metodo para entrar coches en una plaza normal
	 * @param matricula
	 * @param plazaParking
	 * @throws Exception
	 */
	private int entradaParkingNormal(String matricula, int plazaParking) throws Exception {

		/* LE BUSCAMOS UN HUECO EN EL PARKING, SIEMPRE EL HUECO LIBRE MAS CERCANO A 0*/

		plazaParking = encontrarPlaza(TipusPlacesParking.No_Discapacitat);

		/* METEMOS EL COCHE EN UNA PLAZA DE PARKING */

		plazasNormales.put(matricula, plazaParking);

		/* EN LA ARRAY BOOLEAN PONEMOS TRUE EN LOS PUESTOS OCUPADOS */

		booleanPlazasNormales[plazaParking] = true;

		plazaslibresNormales++;

		contadorPlazasNormales--;

		/* METEMOS LA MATRICULA EN LA ARRAYLIST DE MATRICULAS POR SI QUEREMOS IMPRIMIR LAS MATRICULAS DENTRO DEL PARKING */

		matriculasParking.add(matricula);

		return plazaParking;
	}

	/**
	 * Metodo para entrar coches en una plaza de discapacitados
	 * @param matricula
	 * @param plazaParking
	 * @throws Exception
	 */
	private int entradaParkingDisc(String matricula, int plazaParking) throws Exception {

		/* LE BUSCAMOS UN HUECO EN EL PARKING, SIEMPRE EL HUECO LIBRE MAS CERCANO A 0*/

		plazaParking = encontrarPlaza(TipusPlacesParking.Discapacitat);

		/* METEMOS EL COCHE EN UNA PLAZA DE PARKING */

		plazasDisc.put(matricula, plazaParking);

		/* EN LA ARRAY BOOLEAN PONEMOS TRUE EN LOS PUESTOS OCUPADOS */

		booleanPlazasDisc[plazaParking] = true;

		plazaslibresDisc++;

		contadorPlazasDisc--;

		/* METEMOS LA MATRICULA EN LA ARRAYLIST DE MATRICULAS POR SI QUEREMOS IMPRIMIR LAS MATRICULAS DENTRO DEL PARKING */

		matriculasParking.add(matricula);

		return plazaParking;

	}	

	/**
	 * Metodo para calcular %85
	 * @return
	 */
	private boolean avisoOcupacionNormal() {

		/* (PLAZAS LIBRES*100)/PLAZAS TOTALES MAYOR O IGUAL QUE 85   */

		if(((plazaslibresNormales*100)/places_no_discapacitats)>85){
			return true;
		}
		else return false;
	}

	/**
	 * Metodo para calcular %85
	 * @return
	 */
	private boolean avisoOcupacionDisc() {

		/* (PLAZAS LIBRES*100)/PLAZAS TOTALES MAYOR O IGUAL QUE 85   */

		if(((plazaslibresDisc*100)/places_discapacitats)>85){
			return true;
		}
		else return false;
	}

	/**
	 * Metodo para que no salgan garrulos al meter por fichero
	 * @param matricula
	 * @throws Exception
	 */
	private void entrarCocheFichero(String matricula) throws Exception {
		int plazaParking = 0;

		/* COMPRUEBA MATRICULA */

		if(matricula.matches("[0-9]{4}[A-Z]{3}")) {

			/* COMPROBAR SI LA MATRICULA YA ESTA EN EL PARKING */

			if( !(plazasNormales.containsKey(matricula)) && !(plazasDisc.containsKey(matricula)) ) {

				/* GARRULO Y ENTRADA AL PARKING */

				if(contadorPlazasNormales >= 1){

					plazaParking = entradaParkingNormal(matricula, plazaParking);

				}
				else throw new Exception("ALERTA =====> Parking per no discapacitats ple.");

			} else throw new Exception("El cotxe ja està al parking. No pot entrar.");

		} else throw new Exception ("ALERTA =====> Matrícula incorrecte.");

	}

	private int plazaAleatoria(TipusPlacesParking tipus) {

		boolean contadorPosicion = false;
		int plaza = 0;
		
		switch (tipus) {
		case No_Discapacitat:
	        
	        do {
	            plaza = (int)(Math.random()*places_no_discapacitats+1);
	            if (!plazasNormales.containsValue(plaza)) {
	                contadorPosicion = true;
	            }
	        } while (contadorPosicion = false);
			
			break;
		case Discapacitat:
				        
	        do {
	            plaza = (int)(Math.random()*places_no_discapacitats+1);
	            if (!plazasDisc.containsValue(plaza)) {
	            	 contadorPosicion = true;
	            }
	        } while (contadorPosicion = false);
			
			break;
		
		}
        
        return plaza;
          
	}
}


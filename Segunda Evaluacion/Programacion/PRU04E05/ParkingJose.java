package PRU04E05;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Clase Parking con métodos públicos estándar para que puedan ser llamados desde cualquier clase Test
 * @author kryon
 *
 */
public class ParkingJose {
	
	private int places_no_discapacitats, places_discapacitats;
	BufferedReader br;
	BufferedWriter bw;
	HashMap<String, Integer> parkingSlots= new HashMap<String, Integer>();
	HashMap<String, Integer> parkingSlotsDisc= new HashMap<String, Integer>();
	ArrayList<String> plateList=new ArrayList<String>();
	boolean[] huecosNorm,huecosDisc;
	int discCounter=0,normCounter=0;
	
	/**
	 * Como no sabemos si el enum lo pasa Xavi o no, la clase lleva uno dentro.
	 * 
	 * @param DISCAPACITAT
	 * @param NO_DISCAPACITAT
	 * 
	 * @author kryon
	 *
	 */
	public enum TipusPlacesParking{
		
		DISCAPACITAT, NO_DISCAPACITAT
		
	}
	
	
	
	
	
	//MÉTODOS PROPIOS DE GESTIÓN INTERNA********************************
	
	
	
	
	/**
	 * Método para cargar el búfer de lectura.
	 * @param path Dirección del archivo .TXT a leer
	 * @throws Exception Error de dirección no encontrada
	 */
	private void loadBufferedReader(String path) throws Exception {
				
		br=new BufferedReader(new FileReader(path));
			
	}
	
	/**
	 * Método para cargar el búfer de escritura.
	 * @param path Dirección donde crear el .TXT
	 * @throws IOException 
	 */
	private void loadBufferedWriter(String path) throws IOException {
		
		bw=new BufferedWriter(new FileWriter(path));
			
	}
		
	/**
	 * Cierra los búfer.
	 * @throws IOException 
	 */
	private void closeBuffers() throws IOException {
			
		br.close();
		bw.close();
			
	}
	
	/**
	 * Método para ingresar un coche cogiendo su matrícula desde un .TXT
	 * @param matricula
	 * @throws Exception Error de lectura
	 */
	private void ingresarCocheTXT(String matricula) throws Exception {
		
		//Si el coche no está ya metido:
		if(parkingSlots.containsKey(matricula)==false && parkingSlotsDisc.containsKey(matricula)==false) {
			
			//Si el párking no está ya lleno:
			if((discCounter+normCounter)<places_no_discapacitats+places_discapacitats) {
				
				//Rellena el párking aleatoriamente
				if((((int)Math.random() * (places_no_discapacitats + places_discapacitats)<places_discapacitats) && discCounter<places_discapacitats) || normCounter==places_no_discapacitats) {
					
					int temp=encontrarHuecos(TipusPlacesParking.DISCAPACITAT);
					
					parkingSlotsDisc.put(matricula, temp);
					
					huecosDisc[temp]=true;
					
					discCounter++;
					
				}
				
				else {
					
					int temp=encontrarHuecos(TipusPlacesParking.NO_DISCAPACITAT);
					
					parkingSlots.put(matricula, temp);
					
					huecosNorm[temp]=true;
					
					normCounter++;
					
				}
				
			}
			
			else {
				
				//Sacamos esto si el que prueba la clase ha puesto un txt con más coches que lo puesto en el constructor
				throw new Exception("ALERTA =====> Parking per no discapacitats ple.");
				
			}
			
		}
		
		else {
			
			throw new Exception("El cotxe ja està al parking. No pot entrar.");
			
		}
		
	}	
	
	/**
	 * Método para inicializar las arrays de booleans que especifican si hay o no hay un coche en esa plaza
	 */
	private void inicializarHuecos() {
		
		for(int x=0;x<huecosNorm.length;x++) {
		
			huecosNorm[x]=false;
			
		}
		
		for(int x=0;x<huecosDisc.length;x++) {
			
			huecosDisc[x]=false;
			
		}
		
	}
	
	/**
	 * Método que busca la plaza libre más cercana
	 * @param tipo Tipo de plaza que se busca
	 * @return Número de la plaza encontrada
	 * @throws Exception Error causado por la mala gestión de los enum. No debería saltar
	 */
	private int encontrarHuecos(TipusPlacesParking tipo) throws Exception{
		
		switch(tipo) {
		
		case DISCAPACITAT:
			
			for(int x=0;x<huecosDisc.length;x++) {
			
				if(huecosDisc[x]==false) {
					
					//Nos devolverá la posición más próxima a 0 donde no haya nadie. Es así para volver a colocar a alguien en una plaza de donde se acaben de marchar
					return x;
					
				}
				
			}
			
			break;
			
		case NO_DISCAPACITAT:
			
			for(int x=0;x<huecosNorm.length;x++) {
				
				if(huecosNorm[x]==false) {
					
					return x;
					
				}
				
			}
			
			break;
		
			
		default:
			
			//No prestar atención. Cambiar cuando Xavi conteste a lo de los enum
			throw new Exception("HA PETAO PORQUE EL ENUM ES UNA MIERDA");
			
		}
		//No prestar atención. Cambiar cuando Xavi conteste a lo de los enum
		throw new Exception("HA PETAO PORQUE EL NINGÚN BUCLE HA ENCONTRADO EL HUECO QUE TOCA");
		
	}
	
	/**
	 * Método para calcular el porcentaje de ocupación de cada tipo de plaza
	 * @param tipo Tipo de plaza
	 * @throws Exception Aviso si hay ocupado más de un 85%
	 */
	private void percOcup(TipusPlacesParking tipo) throws Exception {
		
		/*
		 * El método no hará nada hasta que se tope con que hay un porcentaje de ocupación
		 * de ese tipo de plaza de aparcamiento superior al 85%. Entonces soltará un error
		 * que debería detener la ejecución del método superior que lo esté llamando
		 */
		
		switch(tipo) {
		
		case DISCAPACITAT:
			
			if(((discCounter*100)/places_discapacitats)>85) {
				
				throw new Exception("ALERTA =====> Ocupació de places per discapacitats supera el 85%.");
				
			}
			
			break;
			
		case NO_DISCAPACITAT:
			
			if(((normCounter*100)/places_no_discapacitats)>85) {
				
				throw new Exception("ALERTA =====> Ocupació de places per no discapacitats supera el 85%.");
				
			}
			
			break;
			
		default:
			
			//Cambiar cuando Xavi conteste
			throw new Exception("EL ENUM HA PETAO PORQUE ES UNA MIERDA");
		
		}
		
	}
	
	
	//MÉTODOS GENERALES ESPECIFICADOS EN EL ENUNCIADO***************************

	
	
	
	/**
	 * Constructor estándar de las clases Parking
	 * @param places_no_discapacitats
	 * @param places_discapacitats
	 */
	public ParkingJose (int places_no_discapacitats, int places_discapacitats) {
		
		this.places_no_discapacitats=places_no_discapacitats;
		this.places_discapacitats=places_discapacitats;
		huecosNorm=new boolean[places_no_discapacitats];
		huecosDisc=new boolean[places_discapacitats];
		inicializarHuecos();
		
	}
	
	/**
	 * Método para meter en el párking automáticamente todas las matrículas que nos pasan
	 * @param path
	 * @throws Exception MÚLTIPLES: ficheros incorrectos || párking lleno (más coches en el txt de lo especificado en el constructor
	 */
	public void llegirMatricules(String path) throws Exception{
		
		String matricula;
		boolean ok=false;
		
		try {
		
		loadBufferedReader(path);
		
		while(ok==false) {
		
			try {
			
				matricula=br.readLine();
					
				//Filtramos para asegurarnos de que son matrículas válidas. Aceptaremos también letras en minúscula por si el que ha escrito el txt es un troll
				if((matricula.charAt(0)>47 && matricula.charAt(0)<58) && (matricula.charAt(1)>47 && matricula.charAt(1)<58) && (matricula.charAt(2)>47 && matricula.charAt(2)<58 && 
						(matricula.charAt(3)>47 && matricula.charAt(3)<58)) && ((matricula.charAt(4)>64 && matricula.charAt(4)<91) || (matricula.charAt(4)>96 && matricula.charAt(4)<123)) &&
						((matricula.charAt(5)>64 && matricula.charAt(5)<91) || (matricula.charAt(5)>96 && matricula.charAt(5)<123)) && 
						((matricula.charAt(6)>64 && matricula.charAt(6)<91) || (matricula.charAt(6)>96 && matricula.charAt(6)<123))) {
					
					//Ingresamos la matrícula en el Map && Ingresamos la matrícula en el listado de matrículas actualmente dentro del párking
					ingresarCocheTXT(matricula);
					plateList.add(matricula);
					
				}
				
				else {
					
					throw new Exception("ALERTA =====> Fitxer incorrecte o inexistent.");
					
				}
				
		
			} catch(NullPointerException e) {
				
				ok=true;
				
			}
			
			catch (IOException e) {
			
				ok=true;
				
				throw new Exception("ALERTA =====> Fitxer incorrecte o inexistent.");
				
			}	
			
		}
		
		}catch (Exception e) {
			
			throw new Exception("ALERTA =====> Fitxer incorrecte o inexistent.");
			
		}
	
	}
	
	/**
	 * Método para introducir manualmente un coche de no discapacitado
	 * @param matricula
	 * @return Plaza ocupada
	 * @throws Exception
	 */
	public int entraCotxe(String matricula) throws Exception {
		
		//Si el coche noe stá dentro ya:
		if(parkingSlots.containsKey(matricula)==false && parkingSlotsDisc.containsKey(matricula)==false) {
			
			//Si el párking no está lleno:
			if((normCounter+discCounter)<places_no_discapacitats+places_discapacitats) {
				
				//Posibilidad de garrulo:
				if((normCounter==places_no_discapacitats && discCounter<places_no_discapacitats && ((int)Math.random()*100>50)) || (normCounter<places_no_discapacitats && ((int)Math.random()*100>85))) {
					
					int temp=encontrarHuecos(TipusPlacesParking.DISCAPACITAT);
					
					parkingSlotsDisc.put(matricula, temp);
					
					huecosDisc[temp]=true;
					
					discCounter++;
					
					plateList.add(matricula);
					
					/*
					 * Asumiremos que preferimos que salte la otra excepción
					 * 
					 * percOcup(TipusPlacesParking.DISCAPACITAT);
					 * 
					 */
					
					throw new Exception("ALERTA =====> Garrulo detected!!! Ha aparcat a la plaça: "+temp);
					
				}
				
				if(normCounter<places_no_discapacitats) {
					
					int temp=encontrarHuecos(TipusPlacesParking.NO_DISCAPACITAT);
					
					parkingSlots.put(matricula, temp);
					
					huecosNorm[temp]=true;
					
					normCounter++;
					
					plateList.add(matricula);
					
					percOcup(TipusPlacesParking.NO_DISCAPACITAT);
					
					return temp;
				}
				
				else {
					
					throw new Exception("ALERTA =====> Parking per no discapacitats ple.");
					
				}
				
			}
			
			else {
				
				throw new Exception("ALERTA =====> Parking per no discapacitats ple.");
				
			}
			
		}
		
		else {
			
			throw new Exception("El cotxe ja està al parking. No pot entrar.");
			
		}
		
	}
	
	/**
	 * Método para introducir un coche de discapacitados
	 * @param matricula
	 * @return Plaza ocupada (reservadas las del final)
	 * @throws Exception
	 */
	public int entraCotxeDiscapacitat(String matricula) throws Exception {
		
		//comprobamos que no esté ya dentro
		if(parkingSlots.containsKey(matricula)==false && parkingSlotsDisc.containsKey(matricula)==false) {
			
			//Comprobamos que no esté lleno:
			if((normCounter+discCounter)<(places_no_discapacitats+places_discapacitats)) {
				
				//Si hay sitio:
				if(discCounter<places_discapacitats) {
					
					int temp=encontrarHuecos(TipusPlacesParking.DISCAPACITAT);
					
					parkingSlotsDisc.put(matricula, temp);
					
					huecosDisc[temp]=true;
					
					discCounter++;
					
					plateList.add(matricula);
					
					percOcup(TipusPlacesParking.DISCAPACITAT);
					
					return temp;
				}
				
				//Si no hay sitio para discapacitados:
				if(discCounter==places_discapacitats && normCounter<places_no_discapacitats) {
					
					int temp=encontrarHuecos(TipusPlacesParking.NO_DISCAPACITAT);
					
					parkingSlots.put(matricula, temp);
					
					huecosNorm[temp]=true;
					
					normCounter++;
					
					plateList.add(matricula);
					
					/*
					 * Asumimos que preferimos que salte la otra excepción
					 * percOcup(TipusPlacesParking.NO_DISCAPACITAT);
					 * 
					 */
					
					throw new Exception("ALERTA =====> Parking per discapacitats ple. Ha ocupat plaça normal num: "+temp);
					
				}
				
				else {
					
					throw new Exception("ALERTA =====> Parking per discapacitats ple.");
					
				}
				
			}
			
			else {
				
				throw new Exception("ALERTA =====> Parking per discapacitats ple.");
				
			}
			
		}
		
		else {
			
			throw new Exception("El cotxe ja està al parking. No pot entrar.");
			
		}
		
	}
	
	/**
	 * Método para sacar un coche normal del párking
	 * @param matricula
	 * @throws Exception
	 */
	public void surtCotxe(String matricula) throws Exception {
		
		//Comprobamos que esté
		if(parkingSlots.containsKey(matricula)==true) {
			
			//Deajmos su hueco como libre (false)
			huecosNorm[parkingSlots.get(matricula)]=false;
			//Lo borramos del Map
			parkingSlots.remove(matricula);
			//Bajamos el contador de coches normales ocupando sitios
			normCounter--;
			//Lo borramos de la lista de matrículas de coches aparcados
			plateList.remove(matricula);
			
		}
		
		else {
			
			throw new Exception("El cotxe no és al parking.");
			
		}
		
	}

	/**
	 * Método para sacar un coche de discapacitado del párking
	 * @param matricula
	 * @throws Exception
	 */
	public void surtCotxeDiscapacitats(String matricula) throws Exception {
		
		if(parkingSlotsDisc.containsKey(matricula)==true) {
			
			huecosDisc[parkingSlotsDisc.get(matricula)]=false;
			parkingSlotsDisc.remove(matricula);
			discCounter--;
			plateList.remove(matricula);
			
		}
		
		else {
			
			throw new Exception("El cotxe no és al parking.");
			
		}
		
	}
	
	/**
	 * Método que nos indica CUÁNTAS plazas de un tipo HAY OCUPADAS ahora mismo
	 * @param tipus
	 * @return Número de plazas con coche asignado
	 */
	public int getPlacesOcupades(TipusPlacesParking tipus) {
		
		switch(tipus) {
		
		case DISCAPACITAT:
			
			return discCounter;
		
		case NO_DISCAPACITAT:
			
			return normCounter;
			
		default:
			
			System.out.println("HA PETAO PORQUE EL ENUM ES UNA MIERDA");
			
			return (Integer) null;
			
		}
		
	}
	
	/**
	 * Método que nos indica CUÁNTAS plazas de un tipo HAY LIBRES ahora mismo
	 * @param tipus
	 * @return Número de plazas sin coches asignados
	 */
	public int getPlacesLliures(TipusPlacesParking tipus) {
		
		switch(tipus) {
		
		case DISCAPACITAT:
			
			return places_discapacitats-discCounter;
		
		case NO_DISCAPACITAT:
			
			return places_no_discapacitats-normCounter;
			
		default:
			
			System.out.println("HA PETAO PORQUE EL ENUM ES UNA MIERDA");
			
			return (Integer) null;
			
		}
		
	}
	
	/**
	 * Método para guardar el listado de matrículas que hay actualmente en un formato de texto plano
	 * @param path
	 * @throws Exception
	 */
	public void guardarMatricules(String path) throws Exception  {
		
		try {
		
			loadBufferedWriter(path);
			
			for(int x=0;x<parkingSlots.size();x++) {
				
				if(huecosNorm[x]==true) {
					
					bw.write(plateList.get(x));
					
				}
				
			}
			
			closeBuffers();
			
		} catch(IOException e) {
			
			throw new Exception("ALERTA =====> Fitxer incorrecte o inexistent.");
			
		}
		
	}
	
}
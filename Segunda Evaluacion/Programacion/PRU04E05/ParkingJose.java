package PRU04E05;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Clase Parking con m�todos p�blicos est�ndar para que puedan ser llamados desde cualquier clase Test
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
	
	
	
	
	
	//M�TODOS PROPIOS DE GESTI�N INTERNA********************************
	
	
	
	
	/**
	 * M�todo para cargar el b�fer de lectura.
	 * @param path Direcci�n del archivo .TXT a leer
	 * @throws Exception Error de direcci�n no encontrada
	 */
	private void loadBufferedReader(String path) throws Exception {
				
		br=new BufferedReader(new FileReader(path));
			
	}
	
	/**
	 * M�todo para cargar el b�fer de escritura.
	 * @param path Direcci�n donde crear el .TXT
	 * @throws IOException 
	 */
	private void loadBufferedWriter(String path) throws IOException {
		
		bw=new BufferedWriter(new FileWriter(path));
			
	}
		
	/**
	 * Cierra los b�fer.
	 * @throws IOException 
	 */
	private void closeBuffers() throws IOException {
			
		br.close();
		bw.close();
			
	}
	
	/**
	 * M�todo para ingresar un coche cogiendo su matr�cula desde un .TXT
	 * @param matricula
	 * @throws Exception Error de lectura
	 */
	private void ingresarCocheTXT(String matricula) throws Exception {
		
		//Si el coche no est� ya metido:
		if(parkingSlots.containsKey(matricula)==false && parkingSlotsDisc.containsKey(matricula)==false) {
			
			//Si el p�rking no est� ya lleno:
			if((discCounter+normCounter)<places_no_discapacitats+places_discapacitats) {
				
				//Rellena el p�rking aleatoriamente
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
				
				//Sacamos esto si el que prueba la clase ha puesto un txt con m�s coches que lo puesto en el constructor
				throw new Exception("ALERTA =====> Parking per no discapacitats ple.");
				
			}
			
		}
		
		else {
			
			throw new Exception("El cotxe ja est� al parking. No pot entrar.");
			
		}
		
	}	
	
	/**
	 * M�todo para inicializar las arrays de booleans que especifican si hay o no hay un coche en esa plaza
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
	 * M�todo que busca la plaza libre m�s cercana
	 * @param tipo Tipo de plaza que se busca
	 * @return N�mero de la plaza encontrada
	 * @throws Exception Error causado por la mala gesti�n de los enum. No deber�a saltar
	 */
	private int encontrarHuecos(TipusPlacesParking tipo) throws Exception{
		
		switch(tipo) {
		
		case DISCAPACITAT:
			
			for(int x=0;x<huecosDisc.length;x++) {
			
				if(huecosDisc[x]==false) {
					
					//Nos devolver� la posici�n m�s pr�xima a 0 donde no haya nadie. Es as� para volver a colocar a alguien en una plaza de donde se acaben de marchar
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
			
			//No prestar atenci�n. Cambiar cuando Xavi conteste a lo de los enum
			throw new Exception("HA PETAO PORQUE EL ENUM ES UNA MIERDA");
			
		}
		//No prestar atenci�n. Cambiar cuando Xavi conteste a lo de los enum
		throw new Exception("HA PETAO PORQUE EL NING�N BUCLE HA ENCONTRADO EL HUECO QUE TOCA");
		
	}
	
	/**
	 * M�todo para calcular el porcentaje de ocupaci�n de cada tipo de plaza
	 * @param tipo Tipo de plaza
	 * @throws Exception Aviso si hay ocupado m�s de un 85%
	 */
	private void percOcup(TipusPlacesParking tipo) throws Exception {
		
		/*
		 * El m�todo no har� nada hasta que se tope con que hay un porcentaje de ocupaci�n
		 * de ese tipo de plaza de aparcamiento superior al 85%. Entonces soltar� un error
		 * que deber�a detener la ejecuci�n del m�todo superior que lo est� llamando
		 */
		
		switch(tipo) {
		
		case DISCAPACITAT:
			
			if(((discCounter*100)/places_discapacitats)>85) {
				
				throw new Exception("ALERTA =====> Ocupaci� de places per discapacitats supera el 85%.");
				
			}
			
			break;
			
		case NO_DISCAPACITAT:
			
			if(((normCounter*100)/places_no_discapacitats)>85) {
				
				throw new Exception("ALERTA =====> Ocupaci� de places per no discapacitats supera el 85%.");
				
			}
			
			break;
			
		default:
			
			//Cambiar cuando Xavi conteste
			throw new Exception("EL ENUM HA PETAO PORQUE ES UNA MIERDA");
		
		}
		
	}
	
	
	//M�TODOS GENERALES ESPECIFICADOS EN EL ENUNCIADO***************************

	
	
	
	/**
	 * Constructor est�ndar de las clases Parking
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
	 * M�todo para meter en el p�rking autom�ticamente todas las matr�culas que nos pasan
	 * @param path
	 * @throws Exception M�LTIPLES: ficheros incorrectos || p�rking lleno (m�s coches en el txt de lo especificado en el constructor
	 */
	public void llegirMatricules(String path) throws Exception{
		
		String matricula;
		boolean ok=false;
		
		try {
		
		loadBufferedReader(path);
		
		while(ok==false) {
		
			try {
			
				matricula=br.readLine();
					
				//Filtramos para asegurarnos de que son matr�culas v�lidas. Aceptaremos tambi�n letras en min�scula por si el que ha escrito el txt es un troll
				if((matricula.charAt(0)>47 && matricula.charAt(0)<58) && (matricula.charAt(1)>47 && matricula.charAt(1)<58) && (matricula.charAt(2)>47 && matricula.charAt(2)<58 && 
						(matricula.charAt(3)>47 && matricula.charAt(3)<58)) && ((matricula.charAt(4)>64 && matricula.charAt(4)<91) || (matricula.charAt(4)>96 && matricula.charAt(4)<123)) &&
						((matricula.charAt(5)>64 && matricula.charAt(5)<91) || (matricula.charAt(5)>96 && matricula.charAt(5)<123)) && 
						((matricula.charAt(6)>64 && matricula.charAt(6)<91) || (matricula.charAt(6)>96 && matricula.charAt(6)<123))) {
					
					//Ingresamos la matr�cula en el Map && Ingresamos la matr�cula en el listado de matr�culas actualmente dentro del p�rking
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
	 * M�todo para introducir manualmente un coche de no discapacitado
	 * @param matricula
	 * @return Plaza ocupada
	 * @throws Exception
	 */
	public int entraCotxe(String matricula) throws Exception {
		
		//Si el coche noe st� dentro ya:
		if(parkingSlots.containsKey(matricula)==false && parkingSlotsDisc.containsKey(matricula)==false) {
			
			//Si el p�rking no est� lleno:
			if((normCounter+discCounter)<places_no_discapacitats+places_discapacitats) {
				
				//Posibilidad de garrulo:
				if((normCounter==places_no_discapacitats && discCounter<places_no_discapacitats && ((int)Math.random()*100>50)) || (normCounter<places_no_discapacitats && ((int)Math.random()*100>85))) {
					
					int temp=encontrarHuecos(TipusPlacesParking.DISCAPACITAT);
					
					parkingSlotsDisc.put(matricula, temp);
					
					huecosDisc[temp]=true;
					
					discCounter++;
					
					plateList.add(matricula);
					
					/*
					 * Asumiremos que preferimos que salte la otra excepci�n
					 * 
					 * percOcup(TipusPlacesParking.DISCAPACITAT);
					 * 
					 */
					
					throw new Exception("ALERTA =====> Garrulo detected!!! Ha aparcat a la pla�a: "+temp);
					
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
			
			throw new Exception("El cotxe ja est� al parking. No pot entrar.");
			
		}
		
	}
	
	/**
	 * M�todo para introducir un coche de discapacitados
	 * @param matricula
	 * @return Plaza ocupada (reservadas las del final)
	 * @throws Exception
	 */
	public int entraCotxeDiscapacitat(String matricula) throws Exception {
		
		//comprobamos que no est� ya dentro
		if(parkingSlots.containsKey(matricula)==false && parkingSlotsDisc.containsKey(matricula)==false) {
			
			//Comprobamos que no est� lleno:
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
					 * Asumimos que preferimos que salte la otra excepci�n
					 * percOcup(TipusPlacesParking.NO_DISCAPACITAT);
					 * 
					 */
					
					throw new Exception("ALERTA =====> Parking per discapacitats ple. Ha ocupat pla�a normal num: "+temp);
					
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
			
			throw new Exception("El cotxe ja est� al parking. No pot entrar.");
			
		}
		
	}
	
	/**
	 * M�todo para sacar un coche normal del p�rking
	 * @param matricula
	 * @throws Exception
	 */
	public void surtCotxe(String matricula) throws Exception {
		
		//Comprobamos que est�
		if(parkingSlots.containsKey(matricula)==true) {
			
			//Deajmos su hueco como libre (false)
			huecosNorm[parkingSlots.get(matricula)]=false;
			//Lo borramos del Map
			parkingSlots.remove(matricula);
			//Bajamos el contador de coches normales ocupando sitios
			normCounter--;
			//Lo borramos de la lista de matr�culas de coches aparcados
			plateList.remove(matricula);
			
		}
		
		else {
			
			throw new Exception("El cotxe no �s al parking.");
			
		}
		
	}

	/**
	 * M�todo para sacar un coche de discapacitado del p�rking
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
			
			throw new Exception("El cotxe no �s al parking.");
			
		}
		
	}
	
	/**
	 * M�todo que nos indica CU�NTAS plazas de un tipo HAY OCUPADAS ahora mismo
	 * @param tipus
	 * @return N�mero de plazas con coche asignado
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
	 * M�todo que nos indica CU�NTAS plazas de un tipo HAY LIBRES ahora mismo
	 * @param tipus
	 * @return N�mero de plazas sin coches asignados
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
	 * M�todo para guardar el listado de matr�culas que hay actualmente en un formato de texto plano
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
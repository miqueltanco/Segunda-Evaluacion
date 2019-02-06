package examen3101intentarmejorar;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

/**
 * Este programa es un intento de mejora del examen de programacion de 1DAM el dia 31/01, no he conseguido mejorarlo completamente.
 * @author Yugen
 *
 */

public class ExamenMejorado {

	//RUTAS DONDE ESTA EL MP3 Y DONDE ESTARA EL MP3 MODIFICADO
	
	public static final String RUTA_MP3 = "C:\\Temp\\PR2AVAEX02.mp3";
	public static final String RUTA_MP3Edit = "C:\\Temp\\PR2AVAEX02_Miquel_Tanco.mp3";

	//CONVERSION DE SISTEMAS DE NUMERACION POSICIONAL
	
	public int convertirHexAdec(String hex) {
		int decimal=Integer.parseInt(hex,16);
		return decimal;
	}

	//OBTIENE LOS BYTES QUE GESTIONAN EL TAMAÑO EN EL ID3 PERO SIN DESCODIFICAR DE SYNCSAFE
	
	public String obtenerSizeBytes(InputStream is) throws IOException {
		int x;
		String p="";

		for(int i = 0; i < 4; i++) {
			x = is.read();
			p = (p + "0" + Integer.toString(x));
		}
		return p;

	}

	//SALTA LOS BYTES QUE NO TENEMOS QUE MODIFICAR, TIENES QUE INTRODUCIR EL NUMERO DE SALTOS
	
	public void saltoByte (int salto, InputStream is, OutputStream os) throws IOException{

		int x;
		int contador = 0;

		do {
			x = is.read();
			os.write(x);
			contador++;
		}while(contador != salto);

	}

	//MODIFICA EL SIZE DE UN CAMPO ID3 || CABECERA O FRAME UTILIZAN 4 || METODO EN DESARROLLO, QUIERO QUE SE INTRODUZCA DE MANERA AUTOMATICA

	public void modificarSize(int pos06,int pos07, int pos08, int pos09, InputStream is, OutputStream os) throws IOException {

		SyncSafe conversion = new SyncSafe();

		os.write(conversion.Encode(pos06));
		os.write(conversion.Encode(pos07));
		os.write(conversion.Encode(pos08));
		os.write(conversion.Encode(pos09));

	}

	//INTRODUCE EL TEXTO QUE QUIERAS EN EL CAMPO ID3 DEL ALBUM
	
	public void introducirTexto(String cadena, OutputStream os) throws IOException {
		for(int i = 0; i < cadena.length();i++) {
			int x = cadena.charAt(i);
			os.write(x);
		}
	}

	//ESTE METODO SE UTILIZA PARA EQUILIBRAR LA LECTURA Y ESCRITURA, SI LEEMOS EL TEXTO ANTIGUO DEJAMOS EL READ() EN LA POSICION DEL WRITE() Y ASI NO NOS COMEMOS CARACTERES
	
	public void leerAntiguoTexto(int size, InputStream is) throws IOException {
		for(int i = 0; i < size;i++) {
			is.read();
		}
	}

	public static void main(String[]args) {

		SyncSafe conversion = new SyncSafe();
		ExamenMejorado ExamenMejorado = new ExamenMejorado();
		Scanner sc = new Scanner(System.in);

		
		//HASTA QUE NO SEPA COMO INTRODUCIR EL SIZE DE MANERA AUTOMATICA DEJO VALORES FIJOS
		//System.out.println("Indica que quieres introducir en campo Album: ");

		String InputText = /* sc.nextLine; */ "Examen programació CIDE";
		
		int x;
		int size;

		try {

			InputStream is = new FileInputStream(RUTA_MP3);
			OutputStream os = new FileOutputStream(RUTA_MP3Edit);

			x = is.read();			
		//ESTE IF DETECTA SI EL ARCHIVO ESTA VACIO
			if(x != -1) {
				
		//ESCRIBIMOS EL PRIMER BYTE PARA NO PERDERLO
				os.write(x);
				
		//DE AQUI HASTA ABAJO ES UNA COMIDAD DE OLLA, UTILIZANDO LOS METODOS DE ARRIBA, SI CONSIGO METER EL SIZE DE MANERA AUTOMATICA LO COMENTARÉ TODO	
				
				ExamenMejorado.saltoByte(5, is, os);
				size = ExamenMejorado.convertirHexAdec(ExamenMejorado.obtenerSizeBytes(is));
				System.out.println("La longitud total de los datos ID3 es: " + size + " bytes (codificado)");
				size = conversion.Decode(size);
				System.out.println("La longitud total de los datos ID3 es: " + size + " bytes (descodificado)");
				size = (size + InputText.length());
				System.out.println("La longitud total de los datos ID3 con el campo Album modificado es: " + size + " bytes (descodificado)");
				ExamenMejorado.modificarSize(00, 00, 42, 19, is, os);
				ExamenMejorado.saltoByte(26, is, os);
				String p = ExamenMejorado.obtenerSizeBytes(is);
				size = Integer.parseInt(p);
				System.out.println("La longitud del campo Album de los datos ID3 es: " + size + " bytes (codificado)");
				size = conversion.Decode(size);
				ExamenMejorado.modificarSize(00, 00, 00, 25, is, os);
				ExamenMejorado.saltoByte(3, is, os);
				ExamenMejorado.leerAntiguoTexto(size, is);
				System.out.println("La longitud del campo Album de los datos ID3 es: " + size + " bytes (descodificado)");
				size = (size + InputText.length());
				System.out.println("La longitud del campo Album de los datos ID3 es: " + size + " bytes (descodificado)");
				ExamenMejorado.introducirTexto(InputText, os);

				//COMO YA HEMOS MODIFICADO LO QUE QUERIAMOS LEEMOS TODO EL ARCHIVO RESTANTE
				
				do {
					os.write(x);
					x = is.read();

				}while(x != -1);

			}

			os.close();
			is.close();

		}
		catch (FileNotFoundException e) {
			System.out.println("Archivo no encontrado");
		}
		catch (IOException e) {
			System.out.println("El archivo no se puede abrir");
		}
	}
}

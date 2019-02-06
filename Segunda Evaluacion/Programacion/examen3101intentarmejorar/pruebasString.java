package examen3101intentarmejorar;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;


public class pruebasString {
	
	public static final String RUTA_MP3 = "C:\\Temp\\PR2AVAEX02.mp3";
	public static final String RUTA_MP3Edit = "C:\\Temp\\PR2AVAEX02_Miquel_Tanco.mp3";

	public int convertirHexAdec(String hex) {
		int decimal=Integer.parseInt(hex,16);
		return decimal;
	}
	
	public String obtenerSizeBytes(InputStream is) throws IOException {
		int x;
		String p="";
		
		for(int i = 0; i < 4; i++) {
			x = is.read();
			p = (p + "0" + Integer.toString(x));
		}
		return p;

	}
	
	public void saltoByte (int salto, InputStream is, OutputStream os) throws IOException{

		int x;
		int contador = 0;

			do {
				x = is.read();
				os.write(x);
				contador++;
			}while(contador != salto);
		
	}
	
	public void introducirTextoCampo(String InputText, OutputStream os) throws IOException {
		
		int x = 0;
		
		for(int i = 0; i < InputText.length();i++) {
			x = InputText.charAt(i);
			os.write(x);
		}
	}
	
	public void modificarSize(int pos06,int pos07, int pos08, int pos09, InputStream is, OutputStream os) throws IOException {
		
		SyncSafe conversion = new SyncSafe();
		
			os.write(conversion.Encode(pos06));
			os.write(conversion.Encode(pos07));
			os.write(conversion.Encode(pos08));
			os.write(conversion.Encode(pos09));

	}
	
	
	public static void main(String[]args) {

		 SyncSafe conversion = new SyncSafe();
		 ExamenMejorado ExamenMejorado = new ExamenMejorado();
		 Scanner sc = new Scanner(System.in);
		
		 System.out.println("Indica que quieres introducir en campo Album: ");
		 
		String InputText = /* sc.nextLine; */ "Examen programació CIDE";
		int x;
		int size;
		
		try {

			InputStream is = new FileInputStream(RUTA_MP3);
			OutputStream os = new FileOutputStream(RUTA_MP3Edit);

			x = is.read();
			// Al leer una vez el archivo podemos ver si está vacio o no, si está vacio ya no entrará en el if
			
			if(x != -1) {
				os.write(x);
				ExamenMejorado.saltoByte(5, is, os);
				size = ExamenMejorado.convertirHexAdec(ExamenMejorado.obtenerSizeBytes(is));
				System.out.println("La longitud total de los datos ID3 es: " + size + " bytes (codificado)");
				size = conversion.Decode(size);
				System.out.println("La longitud total de los datos ID3 es: " + size + " bytes (descodificado)");
				size = (size + InputText.length());
				System.out.println("La longitud total de los datos ID3 con el campo Album modificado es: " + size + " bytes (descodificado)");
				ExamenMejorado.modificarSize(00, 00, 42, 19, is, os);
				ExamenMejorado.saltoByte(26, is, os);
				String prueba = ExamenMejorado.obtenerSizeBytes(is);
				size = Integer.parseInt(prueba);
				System.out.println("La longitud del campo Album de los datos ID3 es: " + prueba + " bytes (codificado)");
				System.out.println("La longitud del campo Album de los datos ID3 es: " + size + " bytes (codificado)");
				
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

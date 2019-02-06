package examen3101intentarmejorar;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class PruebaMetodoHex {

	public int convertirHexAdec(String hex) {
		int decimal=Integer.parseInt(hex,16);
		return decimal;
	}

	public static final String RUTA_MP3 = "C:\\Temp\\PR2AVAEX02.mp3";
	public static final String RUTA_MP3Edit = "C:\\Temp\\PR2AVAEX02_Miquel_Tanco.mp3";


	public static void main (String[]args){

		//ESTO FUNCIONA ES PARA CONVERTIR HEX A DEC

		/*PruebaMetodoHex prueba = new PruebaMetodoHex();

		String hex="00010402";  

		int dec = prueba.convertirHexAdec(hex);

		System.out.println(dec);*/


		PR2AVAEX02_Miquel_Tanco prueba = new PR2AVAEX02_Miquel_Tanco();
		SyncSafe conversion = new SyncSafe();

		int x;

		try {

			InputStream is = new FileInputStream(RUTA_MP3);
			OutputStream os = new FileOutputStream(RUTA_MP3Edit);

			x = is.read();
			os.write(x);
			prueba.saltoByte(5, is, os);









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

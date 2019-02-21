package examen3101;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class PR2AVAEX02_Miquel_Tanco {

	public static final String RUTA_MP3 = "C:\\Temp\\PR2AVAEX02.mp3";
	public static final String RUTA_MP3Edit = "C:\\Temp\\PR2AVAEX02_Miquel_Tanco.mp3";

	//El método saltoByte se utiliza para como su nombre expresa saltar posiciones en el archivo y asi poder ir a la posicion deseada

	public void saltoByte (int salto, InputStream is, OutputStream os){

		int x;
		int contador = 0;

		try {
			do {
				x = is.read();
				os.write(x);
				contador++;
			}while(contador != salto);
		}

		catch (IOException e) {
			System.out.println("El archivo no se puede abrir");
		}
	}

	//El cambioTamanyo consiste en cambiar los 4 bytes de la capsalera

	public void cambioTamanyo(int pos06,int pos07, int pos08, int pos09, InputStream is, OutputStream os, SyncSafe conversion) {
		int x;

		try {
			x = is.read();
			x = is.read();
			x = is.read();
			x = is.read();
			os.write(conversion.Encode(pos06));
			os.write(conversion.Encode(pos07));
			os.write(conversion.Encode(pos08));
			os.write(conversion.Encode(pos09));

		}catch (IOException e) {
			System.out.println("El archivo no se puede abrir");
		}
	}

	//Metodo escribirNombre cambia el nombre del albun

	public void escribirNombre(OutputStream os,InputStream is) {
		try {

			os.write(69);
			os.write(120);
			os.write(97);
			os.write(109);
			os.write(101);
			os.write(110);	
			os.write(32);
			os.write(112);
			os.write(114);
			os.write(111);
			os.write(103);
			os.write(114);
			os.write(97);
			os.write(109);
			os.write(97);
			os.write(99);
			os.write(105);
			os.write(243);
			os.write(32);
			os.write(67);
			os.write(73);
			os.write(68);
			os.write(69);

			for(int i = 0;i<13;i++)
				is.read();


		}catch (IOException e) {
			System.out.println("El archivo no se puede abrir");
		}
	}

	public static void main(String[] args) {

		PR2AVAEX02_Miquel_Tanco prueba = new PR2AVAEX02_Miquel_Tanco();
		SyncSafe conversion = new SyncSafe();

		int x;
		int variablecambio;

		try {

			InputStream is = new FileInputStream(RUTA_MP3);
			OutputStream os = new FileOutputStream(RUTA_MP3Edit);

			x = is.read();

			//Utilizo el if para detectar si el archivo que leemos esta vacio

			if (x != -1) {
				os.write(x);
				prueba.saltoByte(5, is, os);
				prueba.cambioTamanyo(00, 00, 42, 15, is, os, conversion);
				prueba.saltoByte(29, is, os);
				variablecambio = 33;
				variablecambio = conversion.Encode(variablecambio);
				is.read();
				os.write(variablecambio);
				prueba.saltoByte(3, is, os);
				prueba.escribirNombre(os, is);
				x = is.read();

				//despues de haber cambiado todo utilizamos el bucle de abajo para terminar de escribir todo el archivo

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

package pru03e07;
import java.util.ArrayList;
import java.util.Scanner;
public class Pruebas {

public static void main (String[]args) {
	
	Scanner sc = new Scanner(System.in);
	
		ArrayList<Article> listaArticulo;
		listaArticulo = new ArrayList<Article>();
		
		Article ArticuloPrueba = new Article();
		
		listaArticulo.add(ArticuloPrueba);
		listaArticulo.get(0).setCodi("Libre");
		//listaArticulo.
		
		//NO FUNCIONA INSERTAR O MODIFICAR DATOS EN VARIABLES DE UN OBJETO DENTRO DE UNA ARRAYLIST
		//OTROS COMPAÑEROS ME HAN ENSEÑADO SU CODIGO Y SIEMPRE INSERTAN LOS DATOS ANTES DE METER EL OBJETO EN LA ARRAYLIST.
		


	}
}

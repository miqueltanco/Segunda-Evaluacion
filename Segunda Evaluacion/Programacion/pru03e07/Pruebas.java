package pru03e07;
import java.util.ArrayList;
import java.util.Scanner;
public class Pruebas {

	public static int localitza_objecte(ArrayList<Article> llistaArticles, String codiCercat) {
		for (int i=0;i<llistaArticles.size();i++) {
			if (llistaArticles.get(i).codi.equals(codiCercat))
				return i;
		}
		return -1;
	}
	public static int modificaCodiArticle(ArrayList<Article> llistaArticles, String codiCercat, String codiNou) {
		int codi_modificat=-1;
		for (int i=0;i<llistaArticles.size();i++) {
			if (llistaArticles.get(i).codi.equals(codiCercat)) {
				llistaArticles.get(i).setCodi(codiNou);
				codi_modificat++;
				llistaArticles.set(1, llistaArticles.get(i));
			}
		}
		return codi_modificat;

	}

	
public static void main (String[]args) {
	
	Scanner sc = new Scanner(System.in);
	
		ArrayList<Article> listaArticulo = new ArrayList<Article>();
		
		Article ArticuloPrueba = new Article();
		Article nouArticle = new Article();
		nouArticle.setCodi("CODI2");
		
		
		listaArticulo.add(ArticuloPrueba);
		listaArticulo.add(ArticuloPrueba);
		listaArticulo.add(nouArticle);
		nouArticle.setCodi("CODI3");
				//listaArticulo.get(ArticuloPrueba).setCodi("Libre");
		//listaArticulo.get(listaArticulo.indexOf(ArticuloPrueba)).setCodi("Libre");
		System.out.println("Objeto devuelto por get de la lista: "+listaArticulo.get(listaArticulo.indexOf(ArticuloPrueba)));
		System.out.println("Posicion del objeto en la lista:"+listaArticulo.lastIndexOf(ArticuloPrueba));
		
		System.out.println("Posicion del elemento con CODI2:"+localitza_objecte(listaArticulo,"CODI2"));
		modificaCodiArticle(listaArticulo,"CODI3","CODI999999");
		System.out.println("Posicion del elemento con CODI3:"+localitza_objecte(listaArticulo,"CODI3"));
		System.out.println("Posicion del elemento con CODI999999:"+localitza_objecte(listaArticulo,"CODI999999"));
		
		//NO FUNCIONA INSERTAR O MODIFICAR DATOS EN VARIABLES DE UN OBJETO DENTRO DE UNA ARRAYLIST
		//OTROS COMPAÑEROS ME HAN ENSEÑADO SU CODIGO Y SIEMPRE INSERTAN LOS DATOS ANTES DE METER EL OBJETO EN LA ARRAYLIST.
		


	}
}

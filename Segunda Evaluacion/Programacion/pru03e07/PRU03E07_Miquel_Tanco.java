package pru03e07;

import java.util.ArrayList;
import java.util.Scanner;

public class PRU03E07_Miquel_Tanco {

	//ESTE CONTADOR LO UTILIZO PARA DETERMINAR LA POSICION DEL ARTICULO DENTRO DE LA ARRAY Y ASI PODER ESCOGER QUE ARTICULO SE MODIFICA O SE ELIMINA.
	//PARA EL USUARIO QUE ESTA UTILANZO EL PROGRAMA VE UN NUMERO DIFERENTE AL REAL, CONCRETAMENTE LE SUMO 1 AL CONTADOR
	// CUANDO SE LO MUESTRO AL USUARIO, ES DECIR 0 = 1 MOSTRADO POR PANTALLA.

	static int contadorarray = 0;

	public static void main (String[]args) {

		//SCANNERS, TENIA PROBLEMAS Y LOS SIGO TENIENDO CON LOS SCANNERS, CUANDO CREAS EL SEGUNDO OBJETO, 
		//EL PRIMER SCANNER QUE DEBE HACER (CODI) SE LO FUMA, Y NO DEJA INTRODUCIRLO,
		//UNICAMENTE A PARTIR DEL 2º OBJETO, EL PRIMERO FUNCIONA.

		Scanner sc = new Scanner(System.in);
		Scanner altaArticulos = new Scanner(System.in);

		//ARRAYLIST DE ARTICULOS.

		ArrayList<Article> listaArticulo = new ArrayList<Article>();

		//VARIABLES QUE UTILIZO PARA EL MENU Y PARA OTROS USOS.

		boolean salir = false;
		int decision;
		int dropLista;
		int entradaMercancia;
		int escogerArticulo;
		int stockActual;

		//VARIABLES DE LOS OBJETOS ARTICULO.

		String codi;
		String descripcio;
		double preuDeCompra;
		double preuDeVenda;
		int stock;

		//UN MENU MUY FEO, QUE TENGO QUE APRENDER A REALIZAR MENUS MEJORES.

		while (!salir) {

			System.out.println("	MENU ARTICULO");
			System.out.println("1. Lista de articulos");
			System.out.println("2. Alta");
			System.out.println("3. Baja");
			System.out.println("4. Modificacion");
			System.out.println("5. Entrada de mercancia");
			System.out.println("6. Salida de mercancia");
			System.out.println("7. Salir");
			System.out.println("=============================");

			decision = sc.nextInt();			

			switch (decision) {
			case 1:

				//UN MENU DENTRO DE UN MENU QUE DESPLEGA OTRO MENU, CON EL OBJETIVO DE TENER MAS FLEXIBILIDAD A LA HORA DE MOSTRAR LOS ARTICULOS,
				//PUEDES SELECCIONAR QUE TE ENSEÑE TODOS O UNICAMENTE UNO.

				if(listaArticulo.size() > 0) {
					System.out.println("Hay " + listaArticulo.size() + " articulos.");
					System.out.println("Elige:");			 
					System.out.println("		1. Mostrar todos");
					System.out.println("		2. Mostrar uno (elegido)");
					System.out.println("		3. Salir");
					decision = sc.nextInt();
					switch (decision) {
					case 1:
						System.out.println(listaArticulo);
						break;
					case 2:
						System.out.println("Del 1 al " + listaArticulo.size());
						decision = sc.nextInt();
						if(decision >= 1 && decision <= listaArticulo.size()) {
							System.out.println(listaArticulo.get(decision-1));
						}
						else
							System.out.println("Numero equivocado");
						break;
					case 3:
						break;
					default:
						System.out.println("Introduce un número correcto.");
						decision = sc.nextInt();
					}
				}
				else System.out.println("No existen articulos.");
				break;

			case 2:	

				//SOLICITAMOS AL USUARIO QUE INTRODUZCA TODOS LOS VALORES QUE QUIERE INSERTAR EN EL ARTICULO Y DESPUES LO METEMOS EN LA ARRAY
				//COMO HE PUESTO ARRIBA ANTERIORMENTE A PARTIR DEL 2º OBJETO QUE CREAS, EL SCANNER DE CODIGO NO FUNCIONA, HE INTENADO UTILIZAR UN SEGUNDO SCANNER,
				//A VER SI SE SOLUCIONABA, NO HE PODIDO.

				System.out.println("Introduce codigo del articulo: ");
				codi = altaArticulos.nextLine();
				System.out.println("Introduce descripcion del articulo: ");
				descripcio = altaArticulos.nextLine();
				System.out.println("Introduce precio de compra del articulo: ");
				preuDeCompra = altaArticulos.nextDouble();
				System.out.println("Introduce precio de venta del articulo: ");
				preuDeVenda = altaArticulos.nextDouble();
				System.out.println("Introduce stock del articulo: ");
				stock = altaArticulos.nextInt();

				listaArticulo.add(new Article());

				listaArticulo.get(contadorarray).setCodi(codi);
				listaArticulo.get(contadorarray).setDescripcio(descripcio);
				listaArticulo.get(contadorarray).setPreuDeCompra(preuDeCompra);
				listaArticulo.get(contadorarray).setPreuDeVenda(preuDeVenda);
				listaArticulo.get(contadorarray).setStock(stock);

				System.out.println("Este articulo se encuentra en la posición: " + (contadorarray+1));

				contadorarray++;
				break;

			case 3:

				//CON ESTE IF NOS ASEGURAMOS QUE NO SALTEN EXCEPTIONS A LA HORA DE BORRAR ARTICULOS EN LA ARRAY YA QUE NO TE DEJA ENTRAR 
				//A MENOS QUE LA ARRAY TENGA 1 ARTICULO COMO MINIMO.

				if(listaArticulo.size() > 0) {
					System.out.println("Que articulo quieres dar de baja: ");
					dropLista = sc.nextInt();
					if((dropLista-1) < listaArticulo.size()) {
						listaArticulo.remove((dropLista-1));

						System.out.println("El articulo " + dropLista + " ha sido eliminado.");
						contadorarray--;
					}
					else System.out.println("No existe ese articulo");
				}
				else System.out.println("No existen articulos.");
				break;

			case 4:
				
				//PODRIA HABER HECHO OTRO SUBMENU PARA QUE EL USUARIO PUDIERA MODIFICAR UNICAMENTE UN APARTADO...
				
				if(listaArticulo.size() > 0) {
					System.out.println("Que articulo quieres modificar: ");
					escogerArticulo = sc.nextInt();
					if((escogerArticulo-1) < listaArticulo.size()) {

						System.out.println("Introduce codigo del articulo: ");
						codi = altaArticulos.nextLine();
						System.out.println("Introduce descripcion del articulo: ");
						descripcio = altaArticulos.nextLine();
						System.out.println("Introduce precio de compra del articulo: ");
						preuDeCompra = altaArticulos.nextDouble();
						System.out.println("Introduce precio de venta del articulo: ");
						preuDeVenda = altaArticulos.nextDouble();
						System.out.println("Introduce stock del articulo: ");
						stock = altaArticulos.nextInt();

						listaArticulo.get((escogerArticulo-1)).setCodi(codi);
						listaArticulo.get((escogerArticulo-1)).setDescripcio(descripcio);
						listaArticulo.get((escogerArticulo-1)).setPreuDeCompra(preuDeCompra);
						listaArticulo.get((escogerArticulo-1)).setPreuDeVenda(preuDeVenda);
						listaArticulo.get((escogerArticulo-1)).setStock(stock);						
					}
					else System.out.println("No existe ese articulo");
				}
				else System.out.println("No existen articulos.");
				break;

			case 5:
				
				//INTRODUCIR STOCK, NO LO MODIFICA, LO SUMA
				
				if(listaArticulo.size() > 0) {
					System.out.println("De que articulo entra mercancia: ");
					escogerArticulo = sc.nextInt();
					if((escogerArticulo-1) < listaArticulo.size()) {
						System.out.println("Del articulo seleccionado en stock hay: " + listaArticulo.get((escogerArticulo-1)).stock + " unidades.");
						System.out.println("Cuanta mercancia entra: ");
						entradaMercancia = sc.nextInt();

						stockActual = listaArticulo.get((escogerArticulo-1)).stock;

						listaArticulo.get((escogerArticulo-1)).setStock(stockActual+entradaMercancia);

						System.out.println("En el articulo ahora hay: " + (stockActual+entradaMercancia) + " unidades.");
					}
					else System.out.println("No existe ese articulo");
				}
				else System.out.println("No existen articulos.");
				break;

			case 6:
				
				//SACAR STOCK, NO LO MODIFICA, LO RESTA, SI RESTA MAS DEL QUE TIENE EN REALIDAD SALTA UN IF
				
				if(listaArticulo.size() > 0) {
					System.out.println("De que articulo sale mercancia: ");
					escogerArticulo = sc.nextInt();
					if((escogerArticulo-1) < listaArticulo.size()) {
						System.out.println("Del articulo seleccionado en stock hay: " + listaArticulo.get((escogerArticulo-1)).stock + " unidades.");
						System.out.println("Cuanta mercancia sale: ");
						entradaMercancia = sc.nextInt();

						if(entradaMercancia <= listaArticulo.get((escogerArticulo-1)).stock) {

							stockActual = listaArticulo.get((escogerArticulo-1)).stock;

							listaArticulo.get((escogerArticulo-1)).setStock(stockActual-entradaMercancia);

							System.out.println("En el articulo ahora hay: " + (stockActual-entradaMercancia) + " unidades.");
						}
						else System.out.println("Estas sacando mas de lo que hay en el almacen.");
					}
					else System.out.println("No existe ese articulo");
				}
				else System.out.println("No existen articulos.");
				break;

			case 7:
				salir=true;
				break;

			default:
				System.out.println("Introduce un número correcto.");
				decision = sc.nextInt();
			}	
		}
	}
}
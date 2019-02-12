package PRU04E05pruebasfuerapackage;


import java.util.InputMismatchException;
import java.util.Scanner;

import PRU04E05.ParkingJose;

/**
 * Ejercicio Párking. Apartado menú para probar párkings.
 * @author kryon
 *
 */
public class PRU04E05ParkingTest_JoseMiguel_Pascual {

	private Scanner input=new Scanner(System.in);
	private int hlighted=0;
	private ParkingJose parking;
	private boolean finish=false;
	
	
	/**
	 * Método para cerrar input.
	 */
	public void closeScanner() {
		
		input.close();
		
	}

	/**
	 * Saludo al iniciarse el programa.
	 * @return
	 */
	public String welcome() {
		
		System.out.println("\033[H\033[2J");
		
		return
				" __    _    __  ___  _        __   __   ._  _.  ___          .____.  ___                        \n" + 
				"\\   \\  /  \\  /   / |   _||  |      /      | /  _  \\  |   \\/   | |   _|         |           | /  _  \\                       \n" + 
				" \\   \\/    \\/   /  |  |_   |  |     |  ,----'|  |  |  | |  \\  /  | |  |_            `---|  |----`|  |  |  |                      \n" + 
				"  \\            /   |   _|  |  |     |  |     |  |  |  | |  |\\/|  | |   _|               |  |     |  |  |  |                      \n" + 
				"   \\    /\\    /    |  |__ |  `----.|  `----.|  `--'  | |  |  |  | |  |__              |  |     |  `--'  |     _     _     __ \n" + 
				"    \\_/  \\/     |__||__| \\__| \\__/  ||  || |__|             |_|      \\__/     ()   ()   (_)\n" + 
				"                                                                                                                                   "+"\n\n\n"+
				".____.  ___   .__      .__      _      .__       _  __  _  ._   _.   ____     \n" + 
				"|           | /  _  \\  |   _  \\     |   _  \\    /   \\     |   _  \\     |  |/  / |  | |  \\ |  |  /  __|    \n" + 
				"`---|  |----`|  |  |  | |  |)  |    |  |)  |  /  ^  \\    |  |)  |    |  '  /  |  | |   \\|  | |  |  _      \n" + 
				"    |  |     |  |  |  | |   _/     |   _/  /  /\\  \\   |      /     |    <   |  | |  . `  | |  | | |     \n" + 
				"    |  |     |  `--'  | |  |         |  |     /  __  \\  |  |\\  \\----.|  .  \\  |  | |  |\\   | |  |_| |     \n" + 
				"    |_|      \\__/  | _|         | _|    //     \\\\ | _| `._|||\\\\ || || \\|  \\___|     \n" + 
				"                                                                                                              \n" + 
				"._  _.      _      ._   _.      _       ___  ___ ._  _.  ___ ._   _. ._____.\n" + 
				"|   \\/   |     /   \\     |  \\ |  |     /   \\     /  __||   __||   \\/   | |   ___||  \\ |  | |           |\n" + 
				"|  \\  /  |    /  ^  \\    |   \\|  |    /  ^  \\   |  |  _  |  |_   |  \\  /  | |  |__   |   \\|  | `---|  |----`\n" + 
				"|  |\\/|  |   /  /\\  \\   |  . `  |   /  /\\  \\  |  | |_ | |   _|  |  |\\/|  | |   _|  |  . `  |     |  |     \n" + 
				"|  |  |  |  /  __  \\  |  |\\   |  /  __  \\ |  |_| | |  |_ |  |  |  | |  |__ |  |\\   |     |  |     \n" + 
				"|_|  || //     \\\\ || \\| //     \\\\ \\__| |__||_|  || |__||_| \\|     |_|     \n" + 
				"                                                                                                              \n" + 
				"     __._    __  __.___. ___ ._  __.                                            \n" + 
				"    /       |\\   \\  /   / /       |           ||   __||   \\/   |                                            \n" + 
				"   |   (----` \\   \\/   / |   (----`---|  |----`|  |__   |  \\  /  |                                            \n" + 
				"    \\   \\      \\_    /   \\   \\       |  |     |   _|  |  |\\/|  |                                            \n" + 
				".----)   |       |  | .----)   |      |  |     |  |__ |  |  |  |                                            \n" + 
				"|__/        || |__/       |_|     |__||_|  |_|                                            \n" + 
				"                                                                                                              "+
				"";
		
	}

	/**
	 * Método estándar propio de input de números.
	 * @return
	 */
	public int inputInt() {
		
		boolean aceptable=true;
		int x=0;
		
		while(aceptable) {
			
			try {
				
				x=Integer.valueOf(input.nextLine());
				aceptable=false;
				
			}
			catch(InputMismatchException e) {
				
				System.out.println("Please, introduce a correct number");
				input.next();
				aceptable=true;
				
			}
		}
		return x;
	}
		
	/**
	 * Método para limpiar la pantalla tras el saludo y hacer esperar al usuario como si estuviéramos cargando un programa. 
	 * Tiene que parecer que es un programa hardcore, que si no nos pagan menos.
	 */
	public void waitAndCleanAndInitialize() {
		
		try {
			
			Thread.sleep(3000);
			
		} catch (InterruptedException e) {}
		
		System.out.println("\033[H\033[2J");
		
		System.out.println("Por favor, indique las plazas para no discapacitados (hay que ser inclusivos) del párking:");
		
		int norm=inputInt();
		
		System.out.println("Por favor, indique las plazas para personas discapacitadas del párking:");
		
		int disc=inputInt();
		
		parking=new ParkingJose(norm, disc);
		
		System.out.println("\033[H\033[2J");
		
		System.out.println("¡Gracias!\n\nCargando aplicación...");
		
		try {
			
			Thread.sleep(1000);
			
		} catch (InterruptedException e) {}
		
	}
	
	/**
	 * Método para mostrar el menú con la parte seleccionada que pertoque.
	 * @param hlight
	 */
	public void displayMenu(int hlight) {
		
		System.out.println("\033[H\033[2J");
		
		switch(hlight) {
		
		case 1:
			
			System.out.println("\033[H\033[2J");
			hlighted=1;
			System.out.println(" _______________ \n"+
			                   "|                                             |\n"+
			                   "|\033[1;41m      \033[1;34mOmplir parking a partir de fitxer      \033[0m|\n"+
							   "|                Entrar Cotxe                 |\n"+
			                   "|          Entrar Cotxe Discapacitat          |\n"+
							   "|                 Surtir Cotxe                |\n"+
			                   "|          Surtir Cotxe Discapacitat          |\n"+
							   "|   Guardar llistat de matricules en fitxer   |\n"+
			                   "|                   Sortir                    |\n"+
							   "|_______________|\n\n[W] mover hacia arriba\n[S] mover hacia abajo\n[Y] aceptar");
			
			break;
			
		case 2:
			
			System.out.println("\033[H\033[2J");
			hlighted=2;
			System.out.println(" _______________ \n"+
	                   "|                                             |\n"+
	                   "|      Omplir parking a partir de fitxer      |\n"+
					   "|\033[1;41m                \033[1;34mEntrar Cotxe                 \033[0m|\n"+
	                   "|          Entrar Cotxe Discapacitat          |\n"+
					   "|                 Surtir Cotxe                |\n"+
	                   "|          Surtir Cotxe Discapacitat          |\n"+
					   "|   Guardar llistat de matricules en fitxer   |\n"+
	                   "|                   Sortir                    |\n"+
					   "|_______________|\n\n[W] mover hacia arriba\n[S] mover hacia abajo\n[Y] aceptar");
			
			break;
			
		case 3:
			
			System.out.println("\033[H\033[2J");
			hlighted=3;
			System.out.println(" _______________ \n"+
	                   "|                                             |\n"+
	                   "|      Omplir parking a partir de fitxer      |\n"+
					   "|                Entrar Cotxe                 |\n"+
	                   "|\033[1;41m          \033[1;34mEntrar Cotxe Discapacitat          \033[0m|\n"+
					   "|                 Surtir Cotxe                |\n"+
	                   "|          Surtir Cotxe Discapacitat          |\n"+
					   "|   Guardar llistat de matricules en fitxer   |\n"+
	                   "|                   Sortir                    |\n"+
					   "|_______________|\n\n[W] mover hacia arriba\n[S] mover hacia abajo\n[Y] aceptar");
			
			break;
			
		case 4:
			
			System.out.println("\033[H\033[2J");
			hlighted=4;
			System.out.println(" _______________ \n"+
	                   "|                                             |\n"+
	                   "|      Omplir parking a partir de fitxer      |\n"+
					   "|                Entrar Cotxe                 |\n"+
	                   "|          Entrar Cotxe Discapacitat          |\n"+
					   "|\033[1;41m                 \033[1;34mSurtir Cotxe                \033[0m|\n"+
	                   "|          Surtir Cotxe Discapacitat          |\n"+
					   "|   Guardar llistat de matricules en fitxer   |\n"+
	                   "|                   Sortir                    |\n"+
					   "|_______________|\n\n[W] mover hacia arriba\n[S] mover hacia abajo\n[Y] aceptar");
	
			break;
			
		case 5:
			
			System.out.println("\033[H\033[2J");
			hlighted=5;
			System.out.println(" _______________ \n"+
	                   "|                                             |\n"+
	                   "|      Omplir parking a partir de fitxer      |\n"+
					   "|                Entrar Cotxe                 |\n"+
	                   "|          Entrar Cotxe Discapacitat          |\n"+
					   "|                 Surtir Cotxe                |\n"+
	                   "|\033[1;41m          \033[1;34mSurtir Cotxe Discapacitat          \033[0m|\n"+
					   "|   Guardar llistat de matricules en fitxer   |\n"+
	                   "|                   Sortir                    |\n"+
					   "|_______________|\n\n[W] mover hacia arriba\n[S] mover hacia abajo\n[Y] aceptar");
	
			break;
	
		case 6:
			
			System.out.println("\033[H\033[2J");
			hlighted=6;
			System.out.println(" _______________ \n"+
	                   "|                                             |\n"+
	                   "|      Omplir parking a partir de fitxer      |\n"+
					   "|                Entrar Cotxe                 |\n"+
	                   "|          Entrar Cotxe Discapacitat          |\n"+
					   "|                 Surtir Cotxe                |\n"+
	                   "|          Surtir Cotxe Discapacitat          |\n"+
					   "|\033[1;41m   \033[1;34mGuardar llistat de matricules en fitxer   \033[0m|\n"+
	                   "|                   Sortir                    |\n"+
					   "|_______________|\n\n[W] mover hacia arriba\n[S] mover hacia abajo\n[Y] aceptar");
	
			break;
	
		case 7:
			
			System.out.println("\033[H\033[2J");
			hlighted=7;
			System.out.println(" _______________ \n"+
	                   "|                                             |\n"+
	                   "|      Omplir parking a partir de fitxer      |\n"+
					   "|                Entrar Cotxe                 |\n"+
	                   "|          Entrar Cotxe Discapacitat          |\n"+
					   "|                 Surtir Cotxe                |\n"+
	                   "|          Surtir Cotxe Discapacitat          |\n"+
					   "|   Guardar llistat de matricules en fitxer   |\n"+
	                   "|\033[1;41m                   \033[1;34mSortir                    \033[0m|\n"+
					   "|_______________|\n\n[W] mover hacia arriba\n[S] mover hacia abajo\n[Y] aceptar");
	
			break;
	
			default:
				
				//Pantalla parpadeante de error de input.
				
				for(byte x=0;x<3;x++) {
				
					System.out.println("\033[H\033[2J");
					System.out.println(" _______________ \n"+
			                   "|                                             |\n"+
			                   "|      Omplir parking a partir de fitxer      |\n"+
							   "|                Entrar Cotxe                 |\n"+
			                   "|          Entrar Cotxe Discapacitat          |\n"+
							   "|                 Surtir Cotxe                |\n"+
			                   "|          Surtir Cotxe Discapacitat          |\n"+
							   "|   Guardar llistat de matricules en fitxer   |\n"+
			                   "|                   Sortir                    |\n"+
							   "|_______________|\n\n[W] mover hacia arriba\n[S] mover hacia abajo\n[Y] aceptar");
					
					try {
						
						Thread.sleep(100);
						
						System.out.println("\033[H\033[2J");
					
					System.out.println(" _______________ \n"+
			                   "|                                             |\n"+
			                   "|\033[1;41m      \033[1;34mOmplir parking a partir de fitxer      \033[0m|\n"+
			                   "|\033[1;41m                \033[1;34mEntrar Cotxe                 \033[0m|\n"+
							   "|\033[1;41m          \033[1;34mEntrar Cotxe Discapacitat          \033[0m|\n"+
			                   "|\033[1;41m                 \033[1;34mSurtir Cotxe                \033[0m|\n"+
							   "|\033[1;41m          \033[1;34mSurtir Cotxe Discapacitat          \033[0m|\n"+
			                   "|\033[1;41m   \033[1;34mGuardar llistat de matricules en fitxer   \033[0m|\n"+
							   "|\033[1;41m                   \033[1;34mSortir                    \033[0m|\n"+
							   "|_______________|\n\n[W] mover hacia arriba\n[S] mover hacia abajo\n[Y] aceptar");
					
					Thread.sleep(100);
					
					} catch (InterruptedException e) {}
				
				}
		
		}
		
	}

	/**
	 * Método que, pasándole el valor numérico de la opción elegida, ejecuta las acciones pertinentes en la clase párking.
	 * @param sel
	 */
	public void executeSelection(int sel) {
		
		int plaza;
		
		switch(sel) {
		
		case 1:
			
			System.out.println("\033[H\033[2J");
			System.out.println("Por favor, introduzca la dirección del fichero:");
			try {
				
				parking.llegirMatricules(input.nextLine());
				System.out.println("\033[H\033[2J");
				displayMenu(hlighted);
				
			} catch (Exception e) {
				
				System.out.println("ERROR: Mensaje del gestor del párking: \n"+e+"\n"+
				"Si han habido vehículos introducidos previos al fallo (no es un fallo de IO), éstos permanecerán en el sistema.");
				
				try {
					Thread.sleep(2500);
					System.out.println("\033[H\033[2J");
					displayMenu(hlighted);
				} catch (InterruptedException e1) {}
				
			}
			
			break;
			
		case 2:
			
			System.out.println("\033[H\033[2J");
			System.out.println("Por favor, introduzca la matrícula del vehículo: ");
			
			try {
				
				plaza=parking.entraCotxe(input.nextLine());
				System.out.println("La plaza donde ha ingresado el coche es :"+plaza);
				Thread.sleep(2500);
				System.out.println("\033[H\033[2J");
				displayMenu(hlighted);
				
			} catch (Exception e) {
				
				System.out.println("ERROR: Mensaje del gestor del párking: \n"+e+"\n");
				
				try {
					Thread.sleep(2500);
					System.out.println("\033[H\033[2J");
					displayMenu(hlighted);
				} catch (InterruptedException e1) {}
				
			}
			
			break;
			
		case 3:
			
			System.out.println("\033[H\033[2J");
			System.out.println("Por favor, introduzca la matrícula del vehículo: ");
			
			try {
				
				plaza=parking.entraCotxeDiscapacitat(input.nextLine());
				
				System.out.println("La plaza donde ha ingresado el coche es :"+plaza);
				Thread.sleep(2500);
				System.out.println("\033[H\033[2J");
				displayMenu(hlighted);
				
			} catch (Exception e) {
				
				System.out.println("ERROR: Mensaje del gestor del párking: \n"+e+"\n");
				
				try {
					Thread.sleep(2500);
					System.out.println("\033[H\033[2J");
					displayMenu(hlighted);
				} catch (InterruptedException e1) {}
				
			}
			
			break;
			
		case 4:
			
			System.out.println("\033[H\033[2J");
			System.out.println("Por favor, introduzca la matrícula del vehículo que quiere sacar: ");

			try {
				
				parking.surtCotxe(input.nextLine());
				
				System.out.println("El coche ha salido del párking.");
				Thread.sleep(2500);
				System.out.println("\033[H\033[2J");
				displayMenu(hlighted);
				
			} catch (Exception e) {
				
				System.out.println("ERROR: Mensaje del gestor del párking: \n"+e+"\n");
				
				try {
					Thread.sleep(2500);
					System.out.println("\033[H\033[2J");
					displayMenu(hlighted);
				} catch (InterruptedException e1) {}
				
			}
			
			break;
			
		case 5:
			
			System.out.println("\033[H\033[2J");
			System.out.println("Por favor, introduzca la matrícula del vehículo para discapacitados que quiere sacar: ");

			try {
				
				parking.surtCotxeDiscapacitats(input.nextLine());
				
				System.out.println("El coche ha salido del párking.");
				Thread.sleep(2500);
				System.out.println("\033[H\033[2J");
				displayMenu(hlighted);
				
			} catch (Exception e) {
				
				System.out.println("ERROR: Mensaje del gestor del párking: \n"+e+"\n");
				
				try {
					Thread.sleep(2500);
					System.out.println("\033[H\033[2J");
					displayMenu(hlighted);
				} catch (InterruptedException e1) {}
				
			}
			
			break;
			
		case 6:
			
			System.out.println("\033[H\033[2J");
			System.out.println("Por favor, introduzca la dirección donde quiere guardar el fichero: ");
			
			try {
				
				parking.guardarMatricules(input.nextLine());
				System.out.println("\033[H\033[2J");
				displayMenu(hlighted);
				
			} catch(NullPointerException y) {
				System.out.println("\033[H\033[2J");
				displayMenu(hlighted);
			}
			catch (Exception e) {
				
				System.out.println("ERROR: Mensaje del gestor del párking: \n"+e+"\n");
				
				try {
					Thread.sleep(2500);
					System.out.println("\033[H\033[2J");
					displayMenu(hlighted);
				} catch (InterruptedException e1) {}
				
			}
			
			break;
			
		case 7:
			
			System.out.println("\033[H\033[2J");
			System.out.println("¡GRACIAS POR USAR NUESTRO SERVICIO!");
			
			finish=true;
			
			break;
			
			default:;
		
		}
		
	}
	
	/**
	 * Método para movernos o seleccionar opciones en el menú. 
	 * La primera opción era que no hiciera falta pulsar enter para la navegación entre las opciones, 
	 * pero me fue imposible comprender el uso de los KeyListener y demás, así que he hecho un híbrido.
	 * @param key
	 */
	public void selection(String key) {
		
		switch(key.toUpperCase()) {
		
		case "W":
			
			if(hlighted>1 && hlighted <8) {
				
				displayMenu(hlighted-1);
				
			}
			
			else {
				
				if(hlighted==1) {
					
					displayMenu(7);
					
				}
				
				else {
					
					displayMenu(0);
					displayMenu(hlighted);
					
				}
				
			}
			
			break;
			
		case "S":
		
			if(hlighted>0 && hlighted <7) {
				
				displayMenu(hlighted+1);
				
			}
			
			else {
				
				if(hlighted==7) {
					
					displayMenu(1);
					
				}
				
				else {
					
					displayMenu(0);
					displayMenu(hlighted);
					
				}
				
			}
			
			break;
			
		case "Y":
			
			if(hlighted>0 && hlighted <8) {
				
				executeSelection(hlighted);
				
			}
			
			else {
				
				displayMenu(0);
				displayMenu(hlighted);
				
			}
			
			break;
			
		default:
			
			displayMenu(0);
			displayMenu(hlighted);
		
		}
		
	}
	
	/**
	 * Método que agrupa los demás y buclea el menú.
	 */
	public void menu() {
		
		
		System.out.println(welcome());
		waitAndCleanAndInitialize();
		displayMenu(1);
		
		while(finish==false) {
			
			selection(input.nextLine());
			
		}
		
		closeScanner();
		
	}
	
	public static void main(String[] args) {
		
		PRU04E05ParkingTest_JoseMiguel_Pascual test=new PRU04E05ParkingTest_JoseMiguel_Pascual();
		test.menu();

	}

}
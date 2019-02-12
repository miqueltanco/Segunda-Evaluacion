package PRU04E05pruebasfuerapackage;

import PRU04E05.PRU04E05Parking_Miquel_Tanco;
import PRU04E05.PRU04E05Parking_Miquel_Tanco.TipusPlacesParking;

import java.util.Scanner;
public class testivan {

    private static Scanner sc = new Scanner(System.in).useDelimiter("\\n");
    private static PRU04E05Parking_Miquel_Tanco parking_ivan_cabellos = crearParking();

    public static void main(String[] args) {

        int numMenu = menu();
        while (numMenu < 8){
            menuFunctions(numMenu);
            numMenu = menu();
        }

        System.out.println("Nos vemos pronto en Palma's Parking 24h");


    }

    private static PRU04E05Parking_Miquel_Tanco crearParking(){
        System.out.println("Primero de todo tienes que crear un parking, o si quieres puedes usar uno predeterminado");
        System.out.println("Si quieres crear uno dime cuantas plazas No_Discapacitat/minusvalidos quieres, si quieres uno " +
                "predeterminado introduce 'default'");

        String controlParking = sc.next().toUpperCase();

        try {

            if ("DEFAULT".equals(controlParking)) {
                return new PRU04E05Parking_Miquel_Tanco(100, 5);
            } else {
                int numPlazasNormales = Integer.parseInt(controlParking);
                int numPlazasDiscapacitados = sc.nextInt();
                return new PRU04E05Parking_Miquel_Tanco(numPlazasNormales, numPlazasDiscapacitados);
            }

        } catch (Exception e){
            System.err.println();
            System.out.println("No se ha podido crear el parking, vuelve a intentarlo");
            crearParking();
        }

        return null;
    }

    private static int menu(){

        System.out.println(" ---------   BIENVENIDOS A PALMA'S PARKING  ---------");
        System.out.println("|====================================================|");
        System.out.println("|                                                    |");
        System.out.println("|        Dime que es lo que quieres hacer            |");
        System.out.println("| [1] Llenar el parking con un fichero de matriculas |");
        System.out.println("| [2] Meter un coche en el parking                   |");
        System.out.println("| [3] Meter un coche para discapacitados             |");
        System.out.println("| [4] Sacar coche del parking                        |");
        System.out.println("| [5] Sacar un coche de discapacitados del parking   |");
        System.out.println("| [6] Mostrar coches dentro del parking              |");
        System.out.println("| [7] Guardar las matr�culas del parking en fichero  |");
        System.out.println("|                                                    |");
        System.out.println("| [8] Salir del men�                                 |");
        System.out.println("|                                                    |");
        System.out.println("|====================================================|");

        String controlMenu = sc.next();


        try {
            int numControl = Integer.parseInt(controlMenu);
            if (numControl >= 1 && numControl <= 9) {
                return numControl;
            } else throw new Exception();

        } catch (Exception e){
            System.out.println();
            System.out.println("Introduce el numero adecuado");
            menu();
        }

        return -1;

    }

    private static void menuFunctions (int numControl){

        try {

            switch (numControl){
                case 1:
                    System.out.println("Has seleccionado meter las matriculas por fichero");
                    System.out.println("Dime el path del fichero donde estan las matriculas: ");
                    String ficheroMatriculas = sc.next();

                    try {
                        parking_ivan_cabellos.llegirMatricules(ficheroMatriculas);
                        System.out.println("=================================");
                        System.out.println("Parece que funciono todo correcto");
                        System.out.println("=================================");
                    } catch (Exception e){
                        System.out.println("Algo no fue bien, vuelve a introducir el fichero, o bien 'menu' para voler atras: ");
                        System.out.println("==================================================================================");
                        String nuevoPath = sc.next();

                        if (nuevoPath.endsWith("menu")) break;
                        else parking_ivan_cabellos.llegirMatricules(nuevoPath);
                    }
                    
                    break;

                case 2:
                    System.out.println("Has seleccionado meter un coche en el parking");
                    System.out.println("==============================================================");
                    System.out.println("Dime la matricula del coche que ha entrado, 'menu' para volver");
                    String matriculaNueva = sc.next();
                    if (matriculaNueva.equals("menu")){
                        break;
                    } else meterCocheParking(matriculaNueva);
                    break;

                case 3:
                    System.out.println("Has seleccionado meter un coche en el parking de minusv�lidos");
                    System.out.println("==============================================================");
                    System.out.println("Dime la matricula del coche que ha entrado, 'menu' para volver");
                    String matriculaNuevaMinusvalidos = sc.next();

                    if (matriculaNuevaMinusvalidos.equals("menu")){
                        break;
                    } else meterCocheMinusvalidos(matriculaNuevaMinusvalidos);

                    break;

                case 4:
                    System.out.println("Has seleccionado sacar un coche del parking");
                    System.out.println("=============================================================");
                    System.out.println("Dime la matricula del coche que ha salido, 'menu' para volver");
                    String matriculaNuevaSacar = sc.next();

                    if (matriculaNuevaSacar.equals("menu")){
                        break;
                    } else sacarCocheParkingNormal(matriculaNuevaSacar);
                    break;

                case 5:
                    System.out.println("Has seleccionado sacar un coche del parking");
                    System.out.println("==============================================================");
                    System.out.println("Dime la matricula del coche que ha salido, 'menu' para volver:");
                    String matriculaNuevaSacarMinusvalido = sc.next();

                    if (matriculaNuevaSacarMinusvalido.equals("menu")){
                        break;
                    } else sacarCocheParkingMinusvalido(matriculaNuevaSacarMinusvalido);
                    break;

                case 6:

                    System.out.println("Dime si quieres ver el parking normal o de Discapacitat: ");
                    String tipoDeParking = sc.next();

                    switch (tipoDeParking){
                        case "normal":
                            System.out.println("===========================================");
                            System.out.println("   COCHES DENTRO DEL PARKING AHORA MISMO");
                            System.out.println("         Ahora mismo hay: " + parking_ivan_cabellos.getPlacesOcupades(TipusPlacesParking.No_Discapacitat));
                            System.out.println("         Quedan: " + parking_ivan_cabellos.getPlacesLliures(TipusPlacesParking.No_Discapacitat));

                            System.out.println("===========================================");
                            System.out.println();
                            break;

                        case "Discapacitat":
                            System.out.println("===========================================");
                            System.out.println("   COCHES DENTRO DEL PARKING AHORA MISMO");
                            System.out.println("         Ahora mismo hay: " + parking_ivan_cabellos.getPlacesOcupades(TipusPlacesParking.Discapacitat));
                            System.out.println("         Quedan: " + parking_ivan_cabellos.getPlacesLliures(TipusPlacesParking.Discapacitat));
                            System.out.println("===========================================");
                            System.out.println();
                            break;
                    }
                    break;

                case 7:
                    System.out.println("Has seleccionado meter las matriculas dentro de un fichero");
                    System.out.println("==========================================================");
                    System.out.println("Dime el 'path' o direcci�n del fichero con el nombre");

                    String pathGuardarMatriculas = sc.next();

                    try {
                        parking_ivan_cabellos.guardarMatricules(pathGuardarMatriculas);
                        System.out.println("============================");
                        System.out.println("Parece que fue todo correcto");
                        System.out.println("============================");
                    } catch (Exception e){
                        System.out.println("Algo no fue bien, vuelve a introducir el fichero: ");
                        String nuevoPathGuardar = sc.next();
                        parking_ivan_cabellos.guardarMatricules(nuevoPathGuardar);
                    }

            }

        } catch (Exception e){
            System.err.println();
        }


    }

    private static void meterCocheParking (String matricula){
        try {
            parking_ivan_cabellos.entraCotxe(matricula);
        } catch (Exception e){
            String matriculaCorrecta = sc.next();
            meterCocheParking(matriculaCorrecta);
        }
    }

    private static void meterCocheMinusvalidos (String matricula){
        try {
            parking_ivan_cabellos.entraCotxeDiscapacitat(matricula);
        } catch (Exception e){
            System.err.println();
            System.out.println("Introduce la nueva matricula: ");
            String matriculaCorrecta = sc.next();
            meterCocheMinusvalidos(matriculaCorrecta);
        }
    }

    private static void sacarCocheParkingNormal (String matricula){
        try {
            parking_ivan_cabellos.surtCotxe(matricula);
        } catch (Exception e){
            System.err.println();
            System.out.println("No se ha podido encontrar el coche, vuelve a introducir la matricula:");
            String nuevaMatricula = sc.next();
            sacarCocheParkingNormal(nuevaMatricula);
        }
    }
    private static void sacarCocheParkingMinusvalido (String matricula){
        try {
            parking_ivan_cabellos.surtCotxeDiscapacitats(matricula);
        } catch (Exception e){
            System.err.println();
            System.out.println("No se ha podido encontrar el coche, vuelve a introducir la matricula:");
            String nuevaMatricula = sc.next();
            sacarCocheParkingNormal(nuevaMatricula);
        }
    }

}
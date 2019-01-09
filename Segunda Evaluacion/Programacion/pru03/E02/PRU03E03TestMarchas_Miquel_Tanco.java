package pru03.E02;

public class PRU03E03TestMarchas_Miquel_Tanco {

	
	public static void main(String[] args) throws Exception {

		PRU03E03Marchas_Miquel_Tanco Coche1;
		Coche1 = new PRU03E03Marchas_Miquel_Tanco("Nissan","Silvia S14 motor swap RB26DETT",TipusCanvi.CanviManual);
		PRU03E03Marchas_Miquel_Tanco Coche2;
		Coche2 = new PRU03E03Marchas_Miquel_Tanco("Audi","A3",TipusCanvi.CanviAutomatic);
		
	Coche1.CanviarMarxaManual("Primera");
	Coche1.CanviarMarxaManual("PuntoMuerto");
	Coche1.CanviarMarxaManual("MarchaAtras");
	Coche1.CanviarMarxaManual("PuntoMuerto");
	Coche1.CanviarMarxaManual("Primera");
	Coche1.CanviarMarxaManual("Segunda");
	Coche1.CanviarMarxaManual("Tercera");
	Coche1.CanviarMarxaManual("Cuarta");
	Coche1.CanviarMarxaManual("Quinta");
	Coche1.CanviarMarxaManual("Sexta");
	/*  SALTARIA EXCEPTION CON: 
	*	Coche1.CanviarMarxaManual("Sexta"); 
	**/
	System.out.println(Coche1.CambioM);
	System.out.println(" ");
	Coche2.CanviarMarxaAuto("MarchaDelante");
	System.out.println(Coche2.CambioA);
	Coche2.CanviarMarxaAuto("Parking");
	System.out.println(Coche2.CambioA);
	/*  SALTARIA EXCEPTION CON: 
	*	Coche2.CanviarMarxaAuto("Parking"); 
	**/
	
	}
}

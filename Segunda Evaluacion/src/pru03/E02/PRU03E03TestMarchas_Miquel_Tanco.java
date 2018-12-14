package pru03.E02;

public class PRU03E03TestMarchas_Miquel_Tanco {

	
	public static void main(String[] args) throws Exception {

		PRU03E03Marchas_Miquel_Tanco Coche1;
		Coche1 = new PRU03E03Marchas_Miquel_Tanco("Nissan","Silvia S14 motor swap RB26DETT",TipusCanvi.CanviManual);
		PRU03E03Marchas_Miquel_Tanco Coche2;
		Coche2 = new PRU03E03Marchas_Miquel_Tanco("Audi","A3",TipusCanvi.CanviAutomatic);
		
	Coche1.CanviarMarxaManual("Primera");
	System.out.println(Coche1.CambioM);
	}

}

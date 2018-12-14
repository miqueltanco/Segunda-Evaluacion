package pru03.E02;

public class PRU03E03Marchas_Miquel_Tanco extends PRU03E03Cotxe_Miquel_Tanco {
	
	//CONSTRUCTOR
	public PRU03E03Marchas_Miquel_Tanco(String marca, String model, TipusCanvi tipuscanvi) {
		super(marca, model, tipuscanvi);
	}
	
	//LO HE USADO ASI PARA TENER UN NOMBRE DIFERENTE, QUE SEA MAS CLARO
	static TipusCanvi CambioCocheManual = TipusCanvi.CanviManual;
	static TipusCanvi CambioCocheAuto = TipusCanvi.CanviAutomatic;
	
	//ENUMERACION DE LAS POSIBLES MARCHAS QUE TIENE UN CAMBIO MANUAL
	public enum CambioManual {
		MarchaAtras,
		PrimeraMarcha,
		SegundaMarcha,
		TerceraMarcha,
		CuartaMarcha,
		QuintaMarcha,
		SextaMarcha;
	}
	
	//ENUMERACION DE LAS POSIBLES MARCHAS QUE TIENE UN CAMBIO AUTOMATICO
	public enum CambioAutomatico {
		Parking,
		MarchaAtras,
		MarchaDelante;
	}
	
	//METODO DE CAMBIO DE MARCHA EN MANUAL
	public CambioManual CanviarMarxaManual(String Orden) {
		return null;
	}
	//METODO CAMBIO DE MARCHA EN AUTOMATICO
	public CambioAutomatico CanviarMarxaAuto(String Orden) {
		return null;
	} 
	
	
	public static void main(String[] args) {

		PRU03E03Marchas_Miquel_Tanco Coche1;
		Coche1 = new PRU03E03Marchas_Miquel_Tanco("Nissan","Silvia S14 motor swap RB26DETT",CambioCocheManual);
		PRU03E03Marchas_Miquel_Tanco Coche2;
		Coche2 = new PRU03E03Marchas_Miquel_Tanco("Audi","A3",CambioCocheAuto);
		
		
	}

}

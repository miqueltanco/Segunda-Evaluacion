package pru03.E02;

public class PRU03E03Marchas_Miquel_Tanco extends PRU03E03Cotxe_Miquel_Tanco {
	
	//CONSTRUCTOR
	public PRU03E03Marchas_Miquel_Tanco(String marca, String model, TipusCanvi tipuscanvi) {
		super(marca, model, tipuscanvi);
		if (tipuscanvi.equals(tipuscanvi.CanviManual)) {
			CambioM = CambioManual.Neutral;
		}
		if (tipuscanvi.equals(tipuscanvi.CanviAutomatic)) {
			CambioA = CambioAutomatico.Parking;
		}
	}
	
	CambioManual CambioM = null;
	CambioAutomatico CambioA = null;
	
	//ENUMERACION DE LAS POSIBLES MARCHAS QUE TIENE UN CAMBIO MANUAL
	public enum CambioManual {
		MarchaAtras,
		Neutral,
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
	public void CanviarMarxaManual(String Orden) throws Exception {
		if (Orden=="Primera") {
			if (CambioM.equals(CambioM.Neutral)) {
			 CambioM = CambioM.PrimeraMarcha;
		}
			else throw new Exception("No puedes saltar marchas");
	}	
}
	
	//METODO CAMBIO DE MARCHA EN AUTOMATICO
	public CambioAutomatico CanviarMarxaAuto(String Orden) {
		return null;
	} 
}

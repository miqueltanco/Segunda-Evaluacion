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
	
	CambioManual CambioM;
	CambioAutomatico CambioA;
	
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
		if (Orden=="MarchaAtras") {
			if (CambioM.equals(CambioM.Neutral)) {
			 CambioM = CambioM.MarchaAtras;
		}
			else throw new Exception("No puedes saltar marchas o estas en la misma marcha");
	}
		if (Orden=="PuntoMuerto") {
			if (CambioM.equals(CambioM.MarchaAtras)||CambioM.equals(CambioM.PrimeraMarcha)) {
			 CambioM = CambioM.Neutral;
		}
			else throw new Exception("No puedes saltar marchas o estas en la misma marcha");
	}
		if (Orden=="Primera") {
			if (CambioM.equals(CambioM.Neutral)||CambioM.equals(CambioM.SegundaMarcha)) {
			 CambioM = CambioM.PrimeraMarcha;
		}
			else throw new Exception("No puedes saltar marchas o estas en la misma marcha");
	}
		if (Orden=="Segunda") {
			if (CambioM.equals(CambioM.PrimeraMarcha)||CambioM.equals(CambioM.TerceraMarcha)) {
			 CambioM = CambioM.SegundaMarcha;
		}
			else throw new Exception("No puedes saltar marchas o estas en la misma marcha");
	}
		if (Orden=="Tercera") {
			if (CambioM.equals(CambioM.SegundaMarcha)||CambioM.equals(CambioM.CuartaMarcha)) {
			 CambioM = CambioM.TerceraMarcha;
		}
			else throw new Exception("No puedes saltar marchas o estas en la misma marcha");
	}
		if (Orden=="Cuarta") {
			if (CambioM.equals(CambioM.TerceraMarcha)||CambioM.equals(CambioM.QuintaMarcha)) {
			 CambioM = CambioM.CuartaMarcha;
		}
			else throw new Exception("No puedes saltar marchas o estas en la misma marcha");
	}
		if (Orden=="Quinta") {
			if (CambioM.equals(CambioM.CuartaMarcha)||CambioM.equals(CambioM.SextaMarcha)) {
			 CambioM = CambioM.QuintaMarcha;
		}
			else throw new Exception("No puedes saltar marchas o estas en la misma marcha");
	}
		if (Orden=="Sexta") {
			if (CambioM.equals(CambioM.QuintaMarcha)) {
			 CambioM = CambioM.SextaMarcha;
		}
			else throw new Exception("No puedes saltar marchas o estas en la misma marcha");
	}
		
}
	
	//METODO CAMBIO DE MARCHA EN AUTOMATICO
	public void CanviarMarxaAuto(String Orden) throws Exception{
		if (Orden=="Parking") {
			if (CambioA.equals(CambioA.MarchaAtras)||CambioA.equals(CambioA.MarchaDelante)) {
			 CambioA = CambioA.Parking;
			}
			else throw new Exception("Ya estas en Parking");
		}
		if (Orden=="MarchaDelante") {
			if (CambioA.equals(CambioA.Parking)||CambioA.equals(CambioA.MarchaAtras)) {
			CambioA = CambioA.MarchaDelante;
			}
		}
		if (Orden=="MarchaAtras") {
			if (CambioA.equals(CambioA.Parking)||CambioA.equals(CambioA.MarchaDelante)) {
			CambioA = CambioA.MarchaAtras;
			}
		} 
	}
}
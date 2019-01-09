package PRU03E04;

public class PRU03E04Temps_Miquel_Tanco {
	
	int hora;
	int minuto;
	int segundo;
	
	//CONSTRUCTOR
	public PRU03E04Temps_Miquel_Tanco(int hora, int minuto, int segundo) {
		super();
		this.hora = hora;
		this.minuto = minuto;
		this.segundo = segundo;
	}
	
	//METODO TOSTRING
	@Override
	public String toString() {
		return "Son las " + hora + "h " + minuto + "m " + segundo + "s.";
	}


	//METODO SUMAR TIEMPO
	public void SumaTemps(int h, int m, int s) {
		
		int horasuma = h*3600;
		int minsuma = m*60;
		int totaltiemposuma = horasuma+minsuma+s;
		
		int converhora = hora*3600;
		int convermin = minuto*60;
		int totaltiempo = convermin+converhora+segundo;
		
		int segundostotales = totaltiemposuma+totaltiempo;
		
		hora = segundostotales/3600;
		minuto =  (segundostotales % 3600)/60;
		segundo = segundostotales % 60;
	}
	
	//METODO RESTAR TIEMPO
	public void RestaTemps(int h, int m, int s) throws Exception {
		
		int horasuma = h*3600;
		int minsuma = m*60;
		int totaltiemposuma = horasuma+minsuma+s;
		
		int converhora = hora*3600;
		int convermin = minuto*60;
		int totaltiempo = convermin+converhora+segundo;
		
		int segundostotales = totaltiempo-totaltiemposuma;
		
		if (segundostotales<0) {
			throw new Exception ("No puedes restar más tiempo");
			}
		
		hora = segundostotales/3600;
		minuto =  (segundostotales % 3600)/60;
		segundo = segundostotales % 60;
	}
}

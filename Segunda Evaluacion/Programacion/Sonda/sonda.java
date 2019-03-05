package Sonda;

import java.util.Date;

public abstract class sonda {
	public boolean enregistrarTemperatura(String IP, String ubicacio, double valor) {
		return false;
	}
	
	public double obtenirTemperatura(String ubicacio, Date data) {
		return 0;
	}
	
}

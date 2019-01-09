package pru03.E02;

public class PRU03E03Cotxe_Miquel_Tanco extends CotxeAbstracte implements InterfaceCotxe {
	
	public PRU03E03Cotxe_Miquel_Tanco(String marca, String model, TipusCanvi tipuscanvi) {
		super(marca, model, tipuscanvi);
	}

	//INSTANCIAR ESTATMOTORCOTXE
	EstatsMotorCotxe estadoMotor = EstatsMotorCotxe.Aturat;
	
	@Override //METODO ARRANCA COCHE
	public void arrancarMotor() throws Exception {
		if (estadoMotor.equals(EstatsMotorCotxe.Aturat)) {
			estadoMotor = EstatsMotorCotxe.EnMarxa;
		}
		else throw new Exception ("El coche ya esta arrancado.");
	}

	@Override //METODO COMPROBAR SI EL MOTOR ESTA ARRANCADO O NO
	public EstatsMotorCotxe comprovaMotor() {
		if (estadoMotor.equals(EstatsMotorCotxe.EnMarxa)) {
			return EstatsMotorCotxe.EnMarxa;
		}
		else return EstatsMotorCotxe.Aturat;
	}

	@Override //METODO CALCULAR REVOLUCIONES ALEATORIAS ENTRE 1 Y 6500
	public int getRevolucions() {
		if (estadoMotor.equals(EstatsMotorCotxe.EnMarxa)) {
		double rev;
		rev = Math.random()*6500+1;
		int revoluciones = (int)rev;
		return revoluciones;
		}
		else return 0;
	}

	@Override //METODO APAGAR COCHE
	public void aturarMotor() throws Exception {
		if (estadoMotor.equals(EstatsMotorCotxe.EnMarxa)) {
			estadoMotor = EstatsMotorCotxe.Aturat;
		}
		else throw new Exception ("El coche ya esta apagado.");

	}
}

package pru03.E02;

public class PRU03E03Cotxe_Miquel_Tanco extends CotxeAbstracte implements InterfaceCotxe {
	
	//CONSTRUCTOR
	public PRU03E03Cotxe_Miquel_Tanco(String marca, String model, TipusCanvi tipuscanvi) {
		super(marca, model, tipuscanvi);
	}
	
	//INSTANCIAR ESTATMOTOR
	EstatsMotorCotxe estadoMotor = EstatsMotorCotxe.Aturat;
	
	@Override
	public void arrancarMotor() throws Exception {
		
	}

	@Override
	public EstatsMotorCotxe comprovaMotor() {
		return null;
	}

	@Override
	public int getRevolucions() {
		if (estadoMotor.equals(EstatsMotorCotxe.EnMarxa)) {
		double rev;
		rev = Math.random()*6500+1;
		int revoluciones = (int)rev;
		return revoluciones;
		}
		else return 0;
	}

	@Override
	public void aturarMotor() throws Exception {

	}

	public static void main(String[] args) {
		
		PRU03E03Cotxe_Miquel_Tanco Coche;
		Coche = new PRU03E03Cotxe_Miquel_Tanco("Nissan","S14", TipusCanvi.CanviManual);
		
		System.out.println(Coche.getRevolucions());
		
	}

}

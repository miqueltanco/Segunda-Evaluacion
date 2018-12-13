package pru03.E02;

public class PRU03E02TestCotxe_Miquel_Tanco extends PRU03E03Cotxe_Miquel_Tanco implements InterfaceCotxe {

	public PRU03E02TestCotxe_Miquel_Tanco(String marca, String model, TipusCanvi tipuscanvi) {
		super(marca, model, tipuscanvi);
	}

	public static void main(String[] args) throws Exception{

		PRU03E03Cotxe_Miquel_Tanco Coche;
		Coche = new PRU03E03Cotxe_Miquel_Tanco("Nissan","Silvia S14 motor swap RB26DETT",TipusCanvi.CanviManual);
		
		Coche.arrancarMotor();
		System.out.println(Coche.getRevolucions());
		System.out.println(Coche.comprovaMotor());
		Coche.aturarMotor();
		System.out.println(Coche.getRevolucions());
		Coche.aturarMotor();
	}
}

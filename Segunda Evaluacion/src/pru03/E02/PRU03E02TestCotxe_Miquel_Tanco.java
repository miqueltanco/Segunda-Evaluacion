package pru03.E02;

public class PRU03E02TestCotxe_Miquel_Tanco {
	public static void main(String[] args) throws Exception{

		PRU03E03Cotxe_Miquel_Tanco Coche;
		Coche = new PRU03E03Cotxe_Miquel_Tanco("Nissan","Silvia S14 motor swap RB26DETT",TipusCanvi.CanviManual);
		
		Coche.arrancarMotor();
		System.out.println("Las revoluciones del coche son: " + Coche.getRevolucions());
		System.out.println("El coche esta " + Coche.comprovaMotor());
		Coche.aturarMotor();
		System.out.println("Las revoluciones del coche son: " + Coche.getRevolucions());
		Coche.aturarMotor();
	}
}

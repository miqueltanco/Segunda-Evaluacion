package pru03e05;

public class PRU03E05Pizza_Miquel_Tanco {

	String tipus;
	String tamany;
	static int contadorDemanades=0;
	static int contadorPedides=0;
	
	public PRU03E05Pizza_Miquel_Tanco(String tipus, String tamany) {
		super();
		this.tipus = tipus;
		this.tamany = tamany;
		EstadoP = Estado.demanada;
		contadorDemanades++;
	}
	
	public enum Estado {
		demanada,
		servida;
	}
	
	Estado EstadoP;	
	
	public void sirve() throws Exception {
		if (EstadoP.equals(EstadoP.demanada)) {
			EstadoP = EstadoP.servida;
			contadorDemanades--;
			contadorPedides++;
			System.out.println("aquesta pizza ja sh'a servit");
		}
		else System.out.println("Aquesta pizza ja s'ha servit");
	}

	@Override
	public String toString() {
		return "Pizza " + tipus + " " + tamany + ", " + EstadoP;
	}

	public static int getTotalDemanades() {
		return contadorDemanades;
	}

	public static int getTotalServides() {
		return contadorPedides;
	}
}

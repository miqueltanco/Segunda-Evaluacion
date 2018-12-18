package pru03e05;

public class ComandesPizza {

	public static void main(String[] args) throws Exception {
		
		PRU03E05Pizza_Miquel_Tanco p1 = new PRU03E05Pizza_Miquel_Tanco("margarita","mitjana");
		PRU03E05Pizza_Miquel_Tanco p2 = new PRU03E05Pizza_Miquel_Tanco("funghi","familiar");
		p2.sirve();
		PRU03E05Pizza_Miquel_Tanco p3 = new PRU03E05Pizza_Miquel_Tanco("quatre formatges","mitjana");
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		p2.sirve();
		System.out.println("demanades: " + PRU03E05Pizza_Miquel_Tanco.getTotalDemanades());
		System.out.println("servides: " + PRU03E05Pizza_Miquel_Tanco.getTotalServides());
	}

}

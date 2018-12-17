package PRU03E04;

public class PRU03E04TempsTest_Miquel_Tanco {

	public static void main(String[] args) {
		
		PRU03E04Temps_Miquel_Tanco t; 
		t = new PRU03E04Temps_Miquel_Tanco(2,10,30);
		
		t.SumaTemps(1, 69, 25);	
		t.RestaTemps(3, 50, 25);
		System.out.println(t.toString());
		
	}
}

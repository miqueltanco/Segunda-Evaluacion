package PRU03E04;

public class PRU03E04TempsTest_Miquel_Tanco {

	public static void main(String[] args) throws Exception {
		
		PRU03E04Temps_Miquel_Tanco t; 
		t = new PRU03E04Temps_Miquel_Tanco(2,10,30);
		
		t.SumaTemps(1, 69, 25);	
		t.RestaTemps(2, 50, 61);
		System.out.println(t.toString());
		
	}
}

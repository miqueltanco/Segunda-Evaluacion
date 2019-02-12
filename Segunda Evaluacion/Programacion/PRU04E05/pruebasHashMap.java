package PRU04E05;

import java.util.HashMap;

public class pruebasHashMap {

	public static void main(String args[]) {
	
	HashMap<String, Integer> plazas = new HashMap<String, Integer>();
	HashMap<String, Integer> plazasDisc = new HashMap<String, Integer>();

	String matricula = "9999ZZZ";
	String matricula2 = "9994ZZZ";
	String matricula3 = "4994ZZZ";
	
	plazas.put(matricula, 0);
	plazas.put(matricula2, 2);
	plazas.put(matricula3, 3);
	
	if(plazas.containsKey(matricula2))
		plazas.remove(matricula3);
	
	System.out.println(plazas);

  }
}


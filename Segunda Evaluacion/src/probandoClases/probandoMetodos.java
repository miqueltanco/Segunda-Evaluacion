package probandoClases;

public class probandoMetodos {

	public void metodoFalse() {
		try {
			int e = 1;
			if(e == 1)
				throw new Exception ("Fallo false");
		}
		catch(Exception e) {
			e.getMessage();
		}
	}
	
	public static void main(String[] args) {

		probandoMetodos pm = new probandoMetodos();
		
		try {
			pm.metodoFalse();
		}
		catch (Exception e) {
			e.getMessage();
		}
		
	}
	
}

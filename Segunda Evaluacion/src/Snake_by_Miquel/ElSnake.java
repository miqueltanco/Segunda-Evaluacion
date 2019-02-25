package Snake_by_Miquel;

import javax.swing.JFrame;

public class ElSnake {

	private static ElSnake snake;
	private static final int ALTURA = 800, ANCHURA = 1200;
	
	private ElSnake() {
		JFrame frame = new JFrame();
		frame.setSize(ANCHURA, ALTURA);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
	
		snake = new ElSnake();
		
	}
	
}

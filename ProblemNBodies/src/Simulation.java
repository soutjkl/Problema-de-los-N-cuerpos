


import javax.swing.JFrame;

/**
 *
 * @author didier bernal
 */
public class Simulation {

	public static void main(String[] args) throws InterruptedException {

		JFrame frame = new JFrame("N bodies");
		ProblemNBody game = new ProblemNBody();

		frame.add(game);
		frame.setSize(800, 800);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		while (true) {
			game.moverplaneta();
			game.repaint();
			Thread.sleep(80);
		}

	}
}
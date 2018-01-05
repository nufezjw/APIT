import javax.swing.JFrame;
import java.awt.FlowLayout;

public class Colonisation {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		final int WIDTH = 600;
		final int HEIGHT = 600;

		frame.setSize(WIDTH,HEIGHT);

		ColonisationComponent c = new ColonisationComponent();

		frame.add(c);
		frame.setVisible(true);

		c.start();
	}
}
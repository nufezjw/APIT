import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
public class BubbleSortVisualiser {
	

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JFrame frame2 = new JFrame();

		final int WIDTH = 600;
		final int HEIGHT = 400;

		frame.setSize(WIDTH,HEIGHT);		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.setSize(WIDTH,HEIGHT);		
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		final BubbleSortComponent component = new BubbleSortComponent();
		frame.add(component);

		final SelectionSortComponent component2 = new SelectionSortComponent();
		frame2.add(component2);


		// final BubbleSortComponent component2 = new BubbleSortComponent();
		// panel.add(component2);

		frame.setVisible(true);
		frame2.setVisible(true);
		component.animate();
		component2.animate();
	}
}
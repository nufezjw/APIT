import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import java.util.Random;

public class SelectionSortComponent extends JComponent {
	private SelectionSorter selectionsort;
	public SelectionSortComponent() {
		Random r = new Random();
		int nData = 10;
		int[] val = new int[nData];
		for(int i=0;i<nData;i++) {
			val[i] = r.nextInt(300);
		}
		selectionsort = new SelectionSorter(val,this);
	}

	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D)g;
		selectionsort.draw(g2);
	}

	public void animate() {
		class AnimationRunner implements Runnable {
			public void run() {
				try {
					selectionsort.sort();
				}
				catch (InterruptedException e) {
					// Fall through
				}
			}
		}

		Runnable r = new AnimationRunner();
		Thread t = new Thread(r);
		t.start();
	}
}
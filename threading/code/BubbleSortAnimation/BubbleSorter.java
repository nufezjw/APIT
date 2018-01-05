import java.util.concurrent.locks.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import java.awt.geom.Line2D;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class BubbleSorter {
	private JComponent component;
	private ReentrantLock sortLock;
	private int[] values;
	private int position = -1;
	private int nSwaps = 1;
	Boolean swapped = false;
	private static final int DELAY = 50;
	public BubbleSorter(int[] values,JComponent aComponent) {
		component = aComponent;
		sortLock = new ReentrantLock();
		this.values = values;
	}

	public void sort() throws InterruptedException {
		while(nSwaps>0) {
			nSwaps = 0;
			for(int j=0;j<values.length-1;j++) {
				sortLock.lock();
				swapped = false;
				try {
					position = j;
				}finally {
					sortLock.unlock();
				}
				pause(2);
				sortLock.lock();
				try {
					if(values[j]>values[j+1]) {
						swapped = true;
						nSwaps++;
						int temp = values[j+1];
						values[j+1] = values[j];
						values[j] = temp;
					}
				}finally {
					sortLock.unlock();
				}
				pause(2);
			}
		}
	}

	public void pause(int steps) throws InterruptedException {
		component.repaint();
		Thread.sleep(steps * DELAY);
	}

	public void draw(Graphics2D g2) {
		sortLock.lock();
		try {
			int dX = component.getWidth() / (values.length+1);
			for(int i=0;i<values.length;i++) {
				if(i==position || i==position+1) {
					if(!swapped) {
						g2.setColor(Color.RED);
					}else{
						g2.setColor(Color.BLUE);
					}
				}else{
					g2.setColor(Color.BLACK);
				}
				g2.draw(new Line2D.Double(dX + i*dX,0,dX+i*dX,values[i]));
			}
		}finally {
			sortLock.unlock();
		}
	}
}
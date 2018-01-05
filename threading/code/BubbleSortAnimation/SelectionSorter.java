import java.util.concurrent.locks.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import java.awt.geom.Line2D;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class SelectionSorter {
	private JComponent component;
	private ReentrantLock sortLock;
	private int[] values;
	private int markedPosition = -1;
	private int alreadySorted = -1;
	Boolean swapped = false;
	private static final int DELAY = 50;
	public SelectionSorter(int[] values,JComponent aComponent) {
		component = aComponent;
		sortLock = new ReentrantLock();
		this.values = values;
	}

	public void sort() throws InterruptedException {
		for(int i=0;i<values.length-1;i++) {
			int minPos = minimumPosition(i);
			sortLock.lock();
			try {
					swap(minPos,i);
					alreadySorted = i;
			}finally {
				sortLock.unlock();
			}
			pause(2);
		}
	}
 	private int minimumPosition(int from) throws InterruptedException {
 		int minPos = from;
 		for(int i=from+1;i<values.length;i++) {
 			sortLock.lock();
 			try {
 				if (values[i]<values[minPos]) minPos = i;
 				markedPosition = i;
 			}finally {
 				sortLock.unlock();
 			}
 			pause(2);
 		}
 		return minPos;
 	}

 	private void swap(int i,int j) {
 		int temp = values[i];
 		values[i] = values[j];
 		values[j] = temp;
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
				if(i==markedPosition)
					g2.setColor(Color.RED);
				else if(i<=alreadySorted)
					g2.setColor(Color.BLUE);
				else
					g2.setColor(Color.BLACK);
				g2.draw(new Line2D.Double(dX + i*dX,0,dX+i*dX,values[i]));
			}
		}finally {
			sortLock.unlock();
		}
	}
}
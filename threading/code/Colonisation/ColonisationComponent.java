import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.util.Random;

public class ColonisationComponent extends JComponent {
	private final int width = 30; // Number of boxes
	private int[][] world;
	private Color[] cols;
	private int nPlayers;
	private ColonisationPlayer[] players;
	public ColonisationComponent() {
		world = new int[width][width];
		
		// Declare and invoke some player threads
		cols = new Color[9];
		cols[0] = Color.WHITE;
		cols[1] = Color.RED;
		cols[2] = Color.BLACK;
		cols[3] = Color.GREEN;
		cols[4] = Color.BLUE;
		cols[5] = Color.CYAN;
		cols[6] = Color.GRAY;
		cols[7] = Color.MAGENTA;


		nPlayers = 8;
		players = new ColonisationPlayer[nPlayers];
		
	}
	public void start() {
		ColonisationPlayer[] players = new ColonisationPlayer[nPlayers];
		Thread[] threads = new Thread[nPlayers];
		Random r = new Random();
		int placed = 0;
		while(placed < nPlayers) {
			int row = r.nextInt(width);
			int col = r.nextInt(width);
			if(world[row][col]==0) {
				world[row][col] = ++placed;
			}
			players[placed-1] = new ColonisationPlayer(placed,this,world,row,col);
		}
		for(int i=0;i<nPlayers;i++) {
			threads[i] = new Thread(players[i]);
			threads[i].start();
		}
		try {
			for(int i=0;i<nPlayers;i++) {
				threads[i].join();
			}
		}catch(InterruptedException e) {

		}
		int[] scores = computeScore();
		int maxScore = -1;
		int maxPos = -1;
		for(int i=0;i<nPlayers;i++) {
			System.out.println("Player: " + i + " " + scores[i+1]);
			if(scores[i+1]>maxScore) {
				maxScore = scores[i+1];
				maxPos = i;
			}
		}
		System.out.println("Winner is player " + maxPos);
		System.exit(0);
	}
	private int[] computeScore() {
		int[] scores = new int[nPlayers+1];
		for(int i=0;i<width;i++) {
			for(int j=0;j<width;j++) {
				scores[world[i][j]]++;
			}
		}
		return scores;
	}
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		drawMe(g2);
	}	
	private void drawMe(Graphics2D g2) {
		g2.setColor(Color.RED);

		int dX = this.getWidth() / width;
		for(int i=0;i<width;i++) {
			for(int j=0;j<width;j++) {
				g2.setColor(cols[world[i][j]]);
				g2.fillRect(i*dX,j*dX,dX,dX);
				g2.setColor(Color.BLACK);
				g2.drawRect(i*dX,j*dX,dX,dX);
			}
		}
	}
}
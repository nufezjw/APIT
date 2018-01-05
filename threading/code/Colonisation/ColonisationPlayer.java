import java.util.Random;

public class ColonisationPlayer implements Runnable {
	private int[][] world;
	private int id;
	private ColonisationComponent component;
	private Random r;
	private int width;
	private int rowPos;
	private int colPos;
	private int nStuck=0;
	public ColonisationPlayer(int id,ColonisationComponent component,int[][] world,int row,int col) {
		this.id = id;
		this.component = component;
		this.world = world;
		this.width = world[0].length;
		this.rowPos = row;
		this.colPos = col;
		r = new Random();
	}
	public void run() {
		try {
			while(nStuck<2) {
				synchronized(world) {
					// Colonise a neighbour
					int tryRow = rowPos + r.nextInt(3)-1;
					int tryCol = colPos + r.nextInt(3)-1;
					if(tryRow==-1) tryRow = width-1;
					if(tryRow==width) tryRow = 0;
					if(tryCol==-1) tryCol = width-1;
					if(tryCol==width) tryCol = 0;

					if(world[tryRow][tryCol]==0 || world[tryRow][tryCol] == id) {
						rowPos=tryRow;
						colPos=tryCol;
						world[rowPos][colPos] = id;	
						nStuck = 0;
					}else {
						nStuck++;
					}
					component.repaint();
				}
				Thread.sleep(100);
			}
		}catch(InterruptedException e) {
			// fall through
		}
		System.out.println("Player " + id + " is stuck");
	}
	
}
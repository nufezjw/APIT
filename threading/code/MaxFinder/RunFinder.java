import java.util.Random;
import java.util.Date;
public class RunFinder {

	private int nNodes;
	private int nData;
	private Double[][] data;
	public RunFinder(int n,int d) {
		nNodes = n;
		nData = d;
		data = new Double[nNodes][nData];
		Random r = new Random();
		for(int i=0;i<nNodes;i++) {
			for(int j=0;j<nData;j++) {
				data[i][j] = r.nextDouble();
			}
		}
	}
	public long[] go() {
		long startTime = System.currentTimeMillis();
		FindMax[] nodes = new FindMax[nNodes];
		for(int n=0;n<nNodes;n++) {
			nodes[n] = new FindMax(data[n]);
			Thread t = new Thread(nodes[n]);
			t.start();
		}
		// Wait for them all to finish
		Boolean finished = false;
		while(!finished) {
			int nFinished = 0;
			for(int n=0;n<nNodes;n++) {
				if(nodes[n].getFinished()) {
					nFinished++;
				}
			}
			if(nFinished == nNodes) {
				finished = true;
			}
		}
		long[] duration = new long[2];
		duration[0] = System.currentTimeMillis() - startTime;
		// for(int n=0;n<nNodes;n++) {
		// 	System.out.println("Node " + n + ", max " + nodes[n].getMax());
		// }
		// System.out.println("Duration " + duration);


		// Non-threaded version
		System.out.println();
		startTime = System.currentTimeMillis();
		FindMax[] nodes2 = new FindMax[nNodes];
		for(int n=0;n<nNodes;n++) {
			nodes[n] = new FindMax(data[n]);
			nodes[n].run();
		}
		duration[1] = System.currentTimeMillis() - startTime;
		// for(int n=0;n<nNodes;n++) {
		// 	System.out.println("Node " + n + ", max " + nodes[n].getMax());
		// }
		// System.out.println("Duration " + duration);
		return duration;
	}

	public static void main(String[] args) {
		
		int nNodes = Integer.parseInt(args[0]);
		int nData = Integer.parseInt(args[1]);
		RunFinder f1 = new RunFinder(nNodes,nData);
		long[] res = f1.go();
		System.out.println("Threaded: " + res[0] + ", unthreaded: " + res[1]);		

	}
}
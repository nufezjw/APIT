import java.util.Random;

public class ThreadSort {
	
	private int nNodes;
	private int dataSize;
	private Double[] allData;
	private Double[] originalData;


	public ThreadSort(int n,int d) {
		Random r = new Random();
		nNodes = n;
		dataSize = d;
		allData = new Double[dataSize];
		for(int i=0;i<dataSize;i++) {
			allData[i] = r.nextDouble();
		}
		originalData = allData.clone();

	}
	public void displayData() {
		for(int i=0;i<dataSize;i++) {
			System.out.println(allData[i]);
		}
	}
	public void resetData() {
		allData = originalData.clone();
	}
	public long sortAll() {
		long startTime = System.nanoTime();
		BubbleSort bs = new BubbleSort(allData);
		bs.run();
		return System.nanoTime() - startTime;
	}

	public long sortInParallel(boolean threaded) {
		long startTime = System.nanoTime();
		int nRows = dataSize/nNodes;
		Double[][] splitData = new Double[nNodes][nRows]; // Assumes exact split possible
		BubbleSort[] bs = new BubbleSort[nNodes];
		Thread[] t = new Thread[nNodes];
		for(int n = 0;n<nNodes;n++) {
			for(int r=0;r<nRows;r++) {
				splitData[n][r] = allData[n*nRows + r];
			}
			bs[n] = new BubbleSort(splitData[n]);
			if(threaded) {
				t[n] = new Thread(bs[n]);
				t[n].start();
			}else{
				bs[n].run();
			}
		}
		boolean allFinished = false;
		while(!allFinished) {
			int nFinished = 0;
			for(int n=0;n<nNodes;n++) {
				if(bs[n].getFinished()) {
					nFinished++;
				}
			}
			if(nFinished == nNodes) {
				allFinished = true;
			}
		}
		mergeSort(splitData,nRows);
		return System.nanoTime() - startTime;
	}
	private void mergeSort(Double[][] splitData,int nRows) {
		Integer[] pos = new Integer[nNodes];
		for(int i=0;i<nNodes;i++) {
			pos[i] = 0;
		}
		boolean finished = false;
		int dataPos = 0;
		while(!finished) {
			// Find the lowest of the pos values
			Double minVal = 2.0;
			int minPos = -1;
			int nNull = 0;
			for(int n=0;n<nNodes;n++) {
				if(pos[n]!=null && splitData[n][pos[n]]<minVal) {
					minVal = splitData[n][pos[n]];
					minPos = n;
				}else if(pos[n]==null) {
					nNull++;
				}
			}
			if(nNull == nNodes) {
				finished = true;
			}else {
				allData[dataPos++] = minVal;
				pos[minPos]++;
				if(pos[minPos]>=nRows) {
					pos[minPos] = null;
				}
			}
		}
	}

	public static void main(String[] args) {
		ThreadSort ts = new ThreadSort(Integer.parseInt(args[1]),Integer.parseInt(args[0]));
		long duration = ts.sortAll();
		ts.resetData();
		System.out.println("Full bubblesort took " + duration);
		duration = ts.sortInParallel(false);
		ts.resetData();
		System.out.println("Parallel bubblesort took " + duration);
		duration = ts.sortInParallel(true);
		System.out.println("Parallel threaded bubblesort took " + duration);

	}
}
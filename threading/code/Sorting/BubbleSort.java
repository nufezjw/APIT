public class BubbleSort implements Runnable {
	private Double[] data;
	private boolean finished;
	public BubbleSort(Double[] d) {
		data = d;
	}
	public void run() {
		// Do the bubble sort
		finished = false;
		while(!finished) {
			int nSwaps = 0;
			for(int i=0;i<data.length-1;i++) {
				if(data[i]>data[i+1]) {
					// Swap them
					Double temp = data[i];
					data[i] = data[i+1];
					data[i+1] = temp;
					nSwaps++;
				}
			}
			if(nSwaps==0) {
				finished = true;
			}
		}
	}
	public boolean getFinished() {
		return finished;
	}
}
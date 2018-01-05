public class ThreadSort implements Runnable {
	private Double[] subArray;
	private int arrayLength;
	public ThreadSort(Double[] subArray) {
		arrayLength = subArray.length;
		this.subArray = new Double[arrayLength];
		for(int i=0;i<arrayLength;i++) {
			this.subArray[i] = subArray[i];
		}
	}
	public void run() {
		// Do a slow bubble sort
		int n_changes = 1;
		while(n_changes > 0) {
			n_changes = 0;
			for(int i=0;i<arrayLength-1;i++) {
				if(subArray[i+1] < subArray[i]) {
					Double temp = subArray[i];
					subArray[i] = subArray[i+1];
					subArray[i+1] = temp;
					n_changes += 1;
				}
			}
		}
	}
	public Double[] getArray() {
		return subArray;
	}
}
public class FindMax implements Runnable {
	private Double[] values;
	private int maxIndex;
	private Double maxValue;
	private Boolean finished = false;
	public FindMax(Double[] v) {
		values = v;
		maxIndex = -1;
		maxValue = -1.0;
	}
	public void run() {
		for(int i=0;i<values.length;i++) {
			if(values[i]>maxValue) {
				maxValue = values[i];
				maxIndex = i;
			}
		}
		finished = true;
	}
	public Double getMax() {
		return maxValue;
	}
	public Boolean getFinished() {
		return finished;
	}
}
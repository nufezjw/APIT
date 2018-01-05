public class CountThread extends Thread {
	private int nSteps;
	private CountObject c;
	public CountThread(int n,CountObject cin) {
		nSteps = n;
		c = cin;
	}
	public void run() {
		for(int i=0;i<nSteps;i++) {
			Integer a = c.geti();
			a += 1;
			c.seti(a);
		}
	}
}
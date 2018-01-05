public class SimpleThreadTest {
	private static class PointlessPrint extends Thread {
		private String message;
		private int n;
		public PointlessPrint(String message, int n) {
			this.message = message;
			this.n = n;
		}
		public void run() {
			for(int i=0;i<n;i++) {
				System.out.println(i + "/" + n + " " + message);
			}
		}
	}
	public static void main(String[] args) {
		PointlessPrint[] threads = new PointlessPrint[2];
		for(int i=0;i<2;i++) {
			threads[i] = new PointlessPrint("I am thread " + i,10);
			threads[i].start();
		}
	}
}
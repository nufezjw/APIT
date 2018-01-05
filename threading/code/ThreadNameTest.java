public class ThreadNameTest {
	private static class PointlessThread implements Runnable {
		private int n;
		public PointlessThread(int n) {
			this.n = n;
		}
		public void run() {
			for(int i=0;i<n;i++) {
				System.out.println(Thread.currentThread().getName() +" "+ i);
			}
		}
	}
	public static void main(String[] args) {
		Thread[] threads = new Thread[2];
		for(int i=0;i<2;i++) {
			threads[i] = new Thread(new PointlessThread(10),"I am " + i);
			threads[i].start();
		}
	}
}
public class RunnableTest3 {
	private static class PointlessPrint implements Runnable {
		private String message;
		private int n;
		public PointlessPrint(String message,int n) {
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
		int nThreads = 2;
		Thread[] threads = new Thread[nThreads];
		for(int i=0;i<nThreads;i++)
		{
			threads[i] = new Thread(new PointlessPrint("I am thread " + i,10));
			threads[i].start();
		}
	}
}
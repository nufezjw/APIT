public class ThreadNameTest2 {
	private static class PointlessThread extends Thread {
		private int n;
		public PointlessThread(int n,String name) {
			super(name); // Thread constructor
			this.n = n;
		}
		public void run() {
			for(int i=0;i<n;i++) {
				System.out.println(this.getName() +" "+ i);
			}
		}
	}
	public static void main(String[] args) {
		PointlessThread[] threads = new PointlessThread[2];
		for(int i=0;i<2;i++) {
			threads[i] = new PointlessThread(10,"Thread " + i);
			threads[i].start();
		}
	}
}
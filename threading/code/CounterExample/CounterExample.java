public class CounterExample {
	public static class MyCounter {
		// This object stores the current value of the counter
		// We will pass a reference to it to all threads
		// Get and set methods allow other objects to change count
		private int count = 0;
		public int getCount() {
			return count;
		}
		public void setCount(int count) {
			this.count = count;
		}
	}
	public static class Counter extends Thread {
		// This is the Thread object that will be doing the counting
		// We pass it a reference to a counter object
		// and how many increments to do.
		private MyCounter count;
		private int n;
		public Counter(MyCounter count,int n) {
			this.count = count;
			this.n = n;
		}
		// The run method does the counting
		public void run() {
			for(int i=0;i<n;i++) {
				int temp = count.getCount();
				temp++;
				count.setCount(temp);
			}
		}
	}
	public static void main(String[] args) {
		// Create a new MyCounter object
		MyCounter count = new MyCounter();
		// Create a new Counter thread and start it
		Counter c = new Counter(count,100);
		c.start();
		// Jpin it (i.e. wait for it to finish)
		try {
			c.join();
		}catch(InterruptedException e) {
			//Do nothing
		}
		// Display the counter value
		System.out.println(count.getCount());
	}
}
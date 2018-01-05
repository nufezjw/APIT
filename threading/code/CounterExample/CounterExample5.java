import java.util.concurrent.locks.*;
public class CounterExample5 {
	public static class MyCounter {
		// Instead of synchronised, we can use a lock.
		private int count = 0;
		private ReentrantLock counterLock = new ReentrantLock();
		public void increment() {
			counterLock.lock();
			count ++;
			counterLock.unlock();
		}
		public int getCount() {
			return count;
		}
	}
	public static class Counter extends Thread {
		private MyCounter count;
		private int n;
		public Counter(MyCounter count,int n) {
			this.count = count;
			this.n = n;
		}
		public void run() {
			for(int i=0;i<n;i++) {
				count.increment();
			}
		}
	}
	public static void main(String[] args) {
		MyCounter count = new MyCounter();
		int nCounters = 100;
		Counter[] c = new Counter[nCounters];
		for(int i=0;i<nCounters;i++) {
			c[i] = new Counter(count,1000);
			c[i].start();
		}
		try {
			for(int i=0;i<nCounters;i++) {
				c[i].join();
			}
		}catch(InterruptedException e) {
			//Do nothing
		}
		System.out.println(count.getCount());
	}
}
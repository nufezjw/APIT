import java.util.concurrent.locks.*;
public class CounterDecounter3 {
	public static class MyCounter {
		private int count = 0;
		private ReentrantLock counterLock = new ReentrantLock();
		// We now create a condition from our lock
		private Condition bigEnough = counterLock.newCondition();
		public void increment(int amount) {
			counterLock.lock();
			try {
				count +=amount;
				System.out.println("Adding " + amount + ", result " + count);
				// Every time an amount is added, signalAll is invoked to wake up any 
				// threads that have called await()
				bigEnough.signalAll();
			}finally {
				counterLock.unlock();
			}

		}
		public void decrement(int amount) {
			counterLock.lock();
			try {
				while(count < amount) {
					// when await is called, the current thread pauses until
					// another thread calls the signalAll() method of the condition
					bigEnough.await();
					// Once signalAll has been received, if count>amount the decrement 
					// will happen, otherwise it will await() again
				}
				count -= amount;
				System.out.println("Subtracting " + amount + ", result " + count);
			}catch (InterruptedException e) {
				// Fall through
			}finally {
				counterLock.unlock();
			}
		}
		public int getCount() {
			return count;
		}
	}
	public static class Counter extends Thread {
		private MyCounter count;
		private int n;
		private int amount;
		public Counter(MyCounter count,int n,int amount) {
			this.count = count;
			this.n = n;
			this.amount = amount;
		}
		public void run() {
			for(int i=0;i<n;i++) {
				count.increment(amount);
			}
		}
	}
	public static class DeCounter extends Thread {
		private MyCounter count;
		private int n;
		private int amount;
		public DeCounter(MyCounter count,int n,int amount) {
			this.count = count;
			this.n = n;
			this.amount = amount;
		}
		public void run() {
			for(int i=0;i<n;i++) {
				count.decrement(amount);
			}
		}
	}
	public static void main(String[] args) {
		MyCounter count = new MyCounter();
		// Create some counters and decounters
		// such that we will end up with zero
		int nCounters = 10,incNum = 10;
		int nDeCounters = 2,decNum = 50;
		int nReps = 10;

		Counter[] c = new Counter[nCounters];
		DeCounter[] d = new DeCounter[nDeCounters];
		
		// Create and start the counters and decounters
		for(int i=0;i<nCounters;i++) {
			c[i] = new Counter(count,nReps,incNum);
			c[i].start();
		}
		for(int i=0;i<nDeCounters;i++) {
			d[i] = new DeCounter(count,nReps,decNum);
			d[i].start();
		}

		// Wait for everything to finish
		try {
			for(int i=0;i<nCounters;i++) {
				c[i].join();
			}
			for(int i=0;i<nDeCounters;i++) {
				d[i].join();
			}
		}catch(InterruptedException e) {
			//Do nothing
		}
		System.out.println("Final Result: " + count.getCount());
	}
}
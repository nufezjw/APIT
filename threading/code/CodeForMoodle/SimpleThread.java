public class SimpleThread {
	public static void main(String[] args) {
		// MyRunnable[] allRunnable = new MyRunnable[20];
		// for(int i=0;i<20;i++) {
		// 	allRunnable[i] = new MyRunnable("I am thread "+i);		
		// }
		// Thread[] allThreads = new Thread[20];
		// for(int i=0;i<20;i++) {
		// 	allThreads[i] = new Thread(allRunnable[i]);
		// }
		// // for(int i=0;i<20;i++) {
		// // 	allThreads[i].start();
		// // }


		Thread[] myThreads = new MyThread[20];
		for(int i=0;i<20;i++) {
			myThreads[i] = new MyThread("I am thread " + i);
			myThreads[i].start();
		}
		try{
			for(int i=0;i<20;i++) {
				myThreads[i].join();
			}
		}catch(InterruptedException e) {
			
		}
		System.out.println("THE END");
	}
}
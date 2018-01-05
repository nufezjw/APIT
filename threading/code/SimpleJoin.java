public class SimpleJoin extends Thread{
	public void run() {
		try {
			Thread.sleep(1000);
		}catch(InterruptedException e) {
			// do nothing
		}
	}
	public static void main(String[] args) {
		SimpleJoin[] sj = new SimpleJoin[10];
		for(int i=0;i<10;i++) {
			sj[i] = new SimpleJoin().start(); // create and start the threads
		}
		for(int i=0;i<10;i++) {
			sj[i].join(); // join main to this thread and wait until it finishes
		}
		System.out.println("THE END");
	}
}

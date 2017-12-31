public class ThreadExample {
	public static void main(String[] args) {
		MyRunnableThing[] m = new MyRunnableThing[100];
		for(int i=0;i<100;i++) {
			m[i] = new MyRunnableThing(i);
			m[i].start();
			// new Thread(m[i]).start();
		}
		for(int i=0;i<100;i++) {
			try {
				m[i].join();		
			}catch(InterruptedException e) {
				System.out.println(e);
			}
		}
		System.out.println("FINISHED");
		// MyRunnableThing m = new MyRunnableThing(1);
		// MyRunnableThing m2 = new MyRunnableThing(2);
		// Thread t = new Thread(m);
		// Thread t2 = new Thread(m2);
		// t.start();
		// t2.start();
	}
}
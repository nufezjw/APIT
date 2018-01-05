import java.util.Random;
public class InterruptTest {
	public static class InterruptableThread implements Runnable {
		public void run() {
			int i=0;
			while(Thread.currentThread().isInterrupted()==false) {
				System.out.println(i++);
			}
		}
	}
	public static void main(String[] args) {
		Thread t = new Thread(new InterruptableThread());
		t.start();
		int r = new Random().nextInt();
		for(int i=0;i<r;i++) {
			// Nothing, just eat up some time
		}
		t.interrupt();
	}
}
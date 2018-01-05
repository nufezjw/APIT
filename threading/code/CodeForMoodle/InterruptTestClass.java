import java.util.Random;
public class InterruptTestClass {
	public static class InterruptableThread extends Thread {
		public void run() {
			int i=0;
			while(this.isInterrupted()==false) {
				System.out.println(i++);
			}
		}
	}
	public static void main(String[] args) {
		Thread t = new InterruptableThread();
		t.start();
		int r = new Random().nextInt();
		for(int i=0;i<r;i++) {
			// Nothing, just eat up some time
		}
		t.interrupt();
	}
}
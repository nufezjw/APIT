import java.util.Random;
public class InterruptTest2 {
	public static class InterruptableThread implements Runnable {
		int interruptCounter = 0;
		public void run() {
			int i=0;
			while(i<1000000) {
				i++;
				if(Thread.interrupted()) {
					interruptCounter++;
					System.out.println("Interrupt counter " + interruptCounter);
				}
			}
		}
	}
	public static void main(String[] args) {
		Thread t = new Thread(new InterruptableThread());
		t.start();
		for(int j=0;j<10;j++){
			int r = new Random().nextInt();
			for(int i=0;i<r;i++) {
				// Nothing, just eat up some time
			}
			t.interrupt();
		}
	}
}
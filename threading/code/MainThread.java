public class MainThread extends Thread{
	public void run() {
		try {
			Thread.sleep(1000);
		}catch(InterruptedException e) {}
		System.out.println("Thread finished");
	}
	public static void main(String[] args) {
		for(int i=0;i<10;i++) {
			new MainThread().start();
		}
		System.out.println("THE END");
	}
}
public class MyRunnableThing extends Thread {
	private int id;
	public MyRunnableThing(int id) {
		this.id = id;
	}
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println("Hello, number " + i + ", " + id);
			try {
				this.sleep(50);
			}catch(InterruptedException e) {
				System.out.println(e);
			}
		}
	}
}
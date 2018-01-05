public class MyThread extends Thread {
	private String myString;
	public MyThread(String in) {
		myString = in;
	}
	public void run() {
		try {
			for(int i=0;i<10;i++) {
				System.out.println(myString);
				sleep(200);
			}
		}catch(InterruptedException e) {

		}
	}
}
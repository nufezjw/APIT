public class MyRunnable implements Runnable {
	public String myString;
	public MyRunnable(String in) {
		myString = in;
	}
	public void run() {
		for(int i=0;i<1000;i++) {
			System.out.println(myString);
		}
	}
}
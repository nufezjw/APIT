public class Counter {
	public static void main(String[] args) {
		CountObject co = new CountObject();
		CountThread counter1 = new CountThread(300,co);
		CountThread counter2 = new CountThread(500,co);

		counter1.start();
		counter2.start();

		try {
			counter1.join();
			counter2.join();
		}catch(InterruptedException e) {}

		System.out.println("Total is " + co.geti());
	}
}
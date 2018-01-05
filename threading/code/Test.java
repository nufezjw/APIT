public class Test {
	public static void main(String[] args) {
		PointlessPrint p = new PointlessPrint("Hello",100);
		Thread t = new Thread(p);
		t.start();
	}
}
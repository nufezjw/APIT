public class AssertionExample {
	private int myInt;
	public AssertionExample(int n) {
		myInt = n;
	}
	public void decrement(int d) {
		if(d>myInt) {
			// Can't decrement!
			System.out.println("Can't decrement!!");
		}else {
			myInt = myInt - d;
		}
	}
	public static void main(String[] args) {
		new AssertionExample(5).decrement(10);
	}
}
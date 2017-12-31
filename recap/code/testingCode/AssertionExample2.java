public class AssertionExample2 {
	private int myInt;
	public AssertionExample2(int n) {
		myInt = n;
	}
	public void decrement(int d) {
		assert myInt >= d;
		myInt = myInt - d;
	}
	public static void main(String[] args) {
		new AssertionExample2(5).decrement(10);
	}
}
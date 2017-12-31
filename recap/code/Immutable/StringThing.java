public class StringThing {
	public static void stringTest(String in) {
		in = in + " added";
	}
	public static void main(String[] args) {
		String s = "hello";
		stringTest(s);
		System.out.println(s);
	}
}
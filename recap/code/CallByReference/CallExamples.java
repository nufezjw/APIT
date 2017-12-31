public class CallExamples {
	public static class MyClass {
		int a = 0;
		public MyClass(int a) {
			this.a = a;
		}
		public int getValue() {
			return a;
		}
	}
	public static class DoubleClass {
		Double a = 0.0;
		public DoubleClass(Double a) {
			this.a = a;
		}
		public void multiply(Double m) {
			a = a * m;
		}
		public Double getValue() {
			return a;
		}
	}
	private static void aTest(MyClass in) {
		in = new MyClass(5);
	}

	private static void stringTest(String in) {
		in = in + " added";
		System.out.println(in);
	}

	private static void doubleTest(Double in) {
		in = in * 2;
	}
	private static void doubleObjectTest(DoubleClass in) {
		in.multiply(2.0);
	}

	public static void main(String[] args) {
		MyClass m = new MyClass(3);
		aTest(m);	
		System.out.println(m.getValue());
		// What value will be displayed?


		String s = "hello";
		stringTest(s);
		System.out.println(s);
		// What will s be?

		Double d = 3.2;
		doubleTest(d);
		System.out.println(d);
		// What will d be?

		DoubleClass d2 = new DoubleClass(3.2);
		doubleObjectTest(d2);
		System.out.println(d2.getValue());
		// What will the value be?
	}
}
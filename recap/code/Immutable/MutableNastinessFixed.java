public class MutableNastinessFixed {
	public static class MyDouble {
		private Double a;
		public MyDouble(Double a) {
			this.a = a;
		}
		public void multiply(Double m) {
			a = a * m;
		}
		public Double getValue() {
			return a;
		}
	}
	public static class DoubleWrapper {
		private MyDouble d;
		public DoubleWrapper(Double in) {
			this.d = new MyDouble(in);
		}
		public MyDouble getMyDouble() {
			return new MyDouble(getValue());
		}
		public void multiply(Double m) {
			d.multiply(m);
		}
		public Double getValue() {
			return d.getValue();
		}
	}

	public static void main(String[] args) {
		// Create a Double object
		DoubleWrapper dw = new DoubleWrapper(3.2);
		MyDouble d = dw.getMyDouble();
		System.out.println(d.getValue());
		d.multiply(2.0);
		System.out.println(d.getValue());
		System.out.println(dw.getValue());
	}
}
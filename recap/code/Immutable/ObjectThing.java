public class ObjectThing {
	public static class myObject {
		private String s;
		public myObject(String s) {
			this.s = s;
		}
		public void setString(String s) {
			this.s = s;
		}
		public String getString() {
			return this.s;
		}
	}
	public static void main(String[] args) {
		String s = "hello";
		myObject o = new myObject(s);
		myObject o2 = o;
		o.setString("blah");
		System.out.println(o2.getString());
		System.out.println(s);
	}
}
public class Pointless2 {
	public int myInt;
	public Pointless2(int n) {
		myInt = n;
	}
	public void increment() {
		myInt++;
	}
	public int getMyInt() {
		return myInt;
	}
	public void doubleMyInt() {
		int a = myInt;
		for(int i=0;i<a;i++) {
			myInt++;
		}
	}
}
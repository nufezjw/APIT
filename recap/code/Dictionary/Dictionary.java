import java.util.ArrayList;
// A hacky alternative to HashMaps to demonstrate
// making a class with generics
public class Dictionary<A,B> {
	private ArrayList<A> listA = new ArrayList<A>();
	private ArrayList<B> listB = new ArrayList<B>();
	public void add(A a,B b) {
		listA.add(a);
		listB.add(b);
	}
	public B getDefinition(A a) {
		int index = listA.indexOf(a);
		return listB.get(index);
	}
}
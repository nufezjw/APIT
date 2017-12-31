public class DictionaryTest {
	public static void main(String[] args) {
		Dictionary<String,Double> d = new Dictionary<String,Double>();
		d.add("apple",3.0);
		d.add("banana",2.5);
		System.out.println(d.getDefinition("banana"));

		// Can also make the reverse!
		Dictionary<Double,String> d2 = new Dictionary<Double,String>();
		d2.add(3.0,"apple");
		d2.add(2.5,"banana");
		System.out.println(d2.getDefinition(3.0));

	}
}
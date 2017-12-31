public class Goldfish extends Pet {
	public Goldfish(String n,int a) {
		super(n,a);
	}
	public String description() {
		String output = name + " is my goldfish and is aged " + age;
		return output;
	}
}
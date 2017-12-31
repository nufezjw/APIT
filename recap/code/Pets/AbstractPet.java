public abstract class AbstractPet {
	protected String name;
	protected int age;
	public AbstractPet(String n, int a) {
		name = n;
		age = a;
	}
	abstract String description();
	public String toString() {
		String output = name + " is aged " + age;
		return output;
	}
}
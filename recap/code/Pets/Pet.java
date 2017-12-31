public class Pet {
	protected String name;
	protected int age;
	public Pet(String n,int a) {
		name = n;
		age = a;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public String description() {
		String output = name + " is my pet and is aged " + age;
		return output;
	}
	public String toString() {
		return name + " is aged " + age;
	}
}
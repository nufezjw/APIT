public class Parrot implements InterfacePet {
	private String name;
	private int age;
	public Parrot(String n,int a) {
		name = n;
		age = a;
	}
	public String description() {
		String output = name + " is a parrot and is aged " + age;
		return output;
	}
}
public class TestInterfacePet {
	public static void main(String[] args) {
		InterfacePet p = new Parrot("Polly",42);
		System.out.println(p.description());
	}
}
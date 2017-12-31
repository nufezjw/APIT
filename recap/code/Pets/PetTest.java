public class PetTest {
	public static void main(String[] args) {
		Pet a = new Pet("Flossy",3);

		System.out.println(a.description());

		System.out.println();System.out.println();

		Pet[] e = new Pet[3];
		e[0] = new Pet("Colin",2);
		e[1] = new Pet("Ruth",1);
		e[2] = new Pet("Molly",4);

		for(int i=0;i<e.length;i++) {
			System.out.println(e[i].description());
		}

		System.out.println();System.out.println();

		// Pet also has a toString method
		System.out.println(a);
	}
}
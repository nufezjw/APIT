import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class ArrayIteration {

	public static void main(String[] args) {
		ArrayList<Double> a = new ArrayList<Double>();
		Random r = new Random();
		for(int i=0;i<10;i++) {
			a.add(r.nextDouble());
		}		
		Iterator ai = a.iterator();
		while(ai.hasNext()) {
			System.out.println(ai.next());
		}
		/* Note because ArrayList implements iterable, 
		   we can also do the following
		   (Think 'for each i in a') */
		for(Double i : a) {
			System.out.println(i);
		}
	}

}
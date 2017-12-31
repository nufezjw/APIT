import org.junit.Test;
import org.junit.Assert;


import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

public class PointlessTest {
	private static final double EPSILON = 1e-12; 
	@Test public void testIncrement()
	{
		Pointless p = new Pointless(1);
		p.increment();
		int expected = 2;
		Assert.assertEquals(expected,p.getMyInt(),EPSILON);
	}

	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(PointlessTest.class);
		if(result.wasSuccessful()) {
			System.out.println("Test passed");
		}else {
			System.out.println("Test failed");
		}
	}
}
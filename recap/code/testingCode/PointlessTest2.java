import org.junit.Test;
import org.junit.Assert;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;


public class PointlessTest2 {
	private static final double EPSILON = 1e-12; 
	@Test public void testIncrement()
	{
		Pointless2 p = new Pointless2(1);
		p.increment();
		int expected = 2;
		Assert.assertEquals(expected,p.getMyInt(),EPSILON);
	}	

	@Test public void testDouble()
	{
		Pointless2 p = new Pointless2(5);
		p.doubleMyInt();
		int expected = 10;
		Assert.assertEquals(expected,p.getMyInt(),EPSILON);
	}

	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(PointlessTest2.class);
		if(result.wasSuccessful()) {
			System.out.println("Test passed");
		}else {
			System.out.println("Test failed");
		}

		for(Failure failure: result.getFailures()) {
			System.out.println(failure);
		}

	}
}
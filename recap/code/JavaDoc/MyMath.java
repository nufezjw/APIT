/**
 * @author Simon Rogers
 * This class implements some standard maths functions
*/
public class MyMath {
	/**
	 * Returns the area of a circle
	 * 
	 * @param r the radius of the circle
	 * @return Double the area of the circle
	 *
	 */ 
	public static Double areaOfCircle(Double r) {
		Double area = Math.PI*r*r;
		return area;
	}

	/** 
	 * Returns the area of a rectangle
	 *
	 * @param width the width of the rectangle
	 * @param height the height of the rectangle
	 * @return Double the area of the rectangle
	 * 
	 */
	public static Double areaOfRectangle(Double width, Double height) {
		return width*height;
	}
}
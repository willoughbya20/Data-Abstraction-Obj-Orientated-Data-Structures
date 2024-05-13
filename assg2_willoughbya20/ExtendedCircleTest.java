/**
 * Adam Willoughby
 * Program runs tests for all methods created in previous classes
 */

package assg2_willoughbya20;

public class ExtendedCircleTest {

	public static void main(String[] args) 
	{
		Point p1 = new Point();
		Point p2 = new Point(2, 4);
		Point p3 = new Point (5, 5);
		Point p4 = new Point (3, 3);
		Point p5 = new Point (8, 5);
		System.out.println("This is our center point: " + p1);
		System.out.println("This is a point in the circle: " + p2);
		
		p2.setX(3);
		p2.setY(3);
		p2.getX();
		p2.getY();
		System.out.println("\nThis is the new x and y value for the point using set and get methods: " + p2);
		
		System.out.println("\nUsing toString method for our point: " + p2.toString());
		
		System.out.println("\nThe distance from our center to our point: " + p2.distance(p1));
		
		System.out.println("\nPoint 1 and point 2 are equal: " + p2.equals(p1));
		System.out.println("Point 4 and Point 2 are equal: " + p2.equals(p4));
		
		ExtendedCircle c1 = new ExtendedCircle();
		ExtendedCircle c2 = new ExtendedCircle(4.2);
		ExtendedCircle c3 = new ExtendedCircle(5.7, p1);
		ExtendedCircle c4 = new ExtendedCircle(4, p5);
		ExtendedCircle c5 = new ExtendedCircle(4, p5);
		
		System.out.println("\nThis is our first circle: " + c1);
		System.out.println("\nThis is our second circle: " + c2);
		System.out.println("\nThis is our third circle: " + c3);
		
		c3.setRadius(3);
		c3.setCenter(p3);
		System.out.println("\nShowing circle 3's radius using get method: " + c3.getRadius());
		c3.getCenter();
		System.out.println("\nNew radius and center using set method: " + c3);
		
		System.out.println("\nThe area of the circle is: " + c3.compArea());
		System.out.println("The circumference of the circle is: " + c3.compCircumference());
		System.out.println("\nPrint the center and radius using toString method: " + c2.toString());
		
		System.out.println("\nThis point is on the circle: " + c3.positionToCircle(p4));
		System.out.println("This point is outside the circle: " + c3.positionToCircle(p1));
		System.out.println("This point is inside the circle: " + c3.positionToCircle(p5));
		
		System.out.println("\nShifting our center in a positive value: " + c2.shift(2, 2));
		System.out.println("\nShifting our center in a negative value: " + c2.shift(-4, -4));
		
		System.out.println("\nScaling the radius by 2: " + c2.scale(2));
		System.out.println("Scaling the radius by 0.5: " + c2.scale(.5));
		
		System.out.println("\nDo circle 2 and circle 3 overlap? " + c2.overlap(c3));
		System.out.println("Do circle 1 and circle 3 overlap? " + c1.overlap(c3));
		
		System.out.println("\nIs circle 1 the same as circle 3? " + c1.equals(c3));
		System.out.println("Is circle 4 the same as circle 5? " + c4.equals(c5));
	
		
		
	}
}

/**
 * Adam Willoughby
 * JUnit testing class that tests all methods made in Point class for assignment 2
 */
package assg5_willoughbya20;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import assg2_willoughbya20.Point;

public class TestPoint {

	private Point p1, p2, p3 ,p4;
	
	@Before
	public void setUp()
	{
		p1 = new Point();
		p2 = new Point(1,2);
		p3 = new Point(3,4);
		p4 = new Point(3,4);
	}
	@Test
	public void testDefaultConstructor()
	{
		assertEquals("Cordinate x", 0, p1.getX());
		assertEquals("Cordinate y", 0, p1.getY());
	}
	@Test
	public void testTwoParameterConstructor()
	{
		assertEquals("Coordinate x", 1, p2.getX());
		assertEquals("Coordinate y", 2, p2.getY());
	}
	@Test
	public void testGetX()
	{
		assertEquals("Coordinate x", 1, p2.getX());
	}
	@Test
	public void testGetY()
	{
		assertEquals("Coordinate y", 2, p2.getY());
	}
	@Test
	public void testSetX()
	{
		p3.setX(9);
		assertEquals("Coordinate x", 9, p3.getX());
	}
	@Test
	public void testSetY()
	{
		p3.setY(9);
		assertEquals("Coordinate y", 9, p3.getY());
	}
	@Test
	public void testToString()
	{
		assertEquals("Coordinates x and y", "(" + 0 + "," + 0 + ")", p1.toString());
	}
	@Test
	public void testDistance()
	{
		assertEquals("Distance between the two points", 2.2360679774998, p1.distance(p2), 1);
	}
	@Test
	public void testEquals()
	{
		assertTrue("True test", p3.equals(p4));
		assertFalse("False test", p1.equals(p3));
	}
}

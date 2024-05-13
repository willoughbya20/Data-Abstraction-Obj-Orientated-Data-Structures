/**
 * Adam Willoughby
 * JUnit testing class that tests all methods made in ExtendedCircle class in assignment 2
 */
package assg5_willoughbya20;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import assg2_willoughbya20.Point;
import assg2_willoughbya20.ExtendedCircle;

public class TestExtendedCircle {

	private Point p1,p2,p3, p4, p5, p6, p7, p8;
	private ExtendedCircle c1, c2, c3, c4, c5, c6, c7, c8, c9;
	@Before
	public void setUp()
	{
		p1 = new Point(1,2);
		p2 = new Point(3,4);
		p3 = new Point(5,6);
		p4 = new Point(1,1);
		p5 = new Point(4,4);
		p6 = new Point(2,4);
		p7 = new Point(2,2);
		p8 = new Point(10,10);
		c1 = new ExtendedCircle();
		c2 = new ExtendedCircle(5);
		c3 = new ExtendedCircle(3, p1);
		c4 = new ExtendedCircle(4, p2);
		c5 = new ExtendedCircle(1, p2);
		c6 = new ExtendedCircle(4, p4);
		c7 = new ExtendedCircle(2,p7);
		c8 = new ExtendedCircle(1,p8);
		c9 = new ExtendedCircle(1, p8);
		
	}
	
	@Test
	public void testDefaultConstructor()
	{
		
		assertEquals("Circle center coord x", c1.getCenter(), c1.getCenter());
		assertEquals("Circle radius", 1, c1.getRadius(), 1);
	}
	@Test
	public void testOneParameterConstructor()
	{
		assertEquals("Circles radius", 1, c1.getRadius(), 1);
	}
	@Test
	public void testTwoParameterConstructor()
	{
		assertEquals("Circle center coords", p1, c3.getCenter());
		assertEquals("Circle radius", 3, c3.getRadius(), 1);
	}
	@Test
	public void testGetRadius()
	{
		assertEquals("Circles raidus", 5, c2.getRadius(), 1);
	}
	@Test
	public void testGetCenter()
	{
		assertEquals("Circles center", p1, c3.getCenter());
	}
	@Test
	public void testSetRadius()
	{
		c2.setRadius(4);
		assertEquals("c2 radius", 4, c2.getRadius(), 1);
	}
	@Test
	public void testSetCenter()
	{
		c2.setCenter(p1);
		assertEquals("c2 center", p1, c2.getCenter());
		
	}
	@Test
	public void testCompArea()
	{
		assertEquals("Circles area", Math.PI * 5 * 5, c2.compArea(), 1);
	}
	@Test
	public void testCompCircumference()
	{
		assertEquals("Circles circumference", Math.PI * 2 * 5, c2.compCircumference(), 1);
	}
	@Test
	public void testToString()
	{
		assertEquals("Circle toString test", "\nRadius: " + 3.0 + "\nCenter: " + p1, c3.toString());
	}
	@Test
	public void testPositionToCircle()
	{
		assertEquals("Point inside circle", -1, c4.positionToCircle(p1));
		assertEquals("Point outside circle", 1, c5.positionToCircle(p4));
		assertEquals("Point on circle", 0, c7.positionToCircle(p6));
	}
	@Test
	public void testScale()
	{
		c3.scale(2);
		assertEquals("Scale circle test", 3.0, c3.getRadius(), 1);
	}
	@Test
	public void testOverlap()
	{
		assertTrue("Circle overlap true test", c3.overlap(c4));
		assertFalse("Circle overlap false test", c8.overlap(c7));
	}
	@Test
	public void testEquals()
	{
		assertTrue("Circle equals another circle true test", c9.equals(c8));
		assertFalse("Circle equals another circle false test", c9.equals(c2));
	}
	@Test
	public void testShift()
	{
		c6.shift(3, 3);
		assertEquals("Shift x test", 1, c6.getCenter().getX());
		assertEquals("Shift y test", 1, c6.getCenter().getY());
	}
}


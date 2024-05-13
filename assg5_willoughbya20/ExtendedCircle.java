/**
 * Adam Willoughby
 * Represents a circle with a center point and a radius.
 */

package assg5_willoughbya20;

public class ExtendedCircle
{
	//Instance variables for radius, center point, and pi
	private double radius;
	private Point center;
	public static final double PI = 3.14;
	
	/**
	 * Default constructor
	 */
	public ExtendedCircle()
	{
		radius = 1;
		center = new Point(0,0);
	}
	
	/**
	 * Constructor with given radius and center of (0,0)
	 * @param r given the radius
	 */
	public ExtendedCircle(double r)
	{
		radius = r;
		center = new Point(0,0);
	}
	
	/**
	 * Constructor with given radius and center
	 * @param radius given the radius
	 * @param center given the center
	 */
	public ExtendedCircle(double radius, Point center)
	{
		this.radius = radius;
		this.center = center;
	}
	
	/**
	 * Modifying the radius
	 * @param newRadius is the new radius
	 */
	public void setRadius(double newRadius)
	{
		radius = newRadius;
	}
	
	/**
	 * Modifying the center
	 * @param newCenter is the new center point
	 */
	public void setCenter(Point newCenter)
	{
		center = newCenter;
	}
	
	/**
	 * Retrieving the radius
	 * @return the radius
	 */
	public double getRadius()
	{
		return radius;
	}
	
	/**
	 * Retrieving the center
	 * @return the center
	 */
	public Point getCenter()
	{
		return center;
	}
	
	/**
	 * Calculates the area of a circle
	 * @return the area of the circle
	 */
	public double compArea()
	{
		return PI*radius*radius;
	}
	
	/**
	 * Calculate the circumference of the circle
	 * @return the circumference of the circle
	 */
	public double compCircumference()
	{
		return 2*PI*radius;
	}
	
	@Override
	/**
	 * Method which gives us the correct format of how we want to print out our radius and center
	 */
	public String toString()
	{
		return "\nRadius: " + radius + "\nCenter: "  + center.toString();
	}
	
	/**
	 * Method which finds whether our point or position is inside, outside, or on the circle
	 * @param position of the point
	 * @return 1, -1, or 0
	 */
	public int positionToCircle(Point position)
	{
		if (position.distance(center) > radius)
		{
			return 1;
		}
		else if (position.distance(center) - radius == 0)
		{
			return 0;
		}
		else
		{
			return -1;
		}
	}
	
	/**
	 * Method which shifts our center point
	 * @param shiftX shifts the x
	 * @param shiftY shifts the y
	 * @return the radius and new center point according to shifts
	 */
	public ExtendedCircle shift(int shiftX, int shiftY)
	{
		return new ExtendedCircle(radius, new Point (center.getX() + shiftX, center.getY() + shiftY));
	}
	
	/**
	 * Scaling the radius down or up
	 * @param radiusScale given the radius and scale
	 * @return the scaled radius and center
	 */
	public ExtendedCircle scale(double radiusScale)
	{
		return new ExtendedCircle(radius * radiusScale, center);
	}
	
	/**
	 * Checks to see if circles overlap each other
	 * @param circleOverlap given center and radius
	 * @return true if it overlaps and false if it doesn't
	 */
	public boolean overlap(ExtendedCircle circleOverlap)
	{
		if (center.distance(circleOverlap.center) < radius + circleOverlap.radius) 
		{
			return true;
		}
		
		else
		{
			return false;
		}
	}
	
	/**
	 * Checks to see if one circle is equal to another
	 * @param Obj given the circle
	 * @return returns the radius and center or false if not true
	 */
	public boolean equals(Object Obj)
	{
		if (Obj == null)
		{
			return false;
		}
		
		else if (Obj instanceof ExtendedCircle)
		{
			ExtendedCircle temp = (ExtendedCircle)Obj;
			return (radius == temp.radius && center == temp.center);
		}
		
		else
		{
			return false;
		}
	}
	
	
}

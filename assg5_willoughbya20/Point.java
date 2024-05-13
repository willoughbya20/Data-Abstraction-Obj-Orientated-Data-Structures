/**
 *Adam Willoughby
 *Represents a point in the format of (x,y)
 */

package assg5_willoughbya20;

public class Point 
{
	//Instance variables x and y for our point
	private int x, y;
	
	/**
	 * Default constructor
	 */
	public Point()
	{
		x = 0;
		y = 0;
	}
	
	/**
	 * Constructor with given x and y
	 * @param x given the x
	 * @param y given the y
	 */
	public Point(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Modifying the x
	 * @param newX is the new x
	 */
	public void setX(int newX)
	{
		x = newX;
	}
	
	/**
	 * Modifying the y
	 * @param newY is the new y
	 */
	public void setY(int newY)
	{
		y = newY;
	}
	
	/**
	 * Retrieving the x
	 * @return the x
	 */
	public int getX()
	{
		return x;
	}
	
	/**
	 * Retrieving the y
	 * @return the y
	 */
	public int getY() 
	{
		return y;
	}
	
	/**
	 * Method which gives us the correct formatting of x and y point
	 */
	@Override
	public String toString()
	{
		return "(" + x + "," + y + ")";
	}
	
	/**
	 * Method which uses the distance formula to find the distance between two points
	 * @param temp as the other point thats not our original x and y
	 * @return the distance
	 */
	public double distance(Point temp)
	{
		return Math.sqrt(Math.pow((temp.x - x), 2) + Math.pow((temp.y - y), 2));
	}
	
	/**
	 * Method which checks to see if two points are the same, if not return false, if they 
	 * are return one of the equal points
	 */
	public boolean equals(Object Obj)
	{
		if (Obj == null)
		{
			return false;
		}
		
		else if (Obj instanceof Point)
		{
			Point temp = (Point)Obj;
			return (x == temp.x && y == temp.y);
		}
		
		else
		{
			return false;
		}
	}

}

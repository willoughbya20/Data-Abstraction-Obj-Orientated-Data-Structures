/**
 * Adam Willoughby
 * Student class where you can get the Id, major, name, standing.
 * A toString method to print out students.
 * CompareTo method to compare Id's.
 * and an Equals method as well
 */
package assg6_willougbya20;

public class Student implements Comparable<Student>{

	private String id;
	private String name;
	private String standing;
	private String major;
	
	/**
	 * Default Constructor given...
	 * @param id
	 * @param name
	 * @param standing
	 * @param major
	 */
	public Student(String id, String name, String standing, String major)
	{
		this.id = id;
		this.name = name;
		this.standing = standing;
		this.major = major;
	}
	/**
	 * Get id method that
	 * @return the id
	 */
	public String getId()
	{
		return id;
	}
	
	/**
	 * Get name method that
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Get standing method
	 * @return the students grade level
	 */
	public String getStanding()
	{
		return standing;
	}
	
	/**
	 * Get major method
	 * @return the students major
	 */
	public String getMajor()
	{
		return major;
	}
	/**
	 * toString method that will print out the students information in the correct format
	 */
	@Override
	public String toString()
	{
		return getId() + ", " + getName() + ", " + getStanding() + ", " + getMajor();
	}
	
	/**
	 * compareTo method that will compare an ID to a student
	 */
	@Override
	public int compareTo(Student a)
	{
		return this.id.compareTo(a.id);
	}
	
	/**
	 * Equals method that returns true when 2 ID's are equal and false if the object is null or
	 * the 2 ID's are not equal.
	 */
	public boolean equals(Object Obj)
	{
		if (Obj == null)
		{
			return false;
		}
		else if (Obj instanceof Student)
		{
			Student temp = (Student) Obj;
			return this.id.equals(temp.getId());
					
		}
		else
		{
			return false;
		}
	}
	
}

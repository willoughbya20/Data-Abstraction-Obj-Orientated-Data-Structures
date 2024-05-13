/**
 * Adam Willoughby
 * Customer class that allows us to create and get customer info
 */
package assg9_willoughbya20;

public class Customer extends KeyedItem<String> {
	
	private String name;
	private String phoneNumber;
	
	/**
	 * Default constructor
	 * @param id as key
	 * @param name given name
	 * @param phoneNumber given phone number
	 */
	public Customer(String id, String name, String phoneNumber)
	{
		super(id);
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	
	/**
	 * Get customer name
	 * @return name
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Get customer phonenumber
	 * @return phone number
	 */
	public String getPhone()
	{
		return phoneNumber;
	}
	
	/**
	 * Set customers name
	 * @param name given the name
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	
	/**
	 * Set customers phonenumber
	 * @param phoneNumber given a new phonenumber
	 */
	public void setPhone(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}
	
	
}

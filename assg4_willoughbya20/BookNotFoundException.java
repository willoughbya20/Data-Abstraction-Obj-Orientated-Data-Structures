/**
 * Adam Willoughby
 * Exception will be thrown when a book is not found
 */
package assg4_willoughbya20;

public class BookNotFoundException extends Exception
{
	/**
	 * Throws an error message
	 */
	public BookNotFoundException()
	{
		super("ERROR: Book name is invalid");
	}
	
	/**
	 * Throws an error
	 * @param msg given the string message
	 */
	public BookNotFoundException(String msg)
	{
		super(msg);
	}
}

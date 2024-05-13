/**
 * Adam Willoughby
 * Exception that will be thrown when a book already exists
 */
package assg4_willoughbya20;

public class BookIdAlreadyExistException extends Exception
{
	/**
	 * Throws error message
	 */
	public BookIdAlreadyExistException()
	{
		super("ERROR: BookId input is invalid");
	}
	/**
	 * Throws error msg
	 * @param msg given the string message
	 */
	public BookIdAlreadyExistException(String msg)
	{
		super(msg);
	}
}

/**
 * Adam Willoughby
 * This class creates our constructor, along with all gets for the instance variables
 * Provides a layout for how our output will look
 * Does a binary search loop to iterate through the books
 */

package assg4_willoughbya20;

public class Book {
	
	private String bookId;
	private String title;
	private String isbn;
	private String author;
	private char category;
	
	/**
	 * Default Constructor given
	 * @param bookId given bookId
	 * @param title given title
	 * @param isbn given isbn
	 * @param author given author
	 * @param category given category
	 */
	public Book(String bookId, String title, String isbn, String author, char category)
	{
		this.bookId = bookId;
		this.title = title;
		this.isbn = isbn;
		this.author = author;
		this.category = category;
		
	}
	
	/**
	 *	Gets bookId
	 * @return bookId
	 */
	public String getbookId()
	{
		return bookId;
	}
	/**
	 * Gets title
	 * @return title
	 */
	public String getTitle()
	{
		return title;
	}
	
	/**
	 * Gets isbm
	 * @return isbn
	 */
	public String getisbn()
	{
		return isbn;
	}
	
	/**
	 * Gets author
	 * @return author
	 */
	public String getAuthor()
	{
		return author;
	}
	
	/**
	 * Get category
	 * @return category
	 */
	public char getCategory()
	{
		return category;
	}
	/**
	 * toString method that returns our default output
	 * @return String
	 */
	@Override
	public String toString()
	{
		
		if(category == 'F')
		{
			return getbookId() + "\n" + getTitle() + "\n" + getisbn() + "\n" + getAuthor() + "\n" + "Fiction";
		}
		
		else
		{
			return getbookId() + "\n" + getTitle() + "\n" + getisbn() + "\n" + getAuthor() + "\n" + "Non-Fiction";
		}
		
		
	}
	
	/**
	 * Method to search our array to find the index value of a certain ID
	 * @param bookArr given books
	 * @param size given the size of the array
	 * @param bookId given bookID
	 * @return index value
	 * @throws BookNotFoundException
	 */
	public static int bookSearch(Book[]bookArr, int size, String bookId) throws BookNotFoundException
	{
		
		for (int i = 0; i < bookArr.length; i++)
		{
			if (bookArr[i].getbookId().equals(bookId))
			{
				return i;
			}
			
		}
		
		throw new BookNotFoundException("ERROR: Book not found");
		
	}

}

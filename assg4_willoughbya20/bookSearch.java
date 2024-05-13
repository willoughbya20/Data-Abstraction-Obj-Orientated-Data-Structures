/**
 * Adam Willoughby
 * Our main method which creates ties it all together.
 * Inputs the file
 * Reads it
 * Places the books into an array
 * and Handles exceptions
 */
package assg4_willoughbya20;

import java.io.*;
import java.util.Scanner;

public class bookSearch {

	public static void main(String[] args) 
	{
		String filename = "assg4_catalog.txt";
		Scanner inputStream = null;
		String line = " ";
		Book[]bookArr = new Book[6];
		String[] params = new String[6];
		int i = 0;
		boolean bool = true;
		
		try {
			inputStream = new Scanner(new File(filename));
			while(inputStream.hasNextLine()) {
				line = inputStream.nextLine();
				params = line.split("\\s+");
				bookArr[i] = new Book(params[0], params[1], params[2], params[3], params[4].charAt(0)); 
				i++;
			}
			
		}
		catch(FileNotFoundException e) {
			System.out.println("Error opening file " + filename);
			System.exit(1);
		}
		
		try
		{
			for (int j = 0; j < params.length + 1; j++)
			{
				if (bookArr[j] != null)
				{
					if (bookArr[j].getbookId().equals(bookArr[j]))
					{
						throw new BookIdAlreadyExistException();
					}
					System.out.print(bookArr[j] + "\n\n");
				}
			}
		}
		catch (BookIdAlreadyExistException e)
		{
			new BookIdAlreadyExistException();
		}
		System.out.println("\nTotal # of books: " + (i - 1));
		while(bool)
		{
			String booksID;
			Scanner keyboard = new Scanner(System.in);
			System.out.println("\nEnter a book ID: ");
			booksID = keyboard.nextLine();
			
			if (booksID.equalsIgnoreCase("STOP"))
			{
				System.out.println("End of the customer’s question.");
				System.exit(0);
			}
			else
			{
				try {
					int indexVal = Book.bookSearch(bookArr, i-1, booksID);
					System.out.println(bookArr[indexVal].toString());
				}
				catch(BookNotFoundException e) {
						System.out.println(e.getMessage());
					}
				keyboard.close();
				}
			}
		}
		
	}

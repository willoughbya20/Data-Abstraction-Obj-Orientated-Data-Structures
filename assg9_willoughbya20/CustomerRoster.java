/**
 * Adam Willoughby
 * CustomerRoster class that creates our tree of customers and allows us to
 * add, remove, display, search, and update customers
 */
package assg9_willoughbya20;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CustomerRoster {
	private BinarySearchTree <Customer, String> tree;
	private TreeIterator <Customer> sortedList;
	
	/**
	 * Default constructor
	 */
	public CustomerRoster()
	{
		tree = new BinarySearchTree();
	}
	
	/**
	 * Method that can add customers
	 * @param c as the customer object with info
	 */
	public void addCustomer(Customer c)
	{
		tree.insert(c);
	}
	
	/**
	 * Displays customer roster and makes sure the list is in order use an iterator
	 */
	public void displayRoster()
	{
		sortedList = new TreeIterator <Customer>(tree);
		sortedList.setInorder();
		
		while(sortedList.hasNext())
		{
			Customer c = sortedList.next();
			System.out.println(c.getKey() + "\t" + c.getName() + "\t" + c.getPhone());
		}
	}
	
	/**
	 * Deletes selected customer
	 * @param id given
	 */
	public void deleteCustomer(String id)
	{
		try
		{
			tree.delete(id);
		}
		catch(Exception e)
		{
			System.out.println("Customer doesnt exist.");
		}
	}
	
	/**
	 * Method that will search for a customer given an id
	 * @param id
	 * @return the selected customer at the id given
	 */
	public Customer searchCustomer(String id)
	{
		try
		{
			return tree.retrieve(id);
		}
		catch (Exception e)
		{
			System.out.println("Customer doesnt exist");
		}
		return null;
	}
	
	/**
	 * Updates customer info by providing the id and then changing the name and phonenumber
	 * @param id given
	 * @param name brand new name
	 * @param phoneNumber and new phonenumber for the customer
	 */
	public void updateCustomer(String id, String name, String phoneNumber)
	{
		try
		{
			Customer c = tree.retrieve(id);
			if(c != null)
			{
				c.setName(name);
				c.setPhone(phoneNumber);
			}
		}
		catch (Exception e)
		{
			System.out.println("Customer doesnt exist");
		}
	}
	
	/**
	 * Saves the new data entered or altered to the the file
	 */
	public void save()
	{
		String fileOutput = "assg9_CustomerRoster.txt"; 
		PrintWriter outputStream = null;
		try {
			outputStream = new PrintWriter(fileOutput);
			
			sortedList = new TreeIterator <Customer>(tree);
			sortedList.setInorder();
			
			while(sortedList.hasNext())
			{
				Customer c = sortedList.next();
				outputStream.println(c.getKey() + "\t" + c.getName() + "\t" + c.getPhone());
			}
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
		outputStream.close();
	}
	
	/**
	 * Properly reads the correct text file into the program
	 * @param filename given
	 */
	public void load(String filename)
	{
		filename = "assg9_CustomerRoster.txt";
		Scanner inputStream = null;
		String line = " ";
		String[] params;
		
		try {
			inputStream = new Scanner(new File(filename));
		}
		catch(FileNotFoundException e) {
			System.out.println("ERROR: File not found.");
			System.exit(1);
		}
		while (inputStream.hasNextLine())
		{
			line = inputStream.nextLine();
			params = line.split("\t");
			tree.insert(new Customer(params[0], params[1], params[2]));
			
		}
	}
	
	
}

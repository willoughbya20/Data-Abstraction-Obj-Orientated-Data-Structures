/**
 * Adam Willoughby
 * Main method that does all the menu options per the users choosing and will execute/use
 * the proper methods per the menu option choice.
 */

package assg9_willoughbya20;

import java.util.Scanner;

public class CustomerMIS {

	public static void main(String[] args) {
		
		String filename = "assg9_CustomerRoster.txt";
		
		BinarySearchTree<Customer, String>roster;
		CustomerRoster c1 = new CustomerRoster();
		c1.load(filename);
		
		int choice = 0;
		Scanner keyboard = new Scanner(System.in);
		Scanner continu = new Scanner(System.in);
		String input, id, name, phoneNumber;
		
		while(choice != 7)
		{
			menu();
			choice = keyboard.nextInt();
			keyboard.nextLine();
			switch(choice)
			{
			case 1:
				c1.displayRoster();
				System.out.println("\nPress enter to continue");
				input = continu.nextLine();
				if (input == "")
					break;
			case 2:
				System.out.println("Enter an id: ");
				id = keyboard.nextLine();
				if(c1.searchCustomer(id) == null)
				{
					System.out.println("Enter name: \n");
					name = keyboard.nextLine();
					System.out.println("Enter phone number: \n");
					phoneNumber = keyboard.nextLine();
					Customer c = new Customer(id, name, phoneNumber);
					c1.addCustomer(c);
					System.out.println("\nCustomer added.");
				}
				else
				{
					System.out.println("\nCustomer already exists");
				}
				System.out.println("\nPress enter to continue");
				input = continu.nextLine();
				if (input == "")
					break;
			case 3:
				System.out.println("\nEnter an id: ");
				id = keyboard.next();
				if(c1.searchCustomer(id) != null)
				{
					c1.deleteCustomer(id);
					System.out.println("\nCustomer removed");
				}
				else
				{
					System.out.println("Customer not found");
				}
				System.out.println("\nPress enter to continue");
				input = continu.nextLine();
				if (input == "")
					break;
			case 4:
				System.out.println("\nEnter an id: ");
				id = keyboard.nextLine();
				if(c1.searchCustomer(id) == null)
				{
					System.out.println("Customer does not exist.");
				}
				else
				{
					Customer c = c1.searchCustomer(id);
					System.out.println(c.getName() + "\t" + c.getPhone() + "\n");
				}
				
				System.out.println("\nPress enter to continue");
				input = continu.nextLine();
				if (input == "")
					break;
			case 5:
				System.out.println("Enter an id: ");
				id = keyboard.nextLine();
				if(c1.searchCustomer(id) == null)
				{
					System.out.println("Customer does not exist.");
				}
				else
				{
					Customer c = c1.searchCustomer(id);
					System.out.println("Enter a name: ");
					name = keyboard.nextLine();
					c.setName(name);
					System.out.println("Enter a phonenumebr: ");
					phoneNumber = keyboard.nextLine();
					c.setPhone(phoneNumber);
					System.out.println("\nInfo updated.\n");
				}
				System.out.println("\nPress enter to continue");
				input = continu.nextLine();
				if (input == "")
					break;
			case 6:
				c1.save();
				System.out.println("\nFile saved and System exited");
				System.exit(1);
				break;
			}
		}

	}
	
	/**
	 * Method that allows us to easily implement the menu
	 */
	private static void menu()
	{
		System.out.println("1. Display the roster \n2. Add a customer"
				+ "\n3. Delete a customer \n4. Search for a customer \n5. Update customer info"
				+ "\n6. Save to file and Exit");
	}

}

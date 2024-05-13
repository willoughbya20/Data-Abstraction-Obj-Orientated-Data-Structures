/**
 * Adam Willoughby
 * Main method program that has switch/case statements
 * that allow the user to pick menu options and run methods for testing
 */
package assg6_willougbya20;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentMIS {
	
	public static void main(String[] args) 
	{
		String filename = "assg6_data.txt";
		
		ArrayList<Student>list;
		StudentList s1 = new StudentList();
		s1.loadData(filename);
		
		int choice = 0;
		Scanner keyboard = new Scanner(System.in);
		Scanner continu = new Scanner(System.in);
		String input, id, name, standing, major;
		
		while (choice != 8)
		{
			menu();
			choice = keyboard.nextInt();
			switch(choice)
			{
			case 1:
				s1.displayRoster();
				System.out.println("\nPress enter to continue");
				input = continu.nextLine();
				if (input == "")
					break;
			case 2:
				System.out.println("Enter an id: ");
				id = keyboard.next();
				if (s1.searchForStudent(id) != null)
				{
					System.out.println("\n" + s1.searchForStudent(id));
				}
				else
					System.out.println("\nStudent not found");
				System.out.println("\nPress enter to continue");
				input = continu.nextLine();
				if (input == "")
					break;
			case 3:
				System.out.println("\nEnter an id: ");
				id = keyboard.next();
				if (s1.searchForStudent(id) == null)
				{
					System.out.println("Enter name: ");
					name = keyboard.next();
					System.out.println("Enter standing: ");
					standing = keyboard.next();
					System.out.println("Enter major: ");
					major = keyboard.next();
					s1.addStudent(id, name, standing, major);
					s1.save();
				}
				else
				{
					System.out.println("\nStudent already exists\n");

				}
				System.out.println("\nPress enter to continue");
				input = continu.nextLine();
				if (input == "")
					break;
			case 4:
				System.out.println("\nEnter an id: ");
				id = keyboard.next();
				if (s1.removeStudent(id))
				{
					System.out.println("\n Student removed");
					s1.save();
				}
				else
				{
					System.out.println("Student not found");
				}
				System.out.println("\nPress enter to continue");
				input = continu.nextLine();
				if (input == "")
					break;
				
			case 5:
				System.out.println("Enter a major");
				major = keyboard.next();
				list = s1.getStudentsByMajor(major);
				if(list.size() > 0)
				{
					for(Student stu : list)
					{
						System.out.println(stu);
					}
				}
				else
					System.out.println("No students matching that major");
				System.out.println("\nPress enter to continue");
				input = continu.nextLine();
				if (input == "")
					break;
			case 6:
				s1.sort();
				s1.save();
				System.out.println("Roster sorted and saved.");
				System.out.println("\nPress enter to continue");
				input = continu.nextLine();
				if (input == "")
					break;
			case 7:
				s1.save();
				System.out.println("\nRoster saved to file with any changes made.");
				System.out.println("\nPress enter to continue");
				input = continu.nextLine();
				if (input == "")
					break;
			case 8:
				System.out.println("Exiting System.");
				System.exit(1);
				break;
			default:
				System.out.println("\nInvalid number\n");
				break;
			}
		}
		keyboard.close();
		continu.close();
	}
	
	private static void menu()
	{
		System.out.println("1. Display the roster \n2. Search for a student by id"
				+ "\n3. Add a new student \n4. Remove a student \n5. Search for students by major"
				+ "\n6. Sort and save to file \n7. Save to file \n8. Exit");
	}
}



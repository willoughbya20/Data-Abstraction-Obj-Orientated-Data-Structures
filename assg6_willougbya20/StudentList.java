/**
 * Adam Willoughby
 * Class that holds our methods and is the base of how the program works
 */
package assg6_willougbya20;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StudentList implements StudentListInterface{
	
	Scanner inputStream = null;
	ArrayList<Student> studentRoster = new ArrayList<Student>();
	
	/**
	 * Constructor for our student list
	 */
	public StudentList()
	{
		@SuppressWarnings("unused")
		ArrayList<Student> studentRoster = new ArrayList<Student>();
	}
	/**
	 * Methods that loads the file and its data
	 * @param filename which holds the text document name
	 */
	public void loadData(String filename)
	{
		filename = "assg6_data.txt";
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
			params = line.split(",");
			studentRoster.add(new Student(params[0], params[1], params[2], params[3]));
			
		}
		
	}
	
	/**
	 * Method that displays student roster using loop
	 */
	public void displayRoster()
	{
		for(Student stu : studentRoster)
		{
			System.out.println(stu);
		}
	}

	/**
	 * Method will search for a given student ID and return
	 * @param searchID if its the same as the given
	 * then null if not
	 */
	@Override
	public Student searchForStudent(String searchID) {
		for(Student stu : studentRoster)
		{
			if (searchID.equals(stu.getId()))
			{
				return stu;
			}
		}
		return null;
	}
	/**
	 * Method that will add student to the list if the ID is not among the roster already
	 * @param id given the new Id
	 * @param name given the new name
	 * @param standing given the new year
	 * @param major given the new major
	 */
	@Override
	public boolean addStudent(String id, String name, String standing, String major) {
		for(Student stu : studentRoster)
		{
			if (id.equals(stu.getId()))
			{
				System.out.println("Student already exists");
				return false;
			}
		}
		studentRoster.add(new Student(id, name, standing, major));
		return true;
	}

	/**
	 * Method that will remove a certain student from the roster, returns false if 
	 * given ID is not found
	 * @param id given id of current student
	 */
	@Override
	public boolean removeStudent(String id) {
		
		for(Student stu : studentRoster)
		{
			if (id.equals(stu.getId()))
			{
				studentRoster.remove(stu);
				return true;
			}
		}
		return false;
		
	}
	
	/**
	 * Method that will create a new list of students all with the same major.
	 * @param major given the major of choice
	 */
	@Override
	public ArrayList<Student> getStudentsByMajor(String major) {
		
		ArrayList<Student> studentMajor = new ArrayList<Student>();
		
		for(Student stu : studentRoster)
		{
			if (major.equals(stu.getMajor()))
			{
				studentMajor.add(stu);
			}
		}
		return studentMajor;
	}

	/**
	 * Sorts the students by ID number
	 */
	@Override
	public void sort() {
		Collections.sort(studentRoster);
	}
	
	/**
	 * Saves the roster with any given changes and will print out a error message
	 * if the filename is not found correctly.
	 */
	@Override
	public void save() {
		
		String fileOutput = "asgg6_data.txt"; 
		PrintWriter outputStream = null;
		try {
			outputStream = new PrintWriter(new File(fileOutput));
			for(Student stu : studentRoster)
			{
				outputStream.println(stu.toString());
			}
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
		outputStream.close();
	}
	
}

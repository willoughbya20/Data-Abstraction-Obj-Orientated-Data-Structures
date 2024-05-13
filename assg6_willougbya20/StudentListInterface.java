/**
 * Adam Willoughby
 * An interface class with all the methods we created in the StudentList class
 */
package assg6_willougbya20;

import java.util.ArrayList;

public interface StudentListInterface {
	
	public void loadData(String filename);
	public void displayRoster();
	public Student searchForStudent(String searchID);
	public boolean addStudent(String id, String name, String standing, String major);
	public boolean removeStudent(String id);
	public ArrayList<Student> getStudentsByMajor(String major);
	public void sort();
	public void save();
}

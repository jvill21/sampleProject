import java.util.ArrayList;

/**
 * 
 * @author Michael Baca, Joshua Villegas, James Bias
 * @version 1.2 (11/17/2016)
 *
 */
public class Advisor extends User {

	private ArrayList<Student> studentList = new ArrayList<>();
	public ArrayList<Course> courseList = new ArrayList<>();
	
	public Student createStudent(String name){
		Student s = new Student(name);
		studentList.add(s);
		return s;
	}
	
	public void setPassword(Student s, String p){
		s.setPassword(p);
	}
}

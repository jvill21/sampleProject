import java.util.ArrayList;

/**
 * 
 * @author Michael Baca, Joshua Villegas, James Bias
 * @version 1.2 (11/17/2016)
 * 
 * Public class representing attributes of a student. This class extends the user class
 * to gain access to information such as the user's name and password. This class contains the 
 * attributes such as a students courses, and whether the student can graduate.
 *
 */
public class Student extends User {

	/**List of courses this student is currently registered for */
	public ArrayList<Course> courses = new ArrayList<>();
	/**boolean value representing if this student can graduate */
	public String graduate = "NO";
	
	/**
	 * adds course to list of registered classes
	 * @param c name of the course that this student will register for
	 */
	public void addCourse(Course c) {
		courses.add(c);
		c.studentsRegistered ++;
	}
	
	/**
	 * returns the list of courses this student is registered for
	 * @return all registered courses for this student
	 */
	public ArrayList<Course> getCourseList() {
		if(courses.size()==0){
			return null;
		}
		else{
			return courses;
		}
	}
	
	/**
	 * returns the number of courses this student is registered for
	 * @param s this student
	 * @return the number of courses this student is currently registered for
	 */
	public int studentCourseCount(Student s) {
		return s.courses.size();
	}
	
	/**
	 * allows a student to drop a course
	 * @param c the name of the course that this student wishes to drop
	 */
	public void dropCourse(Course c) {
		for (int i = 0; i < courses.size(); i++) {
			if (courses.get(i).courseName.equals(c.courseName)) {
				courses.remove(i);
				c.studentsRegistered --;
			}
		}
	}
	/**
	 * Returns true if the Student is registered for at least 1 class
	 * @return boolean
	 */
	public boolean isRegistered(){
		if(courses.size()>0){
			return true;
		}
		else{
			return false;
		}
	}
	/**
	 * constructor
	 * @param name the name of the student being created
	 */
	public Student(String name){
		userName=name;
	}
	/**
	 * default constructor
	 */
	public Student(){
		
	}
	
}

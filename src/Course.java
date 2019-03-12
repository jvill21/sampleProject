/**
 * 
 * @author Michael Baca, Joshua Villegas, James Bias
 * @version 1.2 (11/17/2016)
 *
 *Public class representing the different classes that are available.
 */
public class Course {

	/**name of this course */
	public String courseName = "";
	/**student capacity for this course */
	public int capacity = 40;
	/**number of students currently registered in this course */
	public int studentsRegistered = 0;
	/**students current grade in this course */
	public String grade = "N/A";
	
	/**constructs a new course
	 * @param n name of the course
	 */
	public Course(String n) {
		courseName = n;
	}
	
	/**
	 * Default Constructor
	 */
	public Course() {
		
	}
	
	/**
	 * returns the number of students currently enrolled in this course
	 * @return the number of students registered in this course
	 */
	public int courseSize() {
		return studentsRegistered;
	}
	
	/**
	 * returns true if the capacity of the Course is full
	 * @return boolean
	 */
	public boolean isFull(){
		if(studentsRegistered == capacity){
			return true;
		}
		else{
			return false;
		}
	}
}

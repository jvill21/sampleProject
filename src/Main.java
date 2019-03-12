
/**
 * 
 * @author Michael Baca, Joshua Villegas, James Bias
 * @version 1.2 (11/17/2016)
 * Main Method for the registration system. This method handles creating new student for testing,
 * as well as creating the system with all the possible classes a student can register for.
 *
 */
public class Main {

	
public static void main(String[] args) {
		
		Student student = new Student();
		student.setName("student");
		student.setPassword("password");
		
		
		Course c1 = new Course("Advanced Object Oriented Programming");
		Course c2 = new Course("Data Structures");
		Course c3 = new Course("Databases");
		Course c4 = new Course("Software 1");
		Course c5 = new Course("Software 2");
		Course c6 = new Course("Data Bases");
		Course c7 = new Course("Data Mining");
		Course c8 = new Course("Mobile Applications");
		Course c9 = new Course("Aritficial Intelligence");
		Course c10 = new Course("Computer Architecture");
		
		RegistrationSystem system = new RegistrationSystem();
		system.courseList.add(c1);
		system.courseList.add(c2);
		system.courseList.add(c3);
		system.courseList.add(c4);
		system.courseList.add(c5);
		system.courseList.add(c6);
		system.courseList.add(c7);
		system.courseList.add(c8);
		system.courseList.add(c9);
		system.courseList.add(c10);
		system.s = student;
		system.buildFrame();
	}
}

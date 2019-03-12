import static org.junit.Assert.*;

import org.junit.Test;

public class CourseTest {

	@Test
public void test() {
		
		Student a = new Student();
		Student b = new Student();
		Student c = new Student();
		Student d = new Student();
		
		Course e = new Course();
		
		a.addCourse(e);
		b.addCourse(e);
		c.addCourse(e);
		d.addCourse(e);
		
		assertEquals(4, e.courseSize());
		
		a.dropCourse(e);
		assertEquals(3, e.courseSize());
		e.studentsRegistered = 40;
		
		assertTrue(e.isFull());
		
		e.studentsRegistered--;
		
		assertFalse(e.isFull());
	}

}

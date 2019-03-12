import static org.junit.Assert.*;


import org.junit.Test;

public class StudentTest extends Student{

	@Test
public void test() {
		
		Student s1  = new Student();
		Student s2 = new Student();
		Course c = new Course();
		Course d = new Course();
		Course e = new Course();
		
		assertEquals(0, studentCourseCount(s1));
		assertFalse(s1.isRegistered());
		
		assertNull(s1.getCourseList());
		
		s1.addCourse(c);
		s2.addCourse(c);
		
		assertSame(s2.courses.get(0),s1.courses.get(0));
		assertNotSame(s1,s2);
		
		assertEquals(1, studentCourseCount(s1));
		
		assertTrue(s1.isRegistered());
		
		s1.dropCourse(c);
		assertEquals(0, studentCourseCount(s1));
		
		assertFalse(s1.isRegistered());
		
		s1.addCourse(d);
		s1.addCourse(e);
		
		assertEquals(2, studentCourseCount(s1));
		assertTrue(s1.isRegistered());
		
		s1.dropCourse(d);
		assertEquals(1, studentCourseCount(s1));
		assertTrue(s1.isRegistered());
		
		
		
	}

}

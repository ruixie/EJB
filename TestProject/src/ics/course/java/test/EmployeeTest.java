package ics.course.java.test;

import ics.course.java.Employee;
import junit.framework.TestCase;

public class EmployeeTest extends TestCase {

	String expectedName;
	String expectedAddress;
	String expectedPhone;
	Employee e1;
	Employee e2;

	public EmployeeTest(String name) {
		super(name);

	}

	public void setUp() throws Exception {
		super.setUp();
		expectedName = "Mats";
		expectedAddress = "Lund";
		expectedPhone = "12345";
		e1 = new Employee(expectedName, expectedAddress, expectedPhone);
		e2 = new Employee("Eva", "Malmš", "53453");
	}

	protected void tearDown() throws Exception {
		e1 = null;
		e2 = null;
	}

	public void testGetAddress() {
		assertNotNull(e1);
		assertEquals(expectedAddress, e1.getAddress());
	}

	public void testGetName() {
		assertEquals(expectedName, e1.getName());
	}

	public void testGetPhone() {
		assertEquals(expectedPhone, e1.getPhone());
	}

	public void testSetAddress() {
		String expectedAddress2 = "TestStad";
		e1.setAddress(expectedAddress2);
		assertEquals(expectedAddress2, e1.getAddress());
	}

	public void testSetName() {
		String expectedName2 = "Test";
		e1.setName(expectedName2);
		assertEquals(expectedName2, e1.getName());
	}

	public void testSetPhone() {
		String expectedPhone2 = "54321";
		e1.setPhone(expectedPhone2);
		assertEquals(expectedPhone2, e1.getPhone());
	}

	public void testEquals() {
		assertTrue(!e1.equals(null));
		assertEquals(e1, e1);

		assertTrue(!e1.equals(e2));
	}

}

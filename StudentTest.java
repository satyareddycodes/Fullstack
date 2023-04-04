package com.student.management;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

public class StudentTest {

	@Test
	public void testConstructor() {
		String name = "John Doe";
		String id = "12345";

		Student student = new Student(name, id);

		assertEquals(name, student.name);
		assertEquals(id, student.id);
	}

	@Test
	public void testUpdatePercentage() {
		Student student = new Student("John Doe", "12345");

		student.updatePercentage(90.0);
		assertEquals(90.0, student.percentage, 0.01);

		student.updatePercentage(80.0);
		assertEquals(85.0, student.percentage, 0.01);

		student.updatePercentage(70.0);
		assertEquals(80.0, student.percentage, 0.01);
	}

	@Test
	public void testEquals() {
		Student student1 = new Student("John Doe", "12345");
		Student student2 = new Student("Jane Smith", "67890");
		Student student3 = new Student("Alice Brown", "12345");

		assertTrue(student1.equals(student1));

		assertFalse(student1.equals(null));

		assertFalse(student1.equals("John Doe"));

		assertFalse(student1.equals(student2));

		assertTrue(student1.equals(student3));
	}

	@Test
	public void testCompareTo() {
		Student s1 = new Student("123", "John");
		Student s2 = new Student("123", "John");
		Student s3 = new Student("456", "Mary");
		assertEquals(0, s1.compareTo(s2));
		assertTrue(s2.compareTo(s3) < 0);
		assertFalse(s2.compareTo(s3) > 0);
	}
}

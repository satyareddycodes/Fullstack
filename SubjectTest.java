package com.package com.student.management;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.Test;
import static org.junit.Assert.*;

public class SubjectTestCases {

	@Test
	public void testSubjectConstructor() {

		Map<Student, Integer> results = new HashMap<>();
		results.put(new Student("Alice", "123"), 90);
		results.put(new Student("Bob", "456"), 80);

		Subject subject = new Subject("Math", results);

		assertEquals("Math", subject.getName());
		assertEquals(results, subject.getResults());
	}

	@Test
	public void testSubjectConstructorWithNoArguments() {

		Subject subject = new Subject();

		assertNull(subject.getName());
		// assertFalse(subject.getResults().isEmpty());
	}

	@Test
	public void testGetName() {
		Subject subject = new Subject();
		subject.setName("Mathematics");
		assertEquals("Mathematics", subject.getName());
		subject.setName("");
		assertEquals("", subject.getName());
		subject.setName(null);
		assertNull(subject.getName());
	}

	@Test
	public void testSetName() {

		Subject subject = new Subject("Math", null);

		subject.setName("Science");

		assertEquals("Science", subject.getName());
	}

	@Test
	public void testGetResults() {
		Subject subject = new Subject("Math",null);
		Map<Student, Integer> results = subject.getResults();
		//assertTrue(results.isEmpty());
	}

	@Test
	public void testSetResults() {

		Student student1 = new Student("Alice", "123");
		Student student2 = new Student("Bob", "456");

		Subject subject = new Subject("Math", new HashMap<>());

		Map<Student, Integer> newResults = new HashMap<>();
		newResults.put(student1, 90);
		newResults.put(student2, 85);

		subject.setResults(newResults);

		assertEquals(newResults, subject.getResults());
	}
	@Test
	public void testGetSortedResults() {
	    // Create some test data
	    Student s1 = new Student("John", "Doe");
	    Student s2 = new Student("Jane", "Doe");
	    Student s3 = new Student("Bob", "Smith");
	    Map<Student, Integer> results = new HashMap<>();
	    results.put(s1, 80);
	    results.put(s2, 90);
	    results.put(s3, 85);

	    Map<Student, Integer> expectedResults = new LinkedHashMap<>();
	    expectedResults.put(s2, 90);
	    expectedResults.put(s3, 85);
	    expectedResults.put(s1, 80);

	    Map<Student, Integer> actualResults = getSortedResults(results);
	    assertNotEquals(expectedResults, actualResults);
	}

	@Test
	public void testGetSortedResultsWithTies() {
	   
	    Student s1 = new Student("John", "Doe");
	    Student s2 = new Student("Jane", "Doe");
	    Student s3 = new Student("Bob", "Smith");
	    Map<Student, Integer> results = new HashMap<>();
	    results.put(s1, 80);
	    results.put(s2, 90);
	    results.put(s3, 85);
	    results.put(new Student("Alice", "Johnson"), 90);

	    Map<Student, Integer> expectedResults = new LinkedHashMap<>();
	    expectedResults.put(s2, 90);
	    expectedResults.put(new Student("Alice", "Johnson"), 90);
	    expectedResults.put(s3, 85);
	    expectedResults.put(s1, 80);

	    Map<Student, Integer> actualResults = getSortedResults(results);
	    assertNotEquals(expectedResults, actualResults);
	}

	private Map<Student, Integer> getSortedResults(Map<Student, Integer> results) {
		// TODO Auto-generated method stub
		return null;
	}

	@Test
	public void testGetSortedResultsWithEmptyInput() {
	    Map<Student, Integer> emptyInput = Collections.emptyMap();
	    Map<Student, Integer> actualResults = getSortedResults(emptyInput);
	    //assertTrue(actualResults.isEmpty());
	}

}

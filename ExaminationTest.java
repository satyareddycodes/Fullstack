package com.student.management;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

public class ExaminationTestCases {

	@Test
	public void testExaminationConstructor() {
		List<Subject> subjects = new ArrayList<>();
		subjects.add(new Subject("Mathematics", null));
		subjects.add(new Subject("Science", null));

		Examination exam = new Examination("Midterm", subjects);

		assertEquals("Midterm", exam.getName());
		assertEquals(subjects, exam.getSubjects());
	}

	@Test
	public void testExaminationNoArgConstructor() {
		Examination exam = new Examination();

		assertEquals(null, exam.getName());
		assertEquals(null, exam.getSubjects());
	}

	@Test
	public void testGetName() {
		Examination exam = new Examination("Midterm", null);

		assertEquals("Midterm", exam.getName());
	}

	@Test
	public void testSetName() {
		Examination exam = new Examination("Midterm", null);

		exam.setName("Final");

		assertEquals("Final", exam.getName());
	}

	@Test
	public void testGetSubjects() {

		List<Subject> subjects = new ArrayList<>();
		subjects.add(new Subject("Math", null));
		subjects.add(new Subject("Science", null));

		Examination exam = new Examination("Midterm", subjects);

		assertEquals(subjects, exam.getSubjects());
	}

	@Test
	public void testSetSubjects() {

		List<Subject> oldSubjects = new ArrayList<>();
		oldSubjects.add(new Subject("Math", null));
		oldSubjects.add(new Subject("Science", null));

		List<Subject> newSubjects = new ArrayList<>();
		newSubjects.add(new Subject("History", null));
		newSubjects.add(new Subject("English", null));

		Examination exam = new Examination("Midterm", oldSubjects);

		exam.setSubjects(newSubjects);

		assertEquals(newSubjects, exam.getSubjects());
	}

}
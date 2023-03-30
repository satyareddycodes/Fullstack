package com.student.management;

import java.util.List;

public class Examination {
	private String name;
	private List<Subject> subjects;
	public Examination(String name, List<Subject> subjects) {
		this.name = name;
		this.subjects = subjects;
	}
	public Examination() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Subject> getSubjects() {
		return subjects;
	}
	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}
	
}

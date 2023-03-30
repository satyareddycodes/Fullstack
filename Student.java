package com.student.management;
import java.util.Objects;

public class Student implements Comparable{
	String name;
	String id;
	double percentage;
	int examsAttended;
	public Student(String name, String id) {
		this.name = name;
		this.id = id;
	}
	public void updatePercentage(double percentage) {
		this.percentage = ((this.percentage*examsAttended)+(percentage))/(++examsAttended);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return id.equals(other.id);
	}
	@Override
	public int compareTo(Object o) {
		Student other = (Student)o;
		return id.compareTo(other.id);
	}
	
	
}
S
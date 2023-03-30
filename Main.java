package com.student.management;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Examination> exams = getDefaultData();
		int choice = 0;
		do {
			System.out.println("By defualt we have 4 student details and marks:");
			System.out.println(
					" Select you choice: \n1. Add Student \n2. Remove Student \n3. Subject Wise List \n4. Show All Records \n5. Show by Rank \n0. Exit");
			choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
			case 1:
				System.out.println("Enter Student Name: ");
				String name = sc.nextLine();
				System.out.println("Enter Student ID: ");
				String id = sc.nextLine();
				boolean isExists = isExists(exams, id);
				if (isExists) {
					System.out.println("Student already Exists");
				} else {
					int[] arr = new int[15];
					int i = 0;
					for (Examination e : exams) {
						System.out.println("Enter marks for " + name + " in " + e.getName());
						for (Subject sub : e.getSubjects()) {
							System.out.println("Enter marks in " + sub.getName());
							arr[i++] = sc.nextInt();
							sc.nextLine();
						}
					}
					Student s = new Student(name, id);
					addStudent(exams, s, arr);

				}
				break;

			case 2:
				System.out.println("Enter Student ID to Remove: ");
				String id1 = sc.nextLine();
				removeStudent(exams, id1);
				break;

			case 3:
				showSubjects(exams);
				int n = sc.nextInt();
				sc.nextLine();
				showExams(exams);
				int m = sc.nextInt();
				sc.nextLine();
				showSortedSubject(exams, n, m);
				break;
			case 4:
				showSorted(exams);
				break;

			case 5:
				showRankWise(exams);
				break;
			case 0:
				System.out.println("Thank you");
				break;
			default:
				System.out.println("Invalid Choice try again");
			}

		} while (choice != 0);

	}

	private static boolean isExists(List<Examination> exams, String id1) {
		Student s1 = new Student(null, id1);

		if (exams.get(0).getSubjects().get(0).getResults().containsKey(s1)) {
			return true;
		} else {
			return false;
		}

	}

	private static void showExams(List<Examination> exams) {
		int i = 1;
		System.out.println("Select Examination: ");
		for (Examination exm : exams) {
			System.out.println(i++ + ". " + exm.getName());
		}

	}

	private static void showSubjects(List<Examination> exams) {
		int i = 1;
		System.out.println("Select Subject: ");
		Examination exm = exams.get(0);
		for (Subject sub : exm.getSubjects()) {
			System.out.println(i++ + ". " + " " + sub.getName());
		}
	}

	private static void addStudent(List<Examination> exams, Student s, int[] arr) {
		int i = 0;
		for (Examination e : exams) {
			for (Subject subject : e.getSubjects()) {
				subject.getResults().put(s, arr[i++]);
			}
		}
	}

	private static void removeStudent(List<Examination> exams, String id) {
		if (!isExists(exams, id)) {
			System.out.println("Student does not exists");
		} else {
			Student s = new Student(null, id);
			for (Examination e : exams) {
				for (Subject subject : e.getSubjects()) {
					subject.getResults().remove(s);
				}
			}
		}
	}

	private static void showSorted(List<Examination> exams) {

		System.out.println("All Examinations Data : ");
		for (Examination exm : exams) {
			System.out.println("Exam_Name : " + exm.getName());
			for (Subject sub : exm.getSubjects()) {
				System.out.println("Subject_Name :" + sub.getName());
				System.out.println("\t\tName \t Id \tMarks");
				for (Student stu : sub.getSortedResults().keySet()) {
					System.out.println("\t\t " + stu.name + " \t " + stu.id + " \t " + sub.getResults().get(stu));
				}
			}
		}
	}

	private static void showSortedSubject(List<Examination> exams, int n, int m) {
		Examination exm = exams.get(m - 1);
		Subject sub = exm.getSubjects().get(n - 1);
		System.out.println("Data for " + sub.getName() + " in " + exm.getName());
		for (Student stu : sub.getSortedResults().keySet()) {
			System.out.println("\t\t " + stu.name + " \t " + stu.id + " \t " + sub.getResults().get(stu));
		}

	}

	private static void showRankWise(List<Examination> exams) {
		List<Student> students = new ArrayList<>(exams.get(0).getSubjects().get(0).getResults().keySet());
		for (Student student : students) {
			int marks = 0;
			for (Examination e : exams) {
				for (Subject subject : e.getSubjects()) {
					marks = marks + (subject.getResults().get(student));
				}
			}
			student.percentage = (marks / (15));
		}
		Collections.sort(students, new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				return (int) (o2.percentage - o1.percentage);
			}
		});
		System.out.println("Name\t Id \t Percentage");
		for (Student s : students) {
			System.out.println(s.name + "\t " + s.id + "\t " + s.percentage);

		}
	}

	private static Set<Student> getDefaultStudent() {

		Set<Student> students = new HashSet<>();
		students.add(new Student("raja", "101"));
		students.add(new Student("satya", "102"));
		students.add(new Student("vijay", "103"));
		students.add(new Student("giri", "104"));
		return students;
	}

	private static List<Examination> getDefaultData() {

		List<Student> sts = new ArrayList<>(getDefaultStudent());

		String name1 = "Engilsh";
		Map<Student, Integer> results1 = new TreeMap<>();
		results1.put(sts.get(0), 90);
		results1.put(sts.get(1), 70);
		results1.put(sts.get(2), 60);
		results1.put(sts.get(3), 50);

		String name2 = "Maths";
		Map<Student, Integer> results2 = new TreeMap<>();
		results2.put(sts.get(0), 98);
		results2.put(sts.get(1), 78);
		results2.put(sts.get(2), 77);
		results2.put(sts.get(3), 96);

		String name3 = "Science";
		Map<Student, Integer> results3 = new TreeMap<>();
		results3.put(sts.get(0), 87);
		results3.put(sts.get(1), 89);
		results3.put(sts.get(2), 68);
		results3.put(sts.get(3), 79);

		String name4 = "Social";
		Map<Student, Integer> results4 = new TreeMap<>();
		results4.put(sts.get(0), 76);
		results4.put(sts.get(1), 56);
		results4.put(sts.get(2), 45);
		results4.put(sts.get(3), 78);

		String name5 = "Tamil";
		Map<Student, Integer> results5 = new TreeMap<>();
		results5.put(sts.get(0), 67);
		results5.put(sts.get(1), 54);
		results5.put(sts.get(2), 67);
		results5.put(sts.get(3), 45);

		Subject sub1 = new Subject(name1, results1);
		Subject sub2 = new Subject(name2, results2);
		Subject sub3 = new Subject(name3, results3);
		Subject sub4 = new Subject(name4, results4);
		Subject sub5 = new Subject(name5, results5);
		List<Subject> subs1 = new ArrayList<>();
		subs1.add(sub1);
		subs1.add(sub2);
		subs1.add(sub3);
		subs1.add(sub4);
		subs1.add(sub5);
		Examination e1 = new Examination("Quarterly", subs1);

		Map<Student, Integer> results6 = new TreeMap<>();
		results6.put(sts.get(0), 56);
		results6.put(sts.get(1), 57);
		results6.put(sts.get(2), 47);
		results6.put(sts.get(3), 68);

		Map<Student, Integer> results7 = new TreeMap<>();
		results7.put(sts.get(0), 84);
		results7.put(sts.get(1), 38);
		results7.put(sts.get(2), 76);
		results7.put(sts.get(3), 48);

		Map<Student, Integer> results8 = new TreeMap<>();
		results8.put(sts.get(0), 89);
		results8.put(sts.get(1), 59);
		results8.put(sts.get(2), 95);
		results8.put(sts.get(3), 69);

		Map<Student, Integer> results9 = new TreeMap<>();
		results9.put(sts.get(0), 69);
		results9.put(sts.get(1), 60);
		results9.put(sts.get(2), 95);
		results9.put(sts.get(3), 80);

		Map<Student, Integer> results10 = new TreeMap<>();
		results10.put(sts.get(0), 69);
		results10.put(sts.get(1), 30);
		results10.put(sts.get(2), 96);
		results10.put(sts.get(3), 95);

		Subject sub6 = new Subject(name1, results6);
		Subject sub7 = new Subject(name2, results7);
		Subject sub8 = new Subject(name3, results8);
		Subject sub9 = new Subject(name4, results9);
		Subject sub10 = new Subject(name5, results10);
		List<Subject> subs2 = new ArrayList<>();
		subs2.add(sub6);
		subs2.add(sub7);
		subs2.add(sub8);
		subs2.add(sub9);
		subs2.add(sub10);
		Examination e2 = new Examination("Half Yearly", subs2);

		Map<Student, Integer> res1 = new HashMap<>();
		res1.put(sts.get(0), 68);
		res1.put(sts.get(1), 96);
		res1.put(sts.get(2), 96);
		res1.put(sts.get(3), 59);

		Map<Student, Integer> res2 = new TreeMap<>();
		res2.put(sts.get(0), 48);
		res2.put(sts.get(1), 89);
		res2.put(sts.get(2), 56);
		res2.put(sts.get(3), 45);

		Map<Student, Integer> res3 = new TreeMap<>();
		res3.put(sts.get(0), 68);
		res3.put(sts.get(1), 92);
		res3.put(sts.get(2), 91);
		res3.put(sts.get(3), 92);

		Map<Student, Integer> res4 = new TreeMap<>();
		res4.put(sts.get(0), 74);
		res4.put(sts.get(1), 87);
		res4.put(sts.get(2), 82);
		res4.put(sts.get(3), 81);

		Map<Student, Integer> res5 = new TreeMap<>();
		res5.put(sts.get(0), 46);
		res5.put(sts.get(1), 81);
		res5.put(sts.get(2), 93);
		res5.put(sts.get(3), 82);

		Subject s1 = new Subject(name1, res1);
		Subject s2 = new Subject(name2, res2);
		Subject s3 = new Subject(name3, res3);
		Subject s4 = new Subject(name4, res4);
		Subject s5 = new Subject(name5, res5);
		List<Subject> subs3 = new ArrayList<>();
		subs3.add(s1);
		subs3.add(s2);
		subs3.add(s3);
		subs3.add(s4);
		subs3.add(s5);
		Examination e3 = new Examination("Annually", subs3);
		List<Examination> exams = new ArrayList<>();
		exams.add(e1);
		exams.add(e2);
		exams.add(e3);
		return exams;
	}

}

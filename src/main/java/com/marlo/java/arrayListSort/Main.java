package com.marlo.java.arrayListSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {

	static class Student {
		private int id;
		private String fname;
		private double cgpa;

		public Student(int id, String fname, double cgpa) {
			super();
			this.id = id;
			this.fname = fname;
			this.cgpa = cgpa;
		}

		public int getId() {
			return id;
		}

		public String getFname() {
			return fname;
		}

		public double getCgpa() {
			return cgpa;
		}
	}

	public static void main(String[] args) {
		double a = 2.54;
		double b = 2.55;
		System.out.println(a * 100);
		System.out.println(b * 100);
		System.out.println((int) (b * 100 - a * 100));
		Scanner in = new Scanner(System.in).useLocale(Locale.US);
		int testCases = Integer.parseInt(in.nextLine());

		List<Student> studentList = new ArrayList();
		while (testCases > 0) {
			int id = in.nextInt();
			String fname = in.next();
			double cgpa = in.nextDouble();

			Student st = new Student(id, fname, cgpa);
			studentList.add(st);

			testCases--;
		}

		// Solución mía:
		/*
		studentList.sort((s1, s2) -> {
			return s1.getCgpa() == s2.getCgpa()
					? (!s1.getFname().equals(s2.getFname()) ? s1.getFname().compareTo(s2.getFname())
							: s1.getId() - s2.getId()) 
					: s1.getCgpa() > s2.getCgpa() ? -1 : 1;
		});
		*/
		// Solución aprovechando Java 8 (interesante):
		Collections.sort(studentList, 
				Comparator.comparing(Student :: getCgpa).reversed().
	              thenComparing(Student :: getFname)
	              .thenComparing(Student :: getId));
		for (Student st : studentList) {
			System.out.println(st.getFname());
		}
		
	}
	
	public int add(int... numbers) {
        int result = 0;
        for (int i = 0; i < numbers.length; i++) {
            result += numbers[i];
        }
        return result;
    }

}

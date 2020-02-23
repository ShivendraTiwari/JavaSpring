package com.shiv.hibernate.demo2;

import java.util.List;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.shiv.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		// create Session
		Session session = factory.getCurrentSession();

		try {
			
			// use the session object to save java object

			// create a student object

			// start a transaction
			session.beginTransaction();

			// Queries students
			List<Student> theStudents = session.createQuery("from Student").getResultList();

			// display the students
			/* 
			 for (Student tempStudent : theStudents) {
				System.out.println(tempStudent);
			}
			*/
			//Given Below,display statement compressed through refactoring the above for loop
			//select all above for loop code and then click refactor->extract method->change method name to displayStudents
				displayStudents(theStudents);

			// query Students:lastName:'Doe'
			theStudents = session.createQuery("from Student s where s.lastName='Doe'").getResultList();
			// System.out.println(theStudents);

			// display the Students
			System.out.println("\n\nstudent who have last name of Doe");
			displayStudents(theStudents);

			// query students:lastName='Doe' OR firstName='Daffy'
			theStudents = session.createQuery("from Student s where" + " s.lastName='Doe' OR s.firstName='Daffy'")
					.getResultList();

			System.out.println("\n\nstudent having Doe and Daffy as lastName and FirstName respectively");
			displayStudents(theStudents);

			// query students:email ends with @luv2code.com
			theStudents = session.createQuery("from Student s where" + "" + " " + "s.email LIKE '%gmail" + ".com'")
					.getResultList();

			System.out.println("\n\nstudent having email ends with @gmail.com ");
			displayStudents(theStudents);

			System.out.println("Done");
			// commit transaction
			session.getTransaction().commit();

		} finally {
			factory.close();

		}
	}

	private static void displayStudents(List<Student> theStudents) {
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

}

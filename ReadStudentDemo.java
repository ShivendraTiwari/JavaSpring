package com.shiv.hibernate.demo2;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.shiv.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		// create Session
		Session session = factory.getCurrentSession();

		try {
			// use the session object to save java object

			// create a student object
			System.out.println("create new student object");
			Student tempStudent = new Student("Daffy", "Duck", "paul@luv2code.com");

			// start a transaction
			session.beginTransaction();

			// save the student object
			System.out.println("save the student...");
			System.out.println(tempStudent);
			session.save(tempStudent);

			// commit transaction
			session.getTransaction().commit();

			// My New Code

			// find out the student's id:primary key
			System.out.println("saved student.Generate id: " + tempStudent.getId());

			// now get a new session
			session = factory.getCurrentSession();
			session.beginTransaction();

			// retrieve student based on the id:primary key
			System.out.println("\nGetting student with id:" + tempStudent.getId());
			Student myStudent = session.get(Student.class, tempStudent.getId());
			System.out.println("Get Complete:" + myStudent);

			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!");

		} finally {
			factory.close();

		}
	}

}

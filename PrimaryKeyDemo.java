package com.shiv.hibernate.demo2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.shiv.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		// create Session
		Session session = factory.getCurrentSession();

		try {
			// use the session object to save java object

			// create 3 student object
			System.out.println("create 3 student object");
			Student tempStudent = new Student("Shivendra", "Tiwari", "shivendra@luv2code.com");
			Student tempStudent2 = new Student("John", "Doe", "john@luv2code.com");
			Student tempStudent3 = new Student("Bonita", "Applebum", "bonita@luv2code.com");
			// start a transaction
			session.beginTransaction();
			// save the student object
			System.out.println("save the student...");
			session.save(tempStudent);
			session.save(tempStudent2);
			session.save(tempStudent3);
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done");

		} finally {
			factory.close();

		}
	}

}

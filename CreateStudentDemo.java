package com.shiv.hibernate.demo2;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.shiv.hibernate.demo.entity.Student;

public class CreateStudentDemo {

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
			Student tempStudent = new Student("paul", "wall", "paul@luv2code.com");

			// start a transaction
			session.beginTransaction();
			// save the student object
			System.out.println("save the student...");
			session.save(tempStudent);
			// commit transaction
			session.getTransaction().commit();

		} finally {
			factory.close();

		}
	}

}

package com.shiv.hibernate.assignment;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.shiv.hibernate.entity.Employee;

public class MainApplication {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();

		try {
			// use session object to save java object
			// create a student object
			System.out.println("create an employee object");
			Employee theEmployee = new Employee("shivendra1", "Tiwari1", "Microsoft");

			// begin transaction
			session.beginTransaction();

			// save the session
			session.save(theEmployee);

			// close transaction
			session.getTransaction().commit();
			
			System.out.println("Done");

		} finally {
			factory.close();
		}
	}

}

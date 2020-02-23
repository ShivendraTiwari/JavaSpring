package com.shiv.hibernate.assignment;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.shiv.hibernate.entity.Employee;

public class RetreiveThroughPrimaryKey {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();

		try {
			// create 3 object
			System.out.println("create 3 employee");
			Employee theEmployee = new Employee("Shivendra", "Tiwari", "Microsoft");
			Employee theEmployee2 = new Employee("Shivangi", "Tiwari", "Google");
			Employee theEmployee3 = new Employee("Manas", "Shukla", "Apple");

			// start a transaction
			session.beginTransaction();

			// save employee object
			System.out.println("save the employee");
			session.save(theEmployee);
			session.save(theEmployee2);
			session.save(theEmployee3);

			// commit Transaction
			session.getTransaction().commit();
			System.out.println("Done");

		} finally {
			factory.close();
		}
	}

}

package com.shiv.hibernate.assignment;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.shiv.hibernate.entity.Employee;

public class FindThroughQueryObjects {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();

		try {

			// start transaction
			session.beginTransaction();
			List<Employee> theEmployee = session.createQuery("from Employee").getResultList();
			displayList(theEmployee);

			theEmployee = session.createQuery("from Employee s where s.company='Microsoft'").getResultList();

			System.out.println("Employee name,where company is Microsoft ");
			displayEmployeeList(theEmployee);

			session.getTransaction().commit();
			System.out.println("Done");
		} finally {
			factory.close();
		}
		
	}

	private static void displayEmployeeList(List<Employee> theEmployee) {
		for (Employee tempEmployee : theEmployee) {
			System.out.println(tempEmployee);
		}
	}

	private static void displayList(List<Employee> theEmployee) {
		displayEmployeeList(theEmployee);
	}

}

package com.shiv.hibernate.assignment;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.shiv.hibernate.entity.Employee;

public class DeleteEmployee {

	public static void main(String[] args) { 

		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class).buildSessionFactory();
		Session session=factory.getCurrentSession();
		
		try {
	int empId=1;
			//start transaction
		
		session.beginTransaction();
		System.out.println("Deleting Employee on the basis of "+empId);
		Employee theEmployee=session.get(Employee.class, empId);
		
		System.out.println("Delelting employee id=2 ");
		session.createQuery("Delete from Employee where id=2 ").executeUpdate();
		
		//close connection
		session.getTransaction().commit();
		
		System.out.println("Done");
		}
	finally {
		factory.close();
	}
	}
	

}

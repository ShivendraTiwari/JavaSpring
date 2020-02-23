package com.shiv.hibernate.demo2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.shiv.hibernate.demo.entity.Instructor;
import com.shiv.hibernate.demo.entity.InstructorDetail;
import com.shiv.hibernate.demo.entity.Student;

public class DeleteDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		// create Session
		Session session = factory.getCurrentSession();

		try {
		
			

			// start a transaction
			session.beginTransaction();

			//get instructor by primary key/id
			int theId=1;
			Instructor tempInstructor=new Instructor();

		

			// commit transaction
			session.getTransaction().commit();
			
		} finally {
			factory.close();

		}
	}

}

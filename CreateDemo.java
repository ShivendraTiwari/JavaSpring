package com.shiv.hibernate.demo2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.shiv.hibernate.demo.entity.Instructor;
import com.shiv.hibernate.demo.entity.InstructorDetail;
import com.shiv.hibernate.demo.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		// create Session
		Session session = factory.getCurrentSession();

		try {
			// create the objects
		/*	Instructor tempInstructor = new Instructor("shivendra", "Tiwari", "shivendra.tiwari4u@gmail.com");

			InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.luv2code.com/youtube",
					"LUV 2 Code!!!");

			Instructor tempInstructor = new Instructor("shivangi", "Tiwari", "shivangiu@gmail.com");

			InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.luv2code.com/youtube",
					"Painting");
			// associate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);

			// start a transaction
			session.beginTransaction();

			// save the instuctor
			// note:this will also save the details object
			// because of CascadeType.ALL

			System.out.println("saving instructor:" + tempInstructor);
			session.save(tempInstructor);

			// commit transaction
			session.getTransaction().commit();
			
		} finally {
			factory.close();

		}
	}

}

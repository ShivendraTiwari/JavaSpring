package com.shiv.hibernate.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="instructor")
public class Instructor {

	     // annotate the class as an entity and map to db table

		// define the tables

		// annotate the fields with db column names
	
	   //**setup mapping to InstructorDetail Entity 	

		// create constructors

		// generate getter/setter methods

		// generate to String() method
	
	@Id	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	public int id;
	@Column(name="first_name")
	public String firstName;
	@Column(name="last_name")
	public String lastName;
	@Column(name="email")
	public String email;
	

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="instructor_detail_id")
	private InstructorDetail instructorDetail;
	
	public Instructor() {
		
	}
	public Instructor(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
    
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		id=id;
	}
	public String getFirstName() {
		return firstName;
		
	}
	public void setFirstName(String firstName) {
		this.firstName=firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName=lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email=email;
	}
	
	 public InstructorDetail getInstructorDetail() {
		return instructorDetail;
	}
	public void setInstructorDetail(InstructorDetail instructorDetail) {
		this.instructorDetail = instructorDetail;
	}
	public String toString() {
		 return "Instructor [id="+id+",firstName="+firstName+",LastName="+lastName+",email="+email+"]"; 
	 }


	
}

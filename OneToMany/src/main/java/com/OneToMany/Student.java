package com.OneToMany;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Student {
	@Id
	int srollno;
	String sname;
	Date   dob;
	String dept;
	String address;
	long mobileno;
	@OneToMany
	List<Book> book;
	
	
	public Student(int srollno, String sname, Date dob, String dept, String address, long mobileno, List<Book> book) {
		super();
		this.srollno = srollno;
		this.sname = sname;
		this.dob = dob;
		this.dept = dept;
		this.address = address;
		this.mobileno = mobileno;
		this.book = book;
	}

	public Student() {
		
	}
	
	

}

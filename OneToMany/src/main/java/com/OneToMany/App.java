package com.OneToMany;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
    	Scanner sc=new Scanner(System.in);
    	int srollno;
    	String sname;
    	Date   dob=null;
    	String dept;
    	String address;
    	long mobileno;
    	System.out.println("\nEnter the Student rollno: ");
    	srollno=sc.nextInt();
    	sc.nextLine();
    	System.out.println("\nEnter the Student sname: ");
    	sname=sc.nextLine();
    	System.out.println("\nEnter the Student Department: ");
    	dept=sc.nextLine();
    	System.out.println("\nEnter the Student Date of Birth(eg:03/04/2000): ");
    	try {
			dob=new SimpleDateFormat("dd/MM/yyyy").parse(sc.nextLine());
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
    	System.out.println("\nEnter the Student mobileno: ");
    	mobileno=sc.nextLong();
    	sc.nextLine();
    	System.out.println("\nEnter the Student address: ");
    	address=sc.nextLine();
    	
    	
    	List<Book> list=new ArrayList<>();
   
    		  int bid;
    		  String bname;
    		  String author;
    		  double price;
    		  String edition;
    		  Date dateofpublish=null;
    		  System.out.println("\nEnter the book id: ");
    		  bid=sc.nextInt();
    		  sc.nextLine();
    		  System.out.println("\nEnter the book name: ");
    		  bname=sc.nextLine();
    		  System.out.println("\nEnter the book Author: ");
    		  author=sc.nextLine();
    		  System.out.println("\nEnter the book price: ");
    		  price=sc.nextDouble();
    		  System.out.println("\nEnter the book edition: ");
    		  edition=sc.nextLine();
    		  sc.nextLine();
    		  System.out.println("\nEnter the book date of publish : ");
    		  try {
				dateofpublish=new SimpleDateFormat("dd/MM/yyyy").parse(sc.nextLine());
			} catch (ParseException e) {
				
				e.printStackTrace();
			}
    		  Book book=new Book(bid, bname, author, price, edition, dateofpublish);
    		  list.add(book);
    		 
    	
    	 Student student= new Student(srollno, sname, dob, dept, address, mobileno, list);
    	 
    	 Configuration con=new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Book.class);
    	 SessionFactory sf=con.buildSessionFactory();
    	 
    	 Session session=sf.openSession();
    	 Transaction tx=session.beginTransaction();
    	 session.persist(student);
    	 session.persist(book);
    	
    	 tx.commit();
    }
}

package com.OneToMany;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Book {
  @Id
  int bid;
  String bname;
  String author;
  double price;
  String edition;
  Date dateofpublish;
  
public Book(int bid, String bname, String author, double price, String edition, Date dateofpublish) {
	super();
	this.bid = bid;
	this.bname = bname;
	this.author = author;
	this.price = price;
	this.edition = edition;
	this.dateofpublish = dateofpublish;
}
  public Book() {
	
}
  
}

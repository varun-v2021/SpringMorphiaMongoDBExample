package com.example.onlineservice.entity;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;

@Entity("books")
public class Book {
	@Id
	private ObjectId id;
	private String title;
	@Property("published") // equivalent to @Column in ORM like Hibernate
	private String publicationDate;

	// No args Constructor
	public Book() {}
	
	public Book(String title, String publicationDate) {
		this.title = title;
		this.publicationDate = publicationDate;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(String publicationDate) {
		this.publicationDate = publicationDate;
	}

}
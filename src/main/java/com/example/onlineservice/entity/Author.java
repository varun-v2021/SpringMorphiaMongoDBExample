package com.example.onlineservice.entity;

import java.util.Set;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Field;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Index;
import org.mongodb.morphia.annotations.Indexes;
import org.mongodb.morphia.annotations.Reference;

@Entity("authors") //Representing top level document

//By default morphia will use classname as collection name
//Hence all author instances will be saved into authors

@Indexes({ @Index(fields = { @Field("name") }) })

//The @Indexes annotation lists which indexes Morphia should create. 
//In this instance, we’re defining an index named name on the field name with the default ordering of ascending

public class Author {
	@Id
	private ObjectId id;
	private String name;
	@Reference
	private Set<Book> books;

	/*	@Reference
	 * This annotation is telling Morphia that this field refers to other Morphia mapped entities
	 * */
	
	public Author() {}
	
	// No args Constructor
	public Author(String name) {
		this.name = name;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

}

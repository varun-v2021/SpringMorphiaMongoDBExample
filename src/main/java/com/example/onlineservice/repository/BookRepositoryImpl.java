package com.example.onlineservice.repository;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.query.UpdateOperations;
import org.mongodb.morphia.query.UpdateResults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.onlineservice.entity.Book;
import com.mongodb.WriteResult;

@Repository
public class BookRepositoryImpl {
	@Autowired
	private Datastore datastore;

	public Key<Book> create(Book book) {
		return datastore.save(book);
	}

	public Book read(ObjectId id) {
		return datastore.get(Book.class, id);
	}

	public UpdateResults update(Book book, UpdateOperations<Book> operations) {
		return datastore.update(book, operations);
	}

	public WriteResult delete(Book book) {
		return datastore.delete(book);
	}

	public UpdateOperations<Book> createOperations() {
		return datastore.createUpdateOperations(Book.class);
	}
}

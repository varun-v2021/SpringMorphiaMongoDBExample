package com.example.onlineservice.repository;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.query.UpdateOperations;
import org.mongodb.morphia.query.UpdateResults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.onlineservice.entity.Author;
import com.mongodb.WriteResult;

@Repository
public class AuthorRepositoryImpl {
	@Autowired
	private Datastore datastore;

	public Key<Author> create(Author author) {
		return datastore.save(author);
	}

	public Author read(ObjectId id) {
		return datastore.get(Author.class, id);
	}

	public UpdateResults update(Author author, UpdateOperations<Author> operations) {
		return datastore.update(author, operations);
	}

	public WriteResult delete(Author author) {
		return datastore.delete(author);
	}

	public UpdateOperations<Author> createOperations() {
		return datastore.createUpdateOperations(Author.class);
	}
}

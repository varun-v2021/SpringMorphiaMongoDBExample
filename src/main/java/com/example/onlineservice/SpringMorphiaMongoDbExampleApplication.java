package com.example.onlineservice;

import java.time.LocalDate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.mongodb.morphia.query.UpdateOperations;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.onlineservice.entity.Author;
import com.example.onlineservice.entity.Book;
import com.example.onlineservice.repository.AuthorRepositoryImpl;
import com.example.onlineservice.repository.BookRepositoryImpl;

@SpringBootApplication
public class SpringMorphiaMongoDbExampleApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringMorphiaMongoDbExampleApplication.class, args);

		BookRepositoryImpl bookRepo = ctx.getBean(BookRepositoryImpl.class);
		AuthorRepositoryImpl authorRepo = ctx.getBean(AuthorRepositoryImpl.class);

		Book ci = new Book("Continous Integration", "21/11/2019:22:18:00");
		bookRepo.create(ci);

		Author julius = new Author("Ceaser");
		julius.setBooks(Stream.of(ci).collect(Collectors.toSet()));
		authorRepo.create(julius);

		Author read = authorRepo.read(julius.getId());

		UpdateOperations<Author> ops = authorRepo.createOperations().set("name", "Devidas");
		authorRepo.update(read, ops);

		read.setName("Yashraj");
		authorRepo.create(read);

		authorRepo.delete(julius);
	}

}

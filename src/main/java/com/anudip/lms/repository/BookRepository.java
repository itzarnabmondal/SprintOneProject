package com.anudip.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anudip.lms.model.Book;

/**
 * A repository interface for the Book entity.
 * 
 * This interface extends Spring Data JPA's JpaRepository interface, which
 * provides various methods for interacting with a database such as findAll,
 * findById, save, delete, etc.
 * 
 * The Book entity is used to represent a book in the library management system,
 * and the primary key of the Book entity is an integer.
 * 
 * @since v1.0
 * @see Book
 * @see JpaRepository
 */
public interface BookRepository extends JpaRepository<Book, Integer> {

}

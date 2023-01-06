package com.anudip.lms.dao;

import java.util.List;
import java.util.UUID;

import com.anudip.lms.model.Book;

/**
 * An interface for a data access object (DAO) that performs operations on the
 * Book entity.
 * 
 * The Book entity is used to represent a book in the library management system.
 * 
 * @since v1.0
 * @see Book
 */

public interface BookDao {

    /**
     * Adds a new book to the database.
     * 
     * @param book the book to add
     */
    void addBook(Book book);

    /**
     * Removes a book from the database by its ID.
     * 
     * @param id the ID of the book to remove
     */
    void removeBook(int id);

    /**
     * Returns a list of all books in the database.
     * 
     * @return a list of all books in the database
     */
    List<Book> getAllBooks();

    /**
     * Updates a book in the database.
     * 
     * @param existingBookId the ID of the book to update
     * @param newBook        the updated book
     */
    void updateBook(int existingBookId, Book newBook);

    /**
     * Returns a list of books that match the given search keyword.
     * 
     * @param keyWord the search keyword
     * @return a list of books that match the given search keyword
     */
    List<Book> search(String keyWord);

    /**
     * Adds a customer to the list of customers who have checked out a specific
     * book.
     * 
     * @param bookId     the ID of the book the customer has checked out
     * @param customerId the UUID of the customer
     * @return true if the customer was successfully added, false if the customer
     *         was already in the list or any other error like invalid book or
     *         customer id
     */
    boolean addCustomer(int bookId, UUID customerId);
}

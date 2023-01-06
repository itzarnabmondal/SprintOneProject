package com.anudip.lms.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.anudip.lms.daoImpl.BookDaoImpl;
import com.anudip.lms.daoImpl.CustomerDaoImpl;
import com.anudip.lms.model.Book;
import com.anudip.lms.model.Customer;
import com.anudip.lms.service.Search;

/**
 * RestController for handling book related requests.
 */
@RestController
public class MainController {

    /**
     * The BookDaoImpl instance.
     * This is used to perform CRUD operations on book objects.
     */
    @Autowired
    private BookDaoImpl bookDao;

    /**
     * The CustomerDaoImpl instance.
     * This is used to perform CRUD operations on customer objects.
     */
    @Autowired
    private CustomerDaoImpl customerDao;

    /**
     * The Search instance.
     * This is used to search for books based on keywords.
     */
    @Autowired
    private Search search;

    /**
     * Handles request for the home page of the application.
     * 
     * @return a message indicating that this is the home page of LMS
     */
    @GetMapping("/")
    public String home() {
        return "Welcome to LMS";
    }

    /**
     * Handles request to add a new book.
     * 
     * @param book the new book object to be added
     */
    @PostMapping("/addbook")
    public void addBook(@RequestBody Book book) {
        bookDao.addBook(book);
    }

    /**
     * 
     * Adds a customer to the database.
     * 
     * @param customer the customer to be added
     */
    @PostMapping("/addcustomer")
    public void addCustomer(@RequestBody Customer customer) {
        customerDao.addCustomer(customer);
    }

    /**
     * Handles request to delete a book.
     * 
     * @param id the id of the book to be deleted
     */
    @DeleteMapping("/deletebook{id}")
    public void removeBook(@PathVariable int id) {
        bookDao.removeBook(id);
    }

    /**
     * 
     * Deletes a customer from the database.
     * 
     * @param id the ID of the customer to be deleted
     */
    @PostMapping("/deletecustomer/{id}")
    public void deleteCustomer(@PathVariable UUID id) {
        customerDao.removeCustomer(id);
    }

    /**
     * Handles request to update a book.
     * 
     * @param id      the id of the book to be updated
     * @param newBook the updated book object
     */
    @PutMapping("/updatebook{id}")
    public void updateBook(@PathVariable int id, @RequestBody Book newBook) {
        bookDao.updateBook(id, newBook);
    }

    /**
     * 
     * Updates a customer in the database.
     * 
     * @param id       the ID of the customer to be updated
     * @param customer the updated customer information
     */
    @PutMapping("/updatecustomer/{id}")
    public void updateCustomer(@PathVariable UUID id, @RequestBody Customer customer) {
        customerDao.updateCustomer(id, customer);
    }

    /**
     * Returns a list of all books.
     *
     * @return a list of all books
     */
    @GetMapping("/getallbook")
    public List<Book> getAllBook() {
        return bookDao.getAllBooks();
    }

    /**
     * Returns a list of books that match the given keyword.
     *
     * @param keyword the keyword to search for
     * @return a list of books that match the given keyword
     */
    @GetMapping("/search/{keyword}")
    public List<Book> searchBook(@PathVariable String keyword) {
        return search.searchBooks(keyword);
    }

    /**
     * Adds the given customer to the book with the given book ID.
     * Returns 200 OK if the customer was successfully added,
     * or 400 Bad Request if the operation failed.
     *
     * @param bookid     the ID of the book to add the customer to
     * @param customerid the ID of the customer to be added
     * @return 200 OK if the customer was successfully added, 400 Bad Request
     *         otherwise
     */
    @PutMapping("/addcustomertobook{bookid}/customerid{customerid}")
    public ResponseEntity<Void> addCustomerToBook(@PathVariable int bookid, @PathVariable UUID customerid) {
        if (bookDao.addCustomer(bookid, customerid)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * Adds the given book to the customer with the given customer ID.
     * Returns 200 OK if the book was successfully added,
     * or 400 Bad Request if the operation failed.
     *
     * @param customerid the ID of the customer to add the book to
     * @param bookid     the ID of the book to be added
     * @return 200 OK if the book was successfully added, 400 Bad Request otherwise
     */
    @PutMapping("/addbooktocustomer{customerid}/customerid{bookid}")
    public ResponseEntity<Void> addBookToCustomer(@PathVariable int customerid, @PathVariable UUID bookid) {
        if (customerDao.addBook(bookid, customerid)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

}
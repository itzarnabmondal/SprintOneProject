package com.anudip.lms.daoImpl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.anudip.lms.dao.BookDao;
import com.anudip.lms.model.Book;
import com.anudip.lms.model.Customer;
import com.anudip.lms.repository.BookRepository;
import com.anudip.lms.repository.CustomerRepository;
import com.anudip.lms.service.Search;

/**
 * 
 * This class is responsible for the database operations related to the
 * {@link Book} entity.
 * 
 * It implements the {@link BookDao} interface and uses the
 * {@link BookRepository} for CRUD operations.
 * 
 * 
 * @see BookDao
 * @see BookRepository
 * @since v1.0
 */
@Repository
public class BookDaoImpl implements BookDao {

    /**
     * 
     * The {@link BookRepository} instance for CRUD operations on the {@link Book}
     * entity.
     */
    @Autowired
    private BookRepository bookRepository;

    /**
     * 
     * The {@link CustomerRepository} instance for CRUD operations on the
     * {@link Customer}
     * entity.
     */
    @Autowired
    private CustomerRepository customerRepository;

    /**
     * 
     * The {@link Search} service instance for searching books.
     */
    @Autowired
    private Search search;

    /**
     * 
     * This method is used to save a new {@link Book} in the database.
     * 
     * @param book the {@link Book} object to be saved in the database
     */
    @Override
    public void addBook(Book book) {
        bookRepository.save(book);
    }

    /**
     * This method is used to remove a book from the database.
     * 
     * @param id ID of the book to be removed from the database.
     */
    @Override
    public void removeBook(int id) {
        bookRepository.deleteById(id);
    }

    /**
     * This method is used to retrieve all books from the database.
     * 
     * @return List of all the books in the database.
     */
    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    /**
     * This method is used to update a book in the database.
     * 
     * @param existingBookId ID of the book to be updated in the database.
     * @param newBook        Book object containing the updated book details.
     */
    @Override
    public void updateBook(int existingBookId, Book newBook) {
        Book existingBook = bookRepository.findById(existingBookId).orElse(null);
        if (existingBook != null) {
            existingBook.setName(newBook.getName());
            existingBook.setAuthor(newBook.getAuthor());
            existingBook.setCategory(newBook.getCategory());
            existingBook.setDescription(newBook.getDescription());
            existingBook.setPrice(newBook.getPrice());
            bookRepository.save(existingBook);
        }
    }

    /**
     * This method is used to search for books in the database.
     * 
     * @param keyWord Keyword to be used for searching the books.
     * 
     * @return List of books matching the search keyword.
     */
    @Override
    public List<Book> search(String keyWord) {
        return search.searchBooks(keyWord);
    }

    /**
     * 
     * Adds a customer to the list of customers who have checked out a specific
     * book.
     * 
     * @param bookId     the ID of the book the customer has checked out
     * @param customerId the UUID of the customer
     * @return true if the customer was successfully added, false if the customer or
     *         book could not be found in the repository
     */
    @Override
    public boolean addCustomer(int bookId, UUID customerId) {
        Book book = bookRepository.findById(bookId).orElse(null);
        Customer customer = customerRepository.findById(customerId).orElse(null);
        if (book != null && customer != null) {
            book.getCustomers().add(customer);
            bookRepository.save(book);
            return true;
        } else {
            return false;
        }
    }
}
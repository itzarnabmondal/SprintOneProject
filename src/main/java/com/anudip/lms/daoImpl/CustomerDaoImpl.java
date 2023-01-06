package com.anudip.lms.daoImpl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.anudip.lms.dao.CustomerDao;
import com.anudip.lms.model.Book;
import com.anudip.lms.model.Customer;
import com.anudip.lms.repository.BookRepository;
import com.anudip.lms.repository.CustomerRepository;

/**
 * 
 * CustomerDaoImpl is an implementation of the CustomerDao interface that
 * 
 * uses a CustomerRepository for performing CRUD operations on Customer
 * 
 * objects.
 * 
 * @since v1.0
 */
@Repository
public class CustomerDaoImpl implements CustomerDao {

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
     * The {@link BookRepository} instance for CRUD operations on the {@link Book}
     * entity.
     */
    @Autowired
    private BookRepository bookRepository;

    /**
     * 
     * Constructs a new CustomerDaoImpl object and sets the customerRepository
     * field to the provided customerRepository.
     * 
     * @param customerRepository the CustomerRepository to use for performing CRUD
     *                           operations
     */
    public CustomerDaoImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    /**
     * 
     * Saves the provided customer to the repository.
     * 
     * @param customer the Customer object to save
     */
    @Override
    public void addCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    /**
     * 
     * Removes the customer with the provided id from the repository.
     * 
     * @param id the id of the Customer object to remove
     */
    @Override
    public void removeCustomer(UUID id) {
        customerRepository.deleteById(id);
    }

    /**
     * 
     * Updates the customer with the provided id with the new customer information.
     * If a customer with the provided id does not exist, no action is taken.
     * 
     * @param existingCustomerId the id of the Customer object to update
     * @param newCustomer        the updated Customer object
     */
    @Override
    public void updateCustomer(UUID existingCustomerId, Customer newCustomer) {
        Customer existingCustomer = customerRepository.findById(existingCustomerId).orElse(null);
        if (existingCustomer != null) {
            existingCustomer.setName(newCustomer.getName());
            existingCustomer.setPhone(newCustomer.getPhone());
            existingCustomer.setAddress(newCustomer.getAddress());
            customerRepository.save(existingCustomer);
        }
    }

    /**
     * 
     * Adds a book to the list of books checked out by a customer.
     * 
     * @param customerId the UUID of the customer
     * 
     * @param bookId     the ID of the book to add
     * 
     * @return true if the book was added to the customer's list, false if the
     *         customer or book could not be found in the repository
     */
    @Override
    public boolean addBook(UUID customerId, int bookId) {
        Customer customer = customerRepository.findById(customerId).orElse(null);
        Book book = bookRepository.findById(bookId).orElse(null);

        if (customer != null && book != null) {
            customer.getBooks().add(book);
            customerRepository.save(customer);
            return true;
        } else {
            return false;
        }

    }
}
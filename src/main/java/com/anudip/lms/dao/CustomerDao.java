package com.anudip.lms.dao;

import java.util.UUID;

import com.anudip.lms.model.Customer;

/**
 * 
 * An interface for a data access object (DAO) that performs operations on the
 * Customer entity.
 * 
 * The Customer entity is used to represent a customer in the library management
 * system.
 * 
 * @since v1.0
 * 
 * @see Customer
 */
public interface CustomerDao {

    /**
     * 
     * Adds a new customer to the database.
     * 
     * @param customer the customer to add
     */
    void addCustomer(Customer customer);

    /**
     * 
     * Removes a customer from the database by its ID.
     * 
     * @param id the ID of the customer to remove
     */
    void removeCustomer(UUID id);

    /**
     * 
     * Updates a customer in the database.
     * 
     * @param existingCustomerId the ID of the customer to update
     * @param newCustomer        the updated customer
     */
    void updateCustomer(UUID existingCustomerId, Customer newCustomer);

    /**
     * 
     * Adds a book to the list of books checked out by a customer.
     * 
     * @param customerId the UUID of the customer
     * @param bookId     the ID of the book to add
     * @return true if the book was added to the customer's list, false if the
     *         customer already had the book
     */
    boolean addBook(UUID customerId, int bookId);
}

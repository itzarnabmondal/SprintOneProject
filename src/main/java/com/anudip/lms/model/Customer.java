package com.anudip.lms.model;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

/**
 * Represents a customer in the database.
 * 
 * @since v1.0
 */
@Entity
@Table(name = "customers")
public class Customer {

    /** The unique identifier for this customer. */
    @Id
    private UUID id;

    /** The name of this customer. */
    private String name;

    /** The phone number of this customer. */
    private long phone;

    /** The address of this customer. */
    private String address;

    /**
     * The books purchased by this customer.
     * 
     * This field is lazily fetched and the relationship is managed using the
     * {@link CascadeType#PERSIST} and {@link CascadeType#MERGE} cascade types. A
     * join table
     * called "customer_book" is used to store the relationships between customers
     * and books,
     * with the "customer_id" column representing the customers and the "book_id"
     * column
     * representing the books.
     */
    @ManyToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "customer_book", joinColumns = {
            @jakarta.persistence.JoinColumn(name = "customer_id") }, inverseJoinColumns = {
                    @jakarta.persistence.JoinColumn(name = "book_id") })
    private Set<Book> books = new HashSet<>();

    /**
     * Constructs a new {@code Customer} with a unique ID generated using a
     * {@link UUID}.
     */
    public Customer() {
        this.id = UUID.randomUUID();
    }

    /**
     * Returns the unique identifier for this customer.
     * 
     * @return the ID of this customer
     */
    public UUID getId() {
        return id;
    }

    /**
     * Sets the unique identifier for this customer.
     * 
     * @param id the new ID for this customer
     */
    public void setId(UUID id) {
        this.id = id;
    }

    /**
     * Returns the name of this customer.
     * 
     * @return the name of this customer
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of this customer.
     * 
     * @param name the new name of this customer
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the phone number of this customer.
     * 
     * @return the phone number of this customer
     */
    public long getPhone() {
        return phone;
    }

    /**
     * Sets the phone number of this customer.
     * 
     * @param phone the new phone number of this customer
     */
    public void setPhone(Long phone) {
        this.phone = phone;
    }

    /**
     * Returns the address of this customer.
     * 
     * @return the address of this customer
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address of this customer.
     * 
     * @param address the new address of this customer
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Returns the books purchased by this customer.
     * 
     * @return the books purchased by this customer
     */
    public Set<Book> getBooks() {
        return books;
    }

    /**
     * Sets the books purchased by this customer.
     * 
     * @param books the new set of books purchased by this customer
     */
    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    /**
     * Returns a string representation of this customer.
     * 
     * @return a string representation of this customer
     */
    @Override
    public String toString() {
        return "Customer [id=" + id + ", name=" + name + ", phone=" + phone + ", address=" + address + ", books="
                + books + "]";
    }
}

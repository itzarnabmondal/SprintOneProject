package com.anudip.lms.model;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

/**
 * 
 * Represents a book in the database.
 * 
 * @since v1.0
 */
@Entity
@Table(name = "books")
public class Book {

    /** The unique identifier for this book. */
    @Id
    private int id;

    /** The name of this book. */
    private String name;

    /** The author of this book. */
    private String author;

    /** The category this book belongs to. */
    private String category;

    /** A brief description of this book. */
    private String description;

    /** The price of this book. */
    private int price;

    /**
     * The customers who have purchased this book.
     * 
     * This field is lazily fetched and the relationship is managed using the
     * {@link CascadeType#PERSIST} and {@link CascadeType#MERGE} cascade types. The
     * "books" field
     * in the {@link Customer} class is used to store the relationships between
     * customers and books.
     */
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "books", cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    private Set<Customer> customers = new HashSet<>();

    /**
     * 
     * Constructs a new {@code Book} with a unique ID generated using a
     * {@link ThreadLocalRandom}.
     */
    public Book() {
        this.id = ThreadLocalRandom.current().nextInt(100000, 1000000);
    }

    /**
     * 
     * Returns the unique identifier for this book.
     * 
     * @return the ID of this book
     */
    public int getId() {
        return id;
    }

    /**
     * 
     * Returns the name of this book.
     * 
     * @return the name of this book
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * Sets the name of this book.
     * 
     * @param name the new name of this book
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * Returns the author of this book.
     * 
     * @return the author of this book
     */
    public String getAuthor() {
        return author;
    }

    /**
     * 
     * Sets the author of this book.
     * 
     * @param author the new author of this book
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * 
     * Returns the category this book belongs to.
     * 
     * @return the category of this book
     */
    public String getCategory() {
        return category;
    }

    /**
     * 
     * Sets the category of this book.
     * 
     * @param category the new category of this book
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * 
     * Returns a brief description of this book.
     * 
     * @return the description of this book
     */
    public String getDescription() {
        return description;
    }

    /**
     * 
     * Sets the description of this book.
     * 
     * @param description the new description of this book
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Returns the price of this book.
     * 
     * @return the price of this book
     */
    public int getPrice() {
        return price;
    }

    /**
     * Sets the price of this book.
     * 
     * @param price the new price of this book
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * Returns the customers who have purchased this book.
     * 
     * @return the customers who have purchased this book
     */
    public Set<Customer> getCustomers() {
        return customers;
    }

    /**
     * Sets the customers who have purchased this book.
     * 
     * @param customers the new set of customers who have purchased this book
     */
    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }

    /**
     * Returns a string representation of this book.
     * 
     * @return a string representation of this book
     */
    @Override
    public String toString() {
        return "Book [id=" + id + ", name=" + name + ", author=" + author + ", category=" + category + ", description="
                + description + ", price=" + price + ", customers=" + customers + "]";
    }

}
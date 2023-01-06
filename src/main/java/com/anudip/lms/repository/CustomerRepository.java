package com.anudip.lms.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anudip.lms.model.Customer;

/**
 * A repository interface for the Customer entity.
 * 
 * This interface extends Spring Data JPA's JpaRepository interface, which
 * provides various methods for interacting with a database such as findAll,
 * findById, save, delete, etc.
 * 
 * The Customer entity is used to represent a customer in the library management
 * system, and the primary key of the Customer entity is a UUID (universally
 * unique identifier).
 * 
 * @since v1.0
 * @see Customer
 * @see JpaRepository
 */
public interface CustomerRepository extends JpaRepository<Customer, UUID> {

}

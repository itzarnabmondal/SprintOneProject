package com.anudip.lms.service;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anudip.lms.model.Book;
import com.anudip.lms.repository.BookRepository;

/**
 * The Search service class is responsible for searching books in the
 * repository.
 * 
 * @since v1.0
 *
 */
@Service
public class Search {

    @Autowired
    private BookRepository bookRepository;

    /**
     * Searches for books in the repository that match the given keyword.
     * 
     * @param keyword the keyword to search for
     * @return a list of books that match the keyword, or null if no such books are
     *         found
     */
    public List<Book> searchBooks(String keyword) {

        // list to store the raw search results
        List<Book> rawSearchResult = new ArrayList<>();

        // retrieve all books from the repository
        List<Book> books = bookRepository.findAll();

        // if the keyword is numeric, search for a book by id
        if (isNumeric(keyword)) {

            Book book = searchById(books, Integer.parseInt(keyword));

            if (book != null) {
                // add the book to the raw search result list if it is found
                rawSearchResult.add(book);
            }
        } else {

            // if the keyword is not numeric, search by name, author, and description
            rawSearchResult.addAll(searchByName(books, keyword));
            rawSearchResult.addAll(searchByAuthor(books, keyword));
            rawSearchResult.addAll(searchByDescription(books, keyword));
        }

        // if the raw search result list is not empty, deduplicate it if necessary and
        // return it
        if (rawSearchResult.size() > 0) {
            if (rawSearchResult.size() > 1) {
                return removeDuplicates(rawSearchResult);
            } else {
                return rawSearchResult;
            }
        } else {
            // return null if no books are found
            return null;
        }
    }

    public static boolean isNumeric(String input) {

        // try to parse the input as an integer
        try {

            Integer.parseInt(input);
            // if successful, return true
            return true;

        } catch (Exception e) {
            // if not successful, return false
            return false;
        }
    }

    /**
     * Searches for a book in the given list by its id.
     * 
     * @param books the list of books to search in
     * @param id    the id of the book to search for
     * @return the book with the specified id, or null if no such book is found
     */
    private Book searchById(List<Book> books, int id) {

        // use a stream to search for a book with the specified id
        // if found, return it; otherwise, return null
        return books.stream()
                .filter(book -> book.getId() == id)
                .findFirst()
                .orElse(null);
    }

    /**
     * Searches for books in the given list whose name contains the given keyword.
     * 
     * @param books   the list of books to search in
     * @param keyword the keyword to search for in the name of the books
     * @return a list of books whose name contains the keyword
     */
    private List<Book> searchByName(List<Book> books, String keyword) {

        // use a stream to search for books whose name contains the keyword
        // collect the results into a list and return it
        return books.stream()
                .filter(book -> book.getName()
                        .contains(keyword))
                .collect(Collectors.toList());
    }

    /**
     * Searches for books in the given list whose author contains the given keyword.
     * 
     * @param books   the list of books to search in
     * @param keyword the keyword to search for in the author of the books
     * @return a list of books whose author contains the keyword
     */
    private List<Book> searchByAuthor(List<Book> books, String keyword) {

        // use a stream to search for books whose author contains the keyword
        // collect the results into a list and return it
        return books.stream()
                .filter(book -> book.getAuthor()
                        .contains(keyword))
                .collect(Collectors.toList());
    }

    /**
     * Searches for books in the given list whose description contains the given
     * keyword.
     * 
     * @param books   the list of books to search in
     * @param keyword the keyword to search for in the description of the books
     * @return a list of books whose description contains the keyword
     */
    private List<Book> searchByDescription(List<Book> books, String keyword) {

        // use a stream to search for books whose description contains the keyword
        // collect the results into a list and return it
        return books.stream()
                .filter(book -> book.getDescription()
                        .contains(keyword))
                .collect(Collectors.toList());
    }

    /**
     * Removes duplicate elements from the given list.
     * 
     * @param list the list to deduplicate
     * @return a new list with no duplicate elements
     */
    private List<Book> removeDuplicates(List<Book> list) {

        // create a set to store the unique elements
        Set<Book> set = new LinkedHashSet<>();

        // add all the elements from the list to the set
        set.addAll(list);

        // create a new list from the set and return it
        return new ArrayList<>(set);
    }

}
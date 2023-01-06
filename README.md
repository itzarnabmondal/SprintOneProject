# Library Management System

>  A Simple easy to use library management system REST API build using Spring Boot and Secured by Spring Security allows users to perform various operations related to books and customers

## Features
Using this API an user will be able to :

- Add books to the library by providing details such as the title, author, and publication year.
Update the details of a book, such as its title or author, by providing the book's ID.
- Remove a book from the library by providing its ID.
- Add customers to the system by providing their personal details such as name, address, and phone number.
- Update the personal details of a customer, such as their name or address, by providing the customer's ID.
- Remove a customer from the system by providing their ID.
- Assign a book to a customer by providing the book's ID and the customer's ID.
- Search for books by keyword.
- Secure the API with Spring security, allowing only admins to access all operations after providing login details.
- The API allows users to perform these operations via HTTP requests, such as POST, PUT, and DELETE. The API returns appropriate responses, such as success or error messages, in the form of JSON data.

## Used Technologies
>This project was made possible thanks to the use of several open source software packages. We would like to express our gratitude to the developers and maintainers of these tools.

- [ Java-17 ] - An amazing programming language 
- [Spring-Boot] - A framework for humans
- [Spring Data JPA] - Library that allows for easy implementation of JPA
- [Spring Security] - For enterprise level security
- [Mysql 8] - Great RBMS for storing data
- [visual Studio Code] - As an awsome text editor

And of course this project itself is open source with a public repository on GitHub.

## Installation
This project requires JDK 17+, Mysql Server and and IDE with Spring Boot support to run.
Clone this git to get the compleate project
```
git clone
```

## User Instructions
#
### NOTE
> If you have trouble configuring the security parameters with a tool like Postman, you can comment out the spring-boot-starter-security and spring-security-test dependencies in the pom.xml file and dont't forget to comment out the ```com/anudip/lms/authentication/AdminDetails.java``` file to avoid errors.
> **Boom** 🔥 Now to can call Api's via postman or similar tools without any authentaction :)

> At the moment, we are using in-memory authentication to authenticate admins. The username and password hash for all admins are hardcoded in a hashmap inside the ```com/anudip/lms/authentication/AdminDetails.java``` file.


### Add a new book
- Method: POST
- API URL: http://localhost:8080/addbook
- Body (JSON)
```json
{
  "name" : "Book Title",
  "author": "Book Author",
  "category" : "Book Category",
  "description" : "Book Description",
  "price": "Book Price"
}
```
### Add a new customer
- Method: POST
- API URL: http://localhost:8080/addcustomer
- Body (JSON)
```json
{
  "name" : "Customer Name",
  "address" : "Customer Address",
  "phoneNumber" : "Phone Number"
}
```

### Delete a book
Method: DELETE
API URL: http://localhost:8080/deletebook/{existing-bookid}

### Update a book's details
- Method: PUT
- API URL: http://localhost:8080/updatebook/{existing-book-id}
- Body (JSON)
```json
{
  "name" : "Updated Name",
  "author" : "Updated Author",
  "category" : "Updated Category",
  "description" : "Updated Description",
  "price": "Updated Price"
}
```

### Update a customer's details
- Method: PUT
- API URL: http://localhost:8080/updatecustomer/existing-customer-id
- Body (JSON)
```json
{
  "name" : "Updated Customer Name",
  "address" : "Updated Customer Address",
  "phoneNumber" : "Updated Phone Number"
}
```

### Search for a book
- Method: GET
- API URL: http://localhost:8080/search/keyword
- **keyword** can be anything like book id, book name, author name or some word of book description

### Assign a customer to a book
- Method: PUT
- API URL: http://localhost:8080/addcustomertobook/existing-book-id/existing-customer-id

### Assign a book to a customer
- Method: PUT
- API URL: http://localhost:8080/addbooktocustomer/existing-customer-id/existing-book-id


## Contact Developer
> If you have any questions or suggestions please don't hesitate to contact the developer at arnabmondal@duck.com it would be our pleasure if you ware to make contact with us :)

## Contributors
- Bidisha Sahoo : bidishasahoo98@gmail.com
- Pritam Das : priatmdas022002@gmail.com
- Puja Sarkar : sarkarpuja2k@gmail.com
- Rohit Maity : rohit.maity@hotmail.com
- Tiyasha Naskar : tiyasanaskar113@gmail.com

## License
⚖ [**MIT**](https://opensource.org/licenses/MIT)

Compleately FREE And OPEN SOURCE, **Hell Yeah! :)**

##### Made with 💗 from kolkata

package week4Project;

import java.util.ArrayList;
import java.util.List;

public class BookManager {
    // List to store all books
    private List<Book> books;

    // Constructor initializes the book list
    public BookManager() {
        this.books = new ArrayList<>();
    }

    // Adds a new book to the list if ISBN is unique
    public boolean addBook(Book book) {
        //Check if a book with the same ISBN already exists
        for (Book b : books) {
            if (b.getIsbn().equalsIgnoreCase(book.getIsbn())) {
                return false; // Duplicate ISBN found
            }
        }
        books.add(book);  // Add the book to the list
        return true;
    }

    // Displays all books in the system
    public void displayBooks() {
        System.out.println("All Books: ");
        for (Book book : books) {
            System.out.println("--------------------------");
            System.out.println(book);
        }
    }

    // Searches for books by title (case-insensitive, trims whitespace)
    public void searchBookByTitle(String title) {
        boolean found = false;
        for (Book book : books) {
            if (book.getName().trim().equalsIgnoreCase(title.trim())) {
                System.out.println("Found Books:");
                System.out.println("--------------------------");
                System.out.println(book);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Book not found!");
        }
    }

    // Checks out a book if available, using ISBN
    public void checkOutBookByIsbn(String isbn) {
        boolean bookCheckedOut = false;
        for (Book book : books) {
            if (book.getIsbn().equalsIgnoreCase(isbn)) {
                if (book.isAvailable()) {
                    book.setAvailable(false); // Mark as checked out
                    System.out.println("Book checked out successfully!");
                } else {
                    System.out.println("Sorry, this book is already checked out.");
                }
                bookCheckedOut = true;
                break;
            }
        }
        if (!bookCheckedOut) {
            System.out.println("No book found with this ISBN.");
        }
    }

    // Returns a previously checked out book using ISBN
    public void returnBookByIsbn(String isbn) {
        boolean bookReturned = false;
        for (Book book : books) {
            if (book.getIsbn().equalsIgnoreCase(isbn)) {
                if (!book.isAvailable()) {
                    book.setAvailable(true);  // Mark as available again
                    System.out.println("Book returned successfully!");
                } else {
                    System.out.println("This book was not checked out!");
                }
                bookReturned = true;
                break;
            }
        }
        if (!bookReturned) {
            System.out.println("No book found with this ISBN.");
        }
    }
}

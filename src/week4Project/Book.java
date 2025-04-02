package week4Project;

public class Book {

    // Fields for book properties
    private String name;
    private String author;
    private String isbn;
    private boolean isAvailable;  // Indicates whether the book is available for checkout


    // Constructor to initialize a book with all attributes
    public Book(String name, String author, String isbn, boolean isAvailable) {
        this.name = name;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = isAvailable;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public boolean isAvailable() {
        return isAvailable;

    }

        @Override
        public String toString () {
            return "Title: " + name + "\n" +
                    "Author: " + author + "\n" +
                    "ISBN: " + isbn + "\n" +
                    "Status: " + (isAvailable ? "Available" : "Not Available");

    }
}
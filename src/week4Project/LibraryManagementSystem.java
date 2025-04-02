package week4Project;

import java.util.Scanner;

public class LibraryManagementSystem {

    public static void main(String[] args) {

        System.out.println("Welcome to Library Management System!");

        Scanner scanner = new Scanner(System.in);
        boolean running = true;  // Flag to control main loop

        BookManager bookManager = new BookManager();  // Book manager to handle book operations

        while (running) {

            printMenu(); // Display the menu options

            int choice = scanner.nextInt();  // User selects an option
            scanner.nextLine();  // Consume the leftover newline character

            switch (choice) {

                case 1:
                    addBook(scanner, bookManager);
                    break;

                case 2:
                    bookManager.displayBooks();
                    break;

                case 3:
                    searchBook(scanner, bookManager);
                    break;

                case 4:
                    checkOutBook(scanner, bookManager);
                    break;

                case 5:
                    returnBook(scanner, bookManager);
                    break;

                case 6:
                    System.out.println("Thank you for using the Library Management System!");
                    running = false;  // Exit the loop
                    break;

                default:
                    System.out.println("You have logged in incorrectly!");
            }
        }
        scanner.close();
    }

    // Method to add a book
    private static void addBook(Scanner scanner, BookManager bookManager) {
        System.out.println("Enter book title: ");
        String bookTitle = scanner.nextLine();

        System.out.println("Enter author name: ");
        String author = scanner.nextLine();

        System.out.println("Enter ISBN: ");
        String isbn = scanner.nextLine();

        // Attempt to add book and show appropriate message
        boolean added = bookManager.addBook(new Book(bookTitle, author, isbn, true));
        if (added) {
            System.out.println("Book added successfully!");
        } else {
            System.out.println("A book with this ISBN already exists!");
        }
    }

    // Method to search a book by title
    private static void searchBook(Scanner scanner, BookManager bookManager) {
        System.out.println("Enter book title to search:");
        String searchTitle = scanner.nextLine().trim();
        bookManager.searchBookByTitle(searchTitle);
    }

    // Method to check out a book using ISBN
    private static void checkOutBook(Scanner scanner, BookManager bookManager) {
        System.out.println("Enter the ISBN of the book you want to check out: ");
        String checkoutIsbn = scanner.nextLine();
        bookManager.checkOutBookByIsbn(checkoutIsbn);
    }

    // Method to return a book using ISBN
    private static void returnBook(Scanner scanner, BookManager bookManager) {
        System.out.println("Enter the ISBN of the book you want to return: ");
        String returnIsbn = scanner.nextLine();
        bookManager.returnBookByIsbn(returnIsbn);
    }

    // Method to display the menu options
    private static void printMenu() {
        System.out.println("\nPlease select an option:");
        System.out.println("1. Add a new book");
        System.out.println("2. Display all books");
        System.out.println("3. Search for a book by title");
        System.out.println("4. Check out a book");
        System.out.println("5. Return a book");
        System.out.println("6. Exit");
    }
}
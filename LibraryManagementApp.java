import java.util.HashMap;
import java.util.Scanner;

class Book {
    private String title;
    private String author;
    private boolean isBorrowed;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isBorrowed = false;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void borrowBook() {
        if (!isBorrowed) {
            isBorrowed = true;
        }
    }

    public void returnBook() {
        if (isBorrowed) {
            isBorrowed = false;
        }
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", Borrowed: " + (isBorrowed ? "Yes" : "No");
    }
}

public class LibraryManagementApp {

    public static void main(String[] args) {
        HashMap<Integer, Book> library = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            // Display menu
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Search Book by ID");
            System.out.println("4. Borrow Book");
            System.out.println("5. Return Book");
            System.out.println("6. Remove Book");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Add a book
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    int bookId = library.size() + 1; // Auto-generate unique ID
                    library.put(bookId, new Book(title, author));
                    System.out.println("Book added with ID: " + bookId);
                    break;

                case 2:
                    // View all books
                    System.out.println("\nLibrary Books:");
                    if (library.isEmpty()) {
                        System.out.println("No books in the library.");
                    } else {
                        library.forEach((id, book) -> System.out.println("ID: " + id + " - " + book));
                    }
                    break;

                case 3:
                    // Search book by ID
                    System.out.print("Enter book ID to search: ");
                    int searchId = scanner.nextInt();
                    if (library.containsKey(searchId)) {
                        System.out.println("Book Details: " + library.get(searchId));
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;

                case 4:
                    // Borrow a book
                    System.out.print("Enter book ID to borrow: ");
                    int borrowId = scanner.nextInt();
                    if (library.containsKey(borrowId)) {
                        Book bookToBorrow = library.get(borrowId);
                        if (bookToBorrow.isBorrowed()) {
                            System.out.println("Sorry, the book is already borrowed.");
                        } else {
                            bookToBorrow.borrowBook();
                            System.out.println("You have successfully borrowed the book.");
                        }
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;

                case 5:
                    // Return a book
                    System.out.print("Enter book ID to return: ");
                    int returnId = scanner.nextInt();
                    if (library.containsKey(returnId)) {
                        Book bookToReturn = library.get(returnId);
                        if (!bookToReturn.isBorrowed()) {
                            System.out.println("This book was not borrowed.");
                        } else {
                            bookToReturn.returnBook();
                            System.out.println("You have successfully returned the book.");
                        }
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;

                case 6:
                    // Remove a book
                    System.out.print("Enter book ID to remove: ");
                    int removeId = scanner.nextInt();
                    if (library.remove(removeId) != null) {
                        System.out.println("Book removed successfully.");
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;

                case 7:
                    // Exit
                    System.out.println("Exiting Library Management System. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 7);

        scanner.close();
    }
}

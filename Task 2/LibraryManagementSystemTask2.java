import java.util.ArrayList;
import java.util.Scanner;

class Book {
    String title;
    String author;
    boolean isAvailable;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }
}

class LibraryCatalog {
    ArrayList<Book> books = new ArrayList<>();

    // Method to add a book
    void addBook(Book book) {
        books.add(book);
        System.out.println("\u001B[32m📚 Book added: " + book.title + " by " + book.author + "\u001B[0m");
    }

    // Method to search by title
    void searchByTitle(String title) {
        System.out.println("\n🔍 Searching for book with title: " + title);
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                System.out.println("\u001B[32m✅ Found: " + book.title + " by " + book.author + "\u001B[0m");
                return;
            }
        }
        System.out.println("\u001B[31m❌ Book not found.\u001B[0m");
    }

    // Method to check out a book
    void checkOutBook(String title) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title) && book.isAvailable) {
                book.isAvailable = false;
                System.out.println("\u001B[34m📖 You have checked out: " + book.title + "\u001B[0m");
                return;
            }
        }
        System.out.println("\u001B[31m❌ Book is either not available or not found.\u001B[0m");
    }

    // Method to return a book
    void returnBook(String title) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title) && !book.isAvailable) {
                book.isAvailable = true;
                System.out.println("\u001B[34m📚 You have returned: " + book.title + "\u001B[0m");
                return;
            }
        }
        System.out.println("\u001B[31m❌ Book is either already available or not found.\u001B[0m");
    }
}

public class LibraryManagementSystemTask2 {

    public static void main(String[] args) {
        // Title
        System.out.println("\n====================================");
        System.out.println("📚 Library Management System 📚");
        System.out.println("====================================");
        System.out.println("Manage your books, search by title, check out, and return books easily!");

        LibraryCatalog catalog = new LibraryCatalog();
        Scanner scanner = new Scanner(System.in);
        String choice;

        do {
            // Menu Display
            System.out.println("\n📖 Menu:");
            System.out.println("1. Add Book");
            System.out.println("2. Search Book by Title");
            System.out.println("3. Check Out Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int option = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (option) {
                case 1:
                    // Add Book
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author name: ");
                    String author = scanner.nextLine();
                    catalog.addBook(new Book(title, author));
                    break;
                case 2:
                    // Search by Title
                    System.out.print("Enter title to search: ");
                    String searchTitle = scanner.nextLine();
                    catalog.searchByTitle(searchTitle);
                    break;
                case 3:
                    // Check Out Book
                    System.out.print("Enter title to check out: ");
                    String checkoutTitle = scanner.nextLine();
                    catalog.checkOutBook(checkoutTitle);
                    break;
                case 4:
                    // Return Book
                    System.out.print("Enter title to return: ");
                    String returnTitle = scanner.nextLine();
                    catalog.returnBook(returnTitle);
                    break;
                case 5:
                    // Exit
                    System.out.println("Exiting the Library Management System...");
                    break;
                default:
                    System.out.println("\u001B[31m❌ Invalid choice. Please try again.\u001B[0m");
            }

            System.out.print("\nDo you want to continue (yes/no)? ");
            choice = scanner.nextLine();
        } while (choice.equalsIgnoreCase("yes"));

        System.out.println("\n✨ Thank you for using the Library Management System!");
        System.out.println("====================================");
        System.out.println("✨ Made By Viraj Tupe ✨");
        scanner.close();
    }
}

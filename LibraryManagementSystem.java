import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Book {
    private String title;
    private String author;
    private boolean available;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.available = true;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}

class Library {
    private List<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

   public void displayBooks() {
    System.out.println();
    System.out.println("\n\t\bAvailable Books:\n");
    for (Book book : books) {
        if (book.isAvailable()) {
            System.out.println();
            System.out.println("\u001B[37mTitle: \u001B[34m" + book.getTitle() + "\u001B[0m");
            System.out.println("\u001B[37mAuthor: \u001B[32m" + book.getAuthor() + "\u001B[0m");
        }
    }
    System.out.println();
}




    public void viewAuthor(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println("\nAuthor of '" + book.getTitle() + "': \u001B[32m" + book.getAuthor() + "\u001B[0m");
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void borrowBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && book.isAvailable()) {
                book.setAvailable(false);
                System.out.println("You have borrowed the book: " + book.getTitle());
                return;
            }
        }
        System.out.println("The book is not available for borrowing.");
    }

    public void returnBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && !book.isAvailable()) {
                book.setAvailable(true);
                System.out.println("You have returned the book: " + book.getTitle());
                return;
            }
        }
        System.out.println("Invalid book title or book is already available.");
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();

        // Adding sample books to the library
        library.addBook(new Book("Mathematics Textbook - 10th Standard", "Board of Education"));
        library.addBook(new Book("Science Textbook - 10th Standard", "Board of Education"));
        library.addBook(new Book("English Grammar - 10th Standard", "Board of Education"));
        library.addBook(new Book("Social Studies Textbook - 10th Standard", "Board of Education"));
        library.addBook(new Book("Swami Vivekananda", "Chalam"));
        library.addBook(new Book("Gulliver's Travels", "Jonathan Swift"));
        library.addBook(new Book("Godaan", "Munshi Premchand"));
        library.addBook(new Book("Parineeta", "Sarat Chandra Chattopadhyay"));
        library.addBook(new Book("Manorama", "Gopal Das Neeraj"));
        library.addBook(new Book("A Suitable Boy", "Vikram Seth"));
        library.addBook(new Book("The White Tiger", "Aravind Adiga"));
        library.addBook(new Book("Train to Pakistan", "Khushwant Singh"));
        library.addBook(new Book("The Namesake", "Jhumpa Lahiri"));
        library.addBook(new Book("Interpreter of Maladies", "Jhumpa Lahiri"));
        library.addBook(new Book("The Guide", "R.K. Narayan"));
        library.addBook(new Book("Shantaram", "Gregory David Roberts"));
        library.addBook(new Book("Clean Code", "Robert C. Martin"));
        library.addBook(new Book("The Pragmatic Programmer", "Andrew Hunt and David Thomas"));
        library.addBook(new Book("Effective Java", "Joshua Bloch"));
        library.addBook(new Book("Head First Design Patterns", "Eric Freeman, Elisabeth Robson, Bert Bates, Kathy Sierra"));
        library.addBook(new Book("Theory of Computation", "Michael Sipser"));
        library.addBook(new Book("Refactoring", "Martin Fowler"));
        library.addBook(new Book("Design Patterns", "Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides"));
        library.addBook(new Book("Code Complete", "Steve McConnell"));


        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Display Available Books");
            System.out.println("2. View Author of a Book");
            System.out.println("3. Borrow a Book");
            System.out.println("4. Return a Book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    library.displayBooks();
                    break;
                case 2:
                    System.out.print("Enter the title of the book: ");
                    String bookTitle = scanner.nextLine();
                    library.viewAuthor(bookTitle);
                    break;
                case 3:
                    System.out.print("Enter the title of the book to borrow: ");
                    String borrowTitle = scanner.nextLine();
                    library.borrowBook(borrowTitle);
                    break;
                case 4:
                    System.out.print("Enter the title of the book to return: ");
                    String returnTitle = scanner.nextLine();
                    library.returnBook(returnTitle);
                    break;
                   case 5:
                    System.out.println("\u001B[95mThank you for using the Library Management System!\u001B[0m");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

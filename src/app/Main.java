package app;

import model.Book;
import service.BookService;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BookService bookService = new BookService();

        while (true) {

            System.out.println("\n------ Library Management System ------");
            System.out.println("1 Add Book");
            System.out.println("2 View Books");
            System.out.println("3 Search Book by ID");
            System.out.println("4 Search Book by Title");
            System.out.println("5 Update Book");
            System.out.println("6 Delete Book");
            System.out.println("7 Exit");

            System.out.println("\nEnter your choice:");
            int choice = sc.nextInt();
            sc.nextLine(); // consume leftover newline

            switch (choice) {

                case 1:
                    System.out.println("\nEnter ID:");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Enter Title:");
                    String title = sc.nextLine();

                    System.out.println("Enter Author:");
                    String author = sc.nextLine();

                    System.out.println("Enter Price:");
                    double price = sc.nextDouble();

                    System.out.println("Enter Quantity:");
                    int quantity = sc.nextInt();
                    sc.nextLine();

                    Book book = new Book(id, title, author, price, quantity);

                    if (bookService.addBook(book)) {
                        System.out.println("\nBook added successfully.");
                    } else {
                        System.out.println("\nFailed to add book.");
                    }
                    break;

                case 2:
                    System.out.println("\n------ Book List ------");

                    List<Book> books = bookService.getAllBooks();

                    if (books.isEmpty()) {
                        System.out.println("No books found.");
                    } else {
                        for (Book b : books) {
                            System.out.println(b);
                        }
                    }
                    break;

                case 3:
                    System.out.println("\nEnter Book ID:");
                    int searchId = sc.nextInt();
                    sc.nextLine();

                    List<Book> result = bookService.searchBookById(searchId);

                    if (result.isEmpty()) {
                        System.out.println("Book not found.");
                    } else {
                        for (Book b : result) {
                            System.out.println(b);
                        }
                    }
                    break;

                case 4:
                    System.out.println("\nEnter Title:");
                    String searchTitle = sc.nextLine();

                    List<Book> booksByTitle = bookService.searchBookByTitle(searchTitle);

                    if (booksByTitle.isEmpty()) {
                        System.out.println("No books found.");
                    } else {
                        for (Book b : booksByTitle) {
                            System.out.println(b);
                        }
                    }
                    break;

                case 5:
                    System.out.println("\nEnter ID of book to update:");
                    int updateId = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Enter New Title:");
                    String newTitle = sc.nextLine();

                    System.out.println("Enter New Author:");
                    String newAuthor = sc.nextLine();

                    System.out.println("Enter New Price:");
                    double newPrice = sc.nextDouble();

                    System.out.println("Enter New Quantity:");
                    int newQuantity = sc.nextInt();
                    sc.nextLine();

                    Book updatedBook = new Book(updateId, newTitle, newAuthor, newPrice, newQuantity);

                    if (bookService.updateBook(updatedBook)) {
                        System.out.println("\nBook updated successfully.");
                    } else {
                        System.out.println("\nUpdate failed.");
                    }
                    break;

                case 6:
                    System.out.println("\nEnter Book ID to delete:");
                    int deleteId = sc.nextInt();
                    sc.nextLine();

                    if (bookService.deleteBook(deleteId)) {
                        System.out.println("\nBook deleted successfully.");
                    } else {
                        System.out.println("\nBook not found.");
                    }
                    break;

                case 7:
                    System.out.println("\nExiting program...");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("\nInvalid choice. Please try again.");
            }
        }
    }
}
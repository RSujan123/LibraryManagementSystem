package service;

import dao.BookDAO;
import model.Book;

import java.util.InputMismatchException;
import java.util.List;


public class BookService {
    BookDAO dao = new BookDAO();

    public boolean addBook(Book book){
        if(book.getId() < 0 || book.getTitle().isEmpty() || book.getAuthor().isEmpty() || book.getPrice() < 0 || book.getQuantity() < 0){
            System.out.println("Invalid Details.");
            throw new InputMismatchException("Invalid Input");
        }
        return dao.addBook(book);
    }
    public List<Book> getAllBooks(){
        return dao.getAllBooks();
    }
    public List<Book> searchBookById(int id){
        if(id <= 0){
            throw new IllegalArgumentException("Id cannot be less than or equal to zero.");
        }
        return dao.searchBookById(id);
    }
    public List<Book> searchBookByTitle(String title){
        if(title.isEmpty()){
            throw new IllegalArgumentException("Title cannot be empty.");
        }
        return dao.searchBookByTitle(title);
    }
    public boolean updateBook(Book book){
        if(book.getId() < 0 || book.getTitle().isEmpty() || book.getAuthor().isEmpty() || book.getPrice() < 0 || book.getQuantity() < 0){
            throw new IllegalArgumentException("Invalid Input");
        }
        return dao.updateBook(book);
    }
    public boolean deleteBook(int id){
        if(id <= 0){
            throw new IllegalArgumentException("Id cannot be less than or equal to zero.");
        }
        return dao.deleteBook(id);
    }

}

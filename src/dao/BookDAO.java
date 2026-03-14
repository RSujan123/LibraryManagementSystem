package dao;

import config.DBConnection;
import model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    public boolean addBook(Book book){
        String query = "Insert into books(id,title,author,price,quantity) values(?,?,?,?,?)";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1,book.getId());
            preparedStatement.setString(2,book.getTitle());
            preparedStatement.setString(3,book.getAuthor());
            preparedStatement.setDouble(4,book.getPrice());
            preparedStatement.setInt(5,book.getQuantity());

            int i = preparedStatement.executeUpdate();
            if(i > 0) return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;

    }
    public List<Book> getAllBooks(){
        String query = "select * from books";
        List<Book> result = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);){
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Book b = new Book();
                b.setId(resultSet.getInt("id"));
                b.setTitle(resultSet.getString("title"));
                b.setAuthor(resultSet.getString("author"));
                b.setPrice(resultSet.getDouble("price"));
                b.setQuantity(resultSet.getInt("quantity"));
                result.add(b);
            }
            resultSet.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
    public List<Book> searchBookById(int id){
        String query = "select * from books where id = ?";
        List<Book> result = new ArrayList<>();
        try(Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);) {
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                Book b = new Book();
                b.setId(resultSet.getInt("id"));
                b.setTitle(resultSet.getString("title"));
                b.setAuthor(resultSet.getString("author"));
                b.setPrice(resultSet.getDouble("price"));
                b.setQuantity(resultSet.getInt("quantity"));
                result.add(b);
            }
            resultSet.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
    public boolean updateBook(Book book){
        String query = "update books set title = ?,author = ?,price = ?,quantity = ? where id = ?";
        try(Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);){
            preparedStatement.setString(1,book.getTitle());
            preparedStatement.setString(2,book.getAuthor());
            preparedStatement.setDouble(3,book.getPrice());
            preparedStatement.setInt(4,book.getQuantity());
            preparedStatement.setInt(5,book.getId());

            int i = preparedStatement.executeUpdate();
            if(i > 0) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public boolean deleteBook(int id){
        String query = "delete from books where id = ?";
        try (Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);){
            preparedStatement.setInt(1,id);
            int i = preparedStatement.executeUpdate();
            if(i > 0){
                return true;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
    public List<Book> searchBookByTitle(String title){
        String query = "select * from books where title = ?";
        List<Book> res = new ArrayList<>();
        try(Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);){
            preparedStatement.setString(1,title);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Book b = new Book();
                b.setId(resultSet.getInt("id"));
                b.setTitle(resultSet.getString("title"));
                b.setAuthor((resultSet.getString("author")));
                b.setPrice(resultSet.getDouble("price"));
                b.setQuantity(resultSet.getInt("quantity"));
                res.add(b);

            }
            resultSet.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return res;
    }


}

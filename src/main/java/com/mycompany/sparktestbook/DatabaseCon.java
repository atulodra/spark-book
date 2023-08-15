/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sparktestbook;

/**
 *
 * @author AVShrez
 */
//import com.google.gson.Gson;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//import java.util.stream.Collectors;
//import java.util.stream.IntStream;
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;

public class DatabaseCon {

    private final String connectionURL = "jdbc:mysql://localhost:3306/sparkbook?user=root&password=whatapassword";
    private final String insertQuery = "INSERT INTO Book(title, author, ISBN, publisher, publicationDate, cover) VALUES(?,?,?,?,?,?)";
    private final String getBookQuery = "SELECT * FROM Book WHERE id = ?";
    private final String getStatusQuery = "SELECT status FROM Book WHERE id = ?";
    private final String updateTitleQuery = "UPDATE Book SET title = ? WHERE id = ?";
    private final String updateAuthorQuery = "UPDATE Book SET author = ? WHERE id = ?";
    private final String deleteQuery = "DELETE FROM Book WHERE id = ?";

//    private Statement stmt;
//    private ResultSet resultSet;
//    private JSONArray jsonArray;
//    private Gson gson = new Gson();
    private String json;
    private Map<Integer, BookModel> books = new HashMap<>();

//    public static JSONArray jsarr() throws Exception {
//        JSONArray jsonArray = new JSONArray();
//
//        while (resultSet.next()) {
//
//            int columns = resultSet.getMetaData().getColumnCount();
//            JSONObject obj = new JSONObject();
//
//            for (int i = 0; i < columns; i++) {
//                obj.put(resultSet.getMetaData().getColumnLabel(i + 1).toLowerCase(),
//                        resultSet.getObject(i + 1));
//            }
//
//            jsonArray.put(obj);
//        }
//        return jsonArray;
//    }
    public List<BookModel> getBooks() {
        try (Connection con = DriverManager.getConnection(connectionURL); Statement stmt = con.createStatement();) {

            ResultSet resultSet = stmt.executeQuery("SELECT * FROM Book");
            while (resultSet.next()) {
                System.out.println(
                        resultSet.getInt(1) + "  " + resultSet.getString(2) + "  " + resultSet.getString(
                        3) + "  " + resultSet.getString(4) + "  " + resultSet.getString(
                        5) + " " + resultSet.getString(6));
                books.put(resultSet.getInt("id"), new BookModel(
                        resultSet.getInt(
                                "id"),
                        resultSet.getString("title"), resultSet.getString(
                        "author"), resultSet.getString("ISBN"),
                        resultSet.getString(
                                "publisher"), resultSet.getString(
                                "publicationDate"), resultSet.getString(
                                "cover"), resultSet.getString("status")));

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return new ArrayList<>(books.values());
    }

    public BookModel getBook(int id) {
        BookModel book = new BookModel();
        try (Connection con = DriverManager.getConnection(connectionURL); PreparedStatement preparedStmt = con.prepareStatement(
                getBookQuery);) {
            preparedStmt.setInt(1, id);
            ResultSet resultSet = preparedStmt.executeQuery();
            while (resultSet.next()) {
                System.out.println(
                        resultSet.getInt(1) + "  " + resultSet.getString(2) + "  " + resultSet.getString(
                        3) + "  " + resultSet.getString(4) + "  " + resultSet.getString(
                        5) + " " + resultSet.getString(6));
                book = new BookModel(
                        resultSet.getInt(
                                "id"),
                        resultSet.getString("title"), resultSet.getString(
                        "author"), resultSet.getString("ISBN"),
                        resultSet.getString(
                                "publisher"), resultSet.getString(
                                "publicationDate"), resultSet.getString(
                                "cover"), resultSet.getString("status"));

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return book;

    }

    public void inserBook(BookModel book) {
        try (Connection con = DriverManager.getConnection(connectionURL); PreparedStatement preparedStmt = con.prepareStatement(
                insertQuery);) {
            preparedStmt.setString(1, book.getTitle());
            preparedStmt.setString(2, book.getAuthor());
            preparedStmt.setString(3, book.getISBN());
            preparedStmt.setString(4, book.getPublisher());
            preparedStmt.setString(5, book.getPublicationDate());
            preparedStmt.setString(6, book.getCover());
            preparedStmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateTitle(int id, String newTitle) {
        try (Connection con = DriverManager.getConnection(connectionURL); PreparedStatement preparedStmt = con.prepareStatement(
                updateTitleQuery);) {
//            preparedStmt.setString(1, "title");
            preparedStmt.setString(1, newTitle);
            preparedStmt.setInt(2, id);
            preparedStmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateAuthor(int id, String newAuthor) {
        try (Connection con = DriverManager.getConnection(connectionURL); PreparedStatement preparedStmt = con.prepareStatement(
                updateAuthorQuery);) {
//            preparedStmt.setString(1, "title");
            preparedStmt.setString(1, newAuthor);
            preparedStmt.setInt(2, id);
            preparedStmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteBook(int id) {
        try (Connection con = DriverManager.getConnection(connectionURL); PreparedStatement preparedStmt = con.prepareStatement(
                deleteQuery);) {
//            preparedStmt.setString(1, "title");
            preparedStmt.setInt(1, id);
            preparedStmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public String getStatus(int id) {
        StringBuilder status = new StringBuilder();
        try (Connection con = DriverManager.getConnection(connectionURL); PreparedStatement preparedStmt = con.prepareStatement(
                getStatusQuery);) {
            preparedStmt.setInt(1, id);
            ResultSet resultSet = preparedStmt.executeQuery();
            resultSet.next();
            status.append(resultSet.getString("status"));
            System.out.println(status.toString());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return status.toString();
    }

//    public void updateBook(int id) {
//
//    }
}

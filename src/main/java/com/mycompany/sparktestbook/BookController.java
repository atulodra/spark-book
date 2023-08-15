package com.mycompany.sparktestbook;

import com.google.gson.Gson;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import spark.Request;
import spark.Response;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author AVShrez
 */
public class BookController {

    private String json;
    private List<BookModel> books = new ArrayList<>();
    private final DatabaseCon dbCon = new DatabaseCon();

    public String getBooks(Request req, Response res) {
        res.type("application/json");
        books = dbCon.getBooks();
        json = new Gson().toJson(books);
        return json;
        /* Can show the result like this too
//        return new Gson().toJson(
//                new StandardResponse(StatusResponse.SUCCESS, new Gson()
//                        .toJsonTree(books)));
         */
    }

    public String insertBook(Request req, Response res) {
        res.type("application/json");
        BookModel book = new Gson().fromJson(req.body(), BookModel.class);
        dbCon.inserBook(book);
        res.status(200);
        return new Gson().toJson(book);
    }

    public String updateBook(Request req, Response res) {
        res.type("application/json");
//        String id = req.params(":id");
        int id = Integer.parseInt(req.params(":id"));
//        dbCon.updateBook(id);
        return "update";
    }

    public String getBook(Request req, Response res) {
        res.type("application/json");
        int id = Integer.parseInt(req.params(":id"));
        BookModel book = dbCon.getBook(id);
        return new Gson().toJson(book);
    }

    public String updateTitle(Request req, Response res) {
        res.type("appliation/json");
        int id = Integer.parseInt(req.params(":id"));
        String newTitle = req.queryParams("newtitle");
        dbCon.updateTitle(id, newTitle);
        return "{ SUCCESS, Title Updated! }";
    }

    public String updateAuthor(Request req, Response res) {
        res.type("application/json");
        int id = Integer.parseInt(req.params(":id"));
        String newauthor = req.queryParams("newauthor");
        dbCon.updateAuthor(id, newauthor);
        return "updated author";
    }

    public String deleteBook(Request req, Response res) {
        res.type("application/json");
        int id = Integer.parseInt(req.params(":id"));
        dbCon.deleteBook(id);
        return "book deleted!";
    }

    public String getStatus(Request req, Response res) {
        res.type("application/json");
        int id = Integer.parseInt(req.params(":id"));
        String status = dbCon.getStatus(id);
        return status;
    }

}

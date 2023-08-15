/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sparktestbook;

import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import static spark.Spark.*;

import spark.Filter;

/**
 *
 * @author AVShrez
 */
public class Sparktestbook {

//    private static String path = "/api/books";
//    private static DatabaseCon dbCon = new DatabaseCon();
    private final static BookController bookController = new BookController();

//    private Map<Integer, Integer> test = new HashMap<>();
    public static void main(String[] args) {
//        String js = dbCon.getBooks();
//        System.out.println(js);

        port(8221);

//        get(path, (req, res) -> {
//            res.type("application/json");
//            return dbCon.getBooks();
//        });
        path("/api", () -> {

            options("/*", (request, response) -> {
                String accessControlRequestHeaders = request.headers(
                        "Access-Control-Request-Headers");
                if (accessControlRequestHeaders != null) {
                    response.header("Access-Control-Allow-Headers",
                            accessControlRequestHeaders);
                }
                String accessControlRequestMethod = request.headers(
                        "Access-Control-Request-Method");
                if (accessControlRequestMethod != null) {
                    response.header(accessControlRequestHeaders,
                            accessControlRequestMethod);
                }
                return "OK";
            });

            path("/books", () -> {
                before("", (request, response) -> {
                    response.header("Access-Control-Allow-Origin",
                            "http://localhost:5173");
                    response.header("Access-Control-Allow-Methods",
                            "GET, PUT, POST, DELETE");
                    response.header("Access-Control-Allow-Headers", "Accept");
                    response.header("Access-Control-Allow-Credentials", "true");
                });
//                after((Filter) (request, response) -> {
//                    response.header("Access-Control-Allow-Origin", "*");
//                    response.header("Access-Control-Allow-Methods", "GET");
//                    response.header("Access-Control-Allow-Headers", "Accept");
//                    response.header("Access-Control-Allow-Credentials", "true");
//                });
                get("", (req, res) -> bookController.getBooks(req, res));
                post("", (req, res) -> bookController.insertBook(req, res));
            });
            path("/book/:id", () -> {
//                options("", (req, res) -> {
//                    String origin = "httplocalhost:5173/book/" + req.params(
//                            ":id");
//                    res.header("Access-Control-Allow-Origin",
//                            origin);
//                    res.header("Access-Control-Allow-Methods",
//                            "GET, PUT, POST, DELETE");
//                    res.header("Access-Control-Allow-Headers",
//                            "Accept, Content-Type");
////                res.header("Access-Control-Allow-Credentials", "true");
//                    return "Ok!";
//                });
                before("", (req, res) -> {
//                    String origin = "http://localhost:5173/book/" + req.params(
//                            ":id");
                    String status = bookController.getStatus(req, res);
//                    if (status.equals("disabled")) {
//                        halt(401, "You are not welcome here");
//                    }
                    res.header("Access-Control-Allow-Origin",
                            "http://localhost:5173");
//                    res.header("Access-Control-Allow-Origin", "*");
                    if (status.equals("disabled")) {
                        res.header("Access-Control-Allow-Methods",
                                "GET, PUT, POST");
                    } else {
                        res.header("Access-Control-Allow-Methods",
                                "GET, PUT, POST, DELETE");
                    }
                    res.header("Access-Control-Allow-Headers",
                            "Accept, Content-Type");
                    res.header("Access-Control-Allow-Credentials", "true");

                });
                get("",
                        (req, res) -> bookController.getBook(req, res));
                path("/update", () -> {
                    put("/title",
                            (req, res) -> bookController.updateTitle(
                                    req, res));
                    put("/author",
                            (req, res) -> bookController.updateAuthor(req, res));
                });
                delete("", (req, res) -> bookController.deleteBook(req, res));
            });
        });
    }

}

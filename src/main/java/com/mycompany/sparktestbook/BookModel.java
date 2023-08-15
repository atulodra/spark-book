/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sparktestbook;

import java.time.LocalDate;

/**
 *
 * @author AVShrez
 */
public class BookModel {

    private int id;
    private String title;
    private String author;
    private String ISBN;
    private String publisher;
    private String publicationDate;
    private String cover;
    private String status = "enabled";

    BookModel() {
    }

    BookModel(String title, String author, String ISBN, String publisher,
            String date, String cover) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.publisher = publisher;
//        this.publicationDate = LocalDate.parse(date);
        this.publicationDate = date;
        this.cover = cover;

    }

    BookModel(String title, String author, String ISBN, String publisher,
            String date, String cover, String status) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.publisher = publisher;
//        this.publicationDate = LocalDate.parse(date);
        this.publicationDate = date;
        this.cover = cover;
        this.status = status;

    }

    BookModel(int id, String title, String author, String ISBN, String publisher,
            String date, String cover) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.publisher = publisher;
//        this.publicationDate = LocalDate.parse(date);
        this.publicationDate = date;
        this.cover = cover;
    }

    BookModel(int id, String title, String author, String ISBN, String publisher,
            String date, String cover, String status) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.publisher = publisher;
//        this.publicationDate = LocalDate.parse(date);
        this.publicationDate = date;
        this.cover = cover;
        this.status = status;

    }

    public void getBookDetails() {
        if (id > 0) {
            System.out.println("Id:" + id);
        }
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + ISBN);
        System.out.println("Publisher: " + publisher);
        System.out.println("Date of publication: " + publicationDate);
        System.out.println("Cover: " + cover);
    }

    public void setBookDetails(int id, String title, String author, String ISBN,
            String publisher, String date, String cover) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.publisher = publisher;
//        this.publicationDate = LocalDate.parse(date);
        this.publicationDate = date;
        this.cover = cover;

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setPublicationDate(String date) {
//        this.publicationDate = LocalDate.parse(date);
        this.publicationDate = date;

    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getPublicationDate() {
//        return publicationDate.toString();
        return publicationDate;

    }

    public String getCover() {
        return cover;
    }
}

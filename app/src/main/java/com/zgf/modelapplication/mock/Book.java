package com.zgf.modelapplication.mock;

/**
 * Created by zgf on 2016/12/8.
 */

public class Book {
    private String isbn;
    private String title;

    public Book(String isbn, String title){
        this.isbn = isbn;
        this.title = title;
    }

    public String getIsbn(){
        return isbn;
    }

    public String getTitle(){
        return title;
    }
}

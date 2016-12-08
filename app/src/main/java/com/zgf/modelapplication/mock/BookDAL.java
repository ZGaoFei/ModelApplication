package com.zgf.modelapplication.mock;

import java.util.Collections;
import java.util.List;

/**
 * Created by zgf on 2016/12/8.
 */

public class BookDAL {
    private static BookDAL bookDAL = new BookDAL();

    public List<Book> getAllBooks(){
        return Collections.EMPTY_LIST;
    }

    public Book getBook(String isbn){
        return null;
    }

    public String addBook(Book book){
        return book.getIsbn();
    }

    public static BookDAL getInstance(){
        return bookDAL;
    }
}

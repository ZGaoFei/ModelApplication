package com.zgf.modelapplication;

import com.zgf.modelapplication.mock.Book;
import com.zgf.modelapplication.mock.BookDAL;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by zgf on 2016/12/8.
 */

public class BookDALTest {
    private static BookDAL mockedBookDAL;
    private static Book book1;
    private static Book book2;

    @BeforeClass
    public static void setUp(){
        mockedBookDAL = mock(BookDAL.class);

        book1 = new Book("isbn1987", "1987");
        book2 = new Book("isbn1989", "1989");



        when(mockedBookDAL.getAllBooks()).thenReturn(Arrays.asList(book1, book2));
        when(mockedBookDAL.addBook(book1)).thenReturn(book1.getIsbn());
    }

    @Test
    public void testGetAllBooks() throws Exception{
        List<Book> books = mockedBookDAL.getAllBooks();
        assertEquals(2, books.size());

        Book book = books.get(0);
        assertEquals("isbn1987", book.getIsbn());
        assertEquals("1987", book.getTitle());
    }
}

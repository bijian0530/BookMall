package com.test;

import com.pojo.Book;
import com.pojo.Page;
import com.service.BookService;
import com.service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class BookServiceTest {
        private BookService bookService = new BookServiceImpl();
    @Test
    public void addBook() {
        bookService.addBook(new Book(24,"国哥在手，天下我有！", "1125", new BigDecimal(1000000), 100000000, 0, null));
    }

    @Test
    public void deleteBookById() {
        bookService.deleteBookById(23);
    }


    @Test
    public void updateBook() {
        bookService.updateBook(new Book(20,"社会我健哥，人狠话不多！", "1125", new BigDecimal(999999), 10, 111110, null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookService.queryBookById(22));
    }

    @Test
    public void queryBooks() {
        for (Book querybook:bookService.queryBooks()
             ) {
            System.out.println(querybook);
        }
    }
    @Test
    public void page(){
        System.out.println(bookService.page(1, Page.PAGE_SIZE));
    }
}
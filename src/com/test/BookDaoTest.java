package com.test;

import com.dao.BookDao;
import com.dao.impl.BookDaoImpl;
import com.pojo.Book;
import com.pojo.Page;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class BookDaoTest {
    private BookDao bookDao = new BookDaoImpl();
    @Test
    public void addBook() {
        bookDao.addBook(new Book(22,"健哥为啥这么帅","莱布尼茨",new BigDecimal(666),11000,0,null));
    }

    @Test
    public void deleteBookById() {
        bookDao.deleteBookById(21);
    }

    @Test
    public void updateBook() {
        bookDao.updateBook(new Book(22,"健哥为啥这么帅!","莱布尼茨",new BigDecimal(666),11000,0,null));
    }

    @Test
    public void queryBookById() {

        System.out.println(bookDao.queryBookById(22));
    }

    @Test
    public void queryBooks() {
        for (Book queryBook:bookDao.queryBooks()
             ) {
            System.out.println(queryBook);
        }
    }

    @Test
    public void queryForPageTotalCount() {
        System.out.println(bookDao.queryForPageTotalCount());
    }

    @Test
    public void queryForPageItems() {
        for (Book book:bookDao.queryForPageItems(8, Page.PAGE_SIZE)
             ) {
            System.out.println(book);
        }
    }

}
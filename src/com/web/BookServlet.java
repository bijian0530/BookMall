package com.web;

import com.pojo.Book;
import com.pojo.Page;
import com.service.BookService;
import com.service.impl.BookServiceImpl;
import com.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class BookServlet extends BaseServlet {
    private BookService bookService = new BookServiceImpl();

    public void add(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
        Book book = WebUtils.copyParamToBean(req.getParameterMap(),new Book());
        bookService.addBook(book);
//        req.getRequestDispatcher("/manager/bookServlet?action=list").forward(req,resp);
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=list");
    }

    public void list(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
        List<Book> books =bookService.queryBooks();
        req.setAttribute("books",books);
//        重定向回页面管理页面  /book/manager/bookServlet?action=list
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);
    }

    public void delete(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
        //获取请求参数id，图书编程
        int id = WebUtils.parseInt(req.getParameter("id"),0);
        bookService.deleteBookById(id);
        resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=list");
    }

    public void getBook(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
        int id = WebUtils.parseInt(req.getParameter("id"),0);
        Book book = bookService.queryBookById(id);
        req.setAttribute("book",book);
        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req,resp);
    }

    public void update(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
        //获取请求参数封装成为Book对象
        Book book = WebUtils.copyParamToBean(req.getParameterMap(),new Book());
        bookService.updateBook(book);
        resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=list");
    }

    public void page(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"),1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        Page<Book> page = bookService.page(pageNo,pageSize);
        req.setAttribute("page",page);
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);
    }

}

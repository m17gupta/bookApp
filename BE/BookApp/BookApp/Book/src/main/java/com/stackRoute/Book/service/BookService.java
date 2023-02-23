package com.stackRoute.Book.service;

import com.stackRoute.Book.Exception.UserAlreadyExists;
import com.stackRoute.Book.Exception.UserNotFound;
import com.stackRoute.Book.domain.Book;
import com.stackRoute.Book.domain.BookApp;

import java.util.List;

public interface BookService {

    public abstract BookApp register(BookApp user) throws UserAlreadyExists;

    public abstract  BookApp Login(String userName, String password) throws UserNotFound;

    public abstract Book addBook(Book book,String userId);

    public abstract List<Book> getAllBooks(String userId);


    public abstract  Book updateBook(Book book, String userId);

    public abstract boolean DeleteBook(String bookId,String userId);
}

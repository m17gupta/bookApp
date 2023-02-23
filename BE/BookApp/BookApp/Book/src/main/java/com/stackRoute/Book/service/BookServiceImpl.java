package com.stackRoute.Book.service;

import com.stackRoute.Book.Exception.UserAlreadyExists;
import com.stackRoute.Book.Exception.UserNotFound;
import com.stackRoute.Book.domain.Book;
import com.stackRoute.Book.domain.BookApp;
import com.stackRoute.Book.repository.BookReepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class BookServiceImpl implements BookService{
    @Autowired
    private BookReepository bookReepository;

    @Override
    public BookApp register(BookApp user) throws UserAlreadyExists {
        if(bookReepository.findById(user.getEmailId()).isPresent()){
            throw new UserAlreadyExists();
        }
        else{
            BookApp registerUser= new BookApp(user.getEmailId(), user.getName(), user.getPhone(),
                    user.getAddress(), user.getPassword(), new ArrayList<>());
            bookReepository.insert(registerUser);
            return registerUser;
        }
    }

    @Override
    public BookApp Login(String userName, String password) throws UserNotFound {
        if(bookReepository.findById(userName).isPresent()){
            BookApp user= bookReepository.findById(userName).get();
            if(user.getPassword().equalsIgnoreCase(password)){
                return user;
            }else {
                return null;
            }
        }else {
           throw new UserNotFound();
        }

    }

    @Override
    public Book addBook(Book book,String userId) {
        if(bookReepository.findById(userId).isPresent()){
          BookApp user= bookReepository.findById(userId).get();
          List<Book> bookList=user.getBookList();
         Book book1= new Book(book.getBookId(), book.getBookTitle(), book.getBookAuthor(), book.getStock(),
                 book.getBookDescription());
         bookList.add(book1);
         bookReepository.save(user);
         return book1;
        }
        else {
            return null;
        }


    }

    @Override
    public List<Book> getAllBooks(String userId) {
        if(bookReepository.findById(userId).isPresent()){
            BookApp user=bookReepository.findById(userId).get();
            List<Book>bookList=user.getBookList();
            return bookList;
        }else {
            return null;
        }

    }

    @Override
    public Book updateBook(Book book,String userId) {
        if(bookReepository.findById(userId).isPresent()){
            BookApp user= bookReepository.findById(userId).get();
            List<Book> bookList= user.getBookList();
             Book book1= bookList.stream().filter(i->i.getBookId().equalsIgnoreCase(book.getBookId())).findAny().get();
             if(book1!=null){
                 bookList.remove(book1);
                 bookList.add(book);
                 bookReepository.save(user);
                 return book;

             }else{
                 return null;
             }

        }
        return null;
    }

    @Override
    public boolean DeleteBook(String bookId,String userId) {
        if(bookReepository.findById(userId).isPresent()){
            BookApp user= bookReepository.findById(userId).get();
            List<Book>bookList=user.getBookList();
            Book book= bookList.stream().filter(i->i.getBookId().equalsIgnoreCase(bookId)).findAny().get();
            if(book!=null){
                bookList.remove(book);
                bookReepository.save(user);

                return true;
            } else {
                return false;
            }

        }
        return false;
    }
}

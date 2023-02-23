package com.stackRoute.Book.controller;

import com.stackRoute.Book.Exception.UserAlreadyExists;
import com.stackRoute.Book.Exception.UserNotFound;
import com.stackRoute.Book.domain.Book;
import com.stackRoute.Book.domain.BookApp;
import com.stackRoute.Book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin
@RestController
@RequestMapping("/book-app/v1")
public class BookAppController {

    @Autowired
    private BookService bookService;

    // http://localhost:9999/book-app/v1/register
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody BookApp register) throws UserAlreadyExists {
        try {
            return new ResponseEntity<>(bookService.register(register), HttpStatus.OK);
        } catch (UserAlreadyExists ex) {
            throw new UserAlreadyExists();
        }

    }
    //http://localhost:9999/book-app/v1/login
    @PostMapping("/login")
    public ResponseEntity<?>login(@RequestBody BookApp user) throws UserNotFound{
        try{
           return new ResponseEntity<>(bookService.Login(user.getEmailId(), user.getPassword()),HttpStatus.OK) ;
        }catch (UserNotFound ex){
            throw new UserNotFound();
        }
    }

    //http://localhost:9999/book-app/v1/add-book/{userId}
    @PostMapping ("/add-book/{userId}")
        public ResponseEntity<?> addBook(@RequestBody Book book,@PathVariable String userId){
        return new ResponseEntity<>(bookService.addBook(book,userId),HttpStatus.OK);
        }

    //http://localhost:9999/book-app/v1/get-all-book/{userId}
        @GetMapping("/get-all-book/{userId}")
    public ResponseEntity<?> getallBook(@PathVariable String userId){
        return new ResponseEntity<>(bookService.getAllBooks(userId),HttpStatus.OK);
        }

       @PutMapping("/update-book/{userId}")
    public ResponseEntity<?> updateBook(@RequestBody Book book, @PathVariable String userId){
        return new ResponseEntity<>(bookService.updateBook(book,userId),HttpStatus.OK);
       }

       @DeleteMapping("/delete-book/{userId}/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable String userId,@PathVariable String id){
        return  new ResponseEntity<>(bookService.DeleteBook(id,userId),HttpStatus.OK);
       }

}

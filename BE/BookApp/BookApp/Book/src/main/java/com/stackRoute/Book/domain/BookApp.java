package com.stackRoute.Book.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class BookApp {
    @Id
    private  String emailId;
    private String name,phone,address,password;
    List<Book> bookList;
}

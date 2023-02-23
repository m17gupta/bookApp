package com.stackRoute.Book.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.annotation.processing.Generated;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Book {
    @Id
    private String bookId;
    private String bookTitle, bookAuthor, stock, bookDescription;

}
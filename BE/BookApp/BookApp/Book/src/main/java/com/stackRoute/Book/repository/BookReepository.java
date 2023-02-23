package com.stackRoute.Book.repository;

import com.stackRoute.Book.domain.BookApp;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface BookReepository extends MongoRepository< BookApp,String> {

}

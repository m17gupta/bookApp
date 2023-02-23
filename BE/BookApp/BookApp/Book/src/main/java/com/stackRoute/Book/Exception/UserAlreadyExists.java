package com.stackRoute.Book.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.ALREADY_REPORTED,reason = "user Already Exists")
public class UserAlreadyExists extends Exception {
}

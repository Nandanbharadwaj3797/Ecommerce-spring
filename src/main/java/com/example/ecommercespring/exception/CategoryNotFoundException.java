package com.example.ecommercespring.exception;

public class CategoryNotFoundException  extends RuntimeException {
    public CategoryNotFoundException(String message ) {
        super( message );
    }
}


//why extends RuntimeException
//marks it an unchecked exception .caller are not forced to declare or catch it.
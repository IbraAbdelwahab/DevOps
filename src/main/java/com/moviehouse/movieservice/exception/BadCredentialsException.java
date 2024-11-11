package com.moviehouse.movieservice.exception;

public class BadCredentialsException extends Throwable {
    public BadCredentialsException(String invalidOrExpiredToken) {
    }
}

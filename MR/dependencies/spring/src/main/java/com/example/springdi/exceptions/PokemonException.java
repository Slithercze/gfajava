package com.example.springdi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

public class PokemonException extends RuntimeException {
  private HttpStatus httpStatus;

  public PokemonException(String message, HttpStatus statusCode) {
    super(message);
    this.httpStatus = statusCode;
  }

  public HttpStatus getStatusCode() {
    return httpStatus;
  }
}

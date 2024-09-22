package com.redyhire.llmgateway.exceptions;

/** This is a custom exception raised due to login failure */
public class LoginFailureException extends RuntimeException {
  public LoginFailureException(String message) {
    super(message);
  }
}

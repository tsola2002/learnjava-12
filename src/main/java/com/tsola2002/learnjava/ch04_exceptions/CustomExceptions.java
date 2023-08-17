package com.tsola2002.learnjava.ch04_exceptions;

public class CustomExceptions {

 class MyCheckedException extends Exception{

   public MyCheckedException(String message) {
     super(message);
   }

 }

  class MyUncheckedException extends RuntimeException{

    public MyUncheckedException(String message) {
      super(message);
    }

  }






}

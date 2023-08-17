package com.tsola2002.learnjava.ch04_exceptions;

public class Framework {

  public static void main(String[] args) {
    catchException1();
  }

  public static void catchException1(){

    try {
      method(null);
    } catch ( Exception ex){
      System.out.println(ex.getClass().getCanonicalName());
      ex.printStackTrace();
    }
  }

  public static void method(String s){
    if(s.equals("abc")){
      System.out.println("s equals to abc");
    } else {
      System.out.println("s is not equal to abc");
    }
  }



}

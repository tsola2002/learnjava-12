package com.tsola2002.learnjava.ch02_oop;

public class Vargs {

  private static String someMethod(String s, int i, double... arr){
    System.out.println(arr[0] + ", " + arr[1] + ", " + arr[2] + ", " + arr[3]);
    System.out.println(s);

    return s;
  }

  public static void main(String... args) {
    someMethod("shola", 419, 5, 2.5, 10.5, 11.5, 1);
  }





}

package com.tsola2002.learnjava.ch03_fundamentals;

public class Boxing {

  public static void main(String[] args) {
    boxing();
    unboxing();
  }

  private static void unboxing(){
    Integer i1 = Integer.valueOf(42);
    int i2 = i1.intValue();
    System.out.println(i2);

    double d = i1.doubleValue();
    System.out.println(d);
  }

  private static void boxing(){
    int i1 = 42;
    Integer i2 = i1;
   // System.out.println(i2);

    Double d = Double.valueOf(i1);
  //  System.out.println(d);

  }

}

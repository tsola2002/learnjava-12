package com.tsola2002.learnjava.ch03_fundamentals;

public class ReferenceTypes {

  public static void main(String... args) {
    enumDemo();


  }

  private static void enumDemo(){

    System.out.println(Season.WINTER.ordinal());
    System.out.println(Season.WINTER.name());
    System.out.println(Season.WINTER.toString());
    Season season = Enum.valueOf(Season.class, "AUTUMN");
    System.out.println(season == Season.AUTUMN);

    // PRINTS ALL VALUES OF THE ENUM
    for(Season s: Season.values()){
      System.out.println(s.toString() + " ");
    }


  }

  enum Season {
    SPRING,
    SUMMER,
    AUTUMN,
    WINTER
  }



  interface C {}
  interface B extends C {}
  class A implements B {

  }
  B b = new A();
  C c = new A();

  A a1 = (A)b;

  A a2 = (A)c;
}

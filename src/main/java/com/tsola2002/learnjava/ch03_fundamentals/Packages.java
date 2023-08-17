package com.tsola2002.learnjava.ch03_fundamentals;

import static com.tsola2002.learnjava.ch02_oop.StaticMembers.SomeClass.SOME_PROPERTY;
import static com.tsola2002.learnjava.ch02_oop.StaticMembers.SomeClass.someMethod;

import com.tsola2002.learnjava.ch02_oop.hiding.*;


public class Packages {

  public static void main(String... args) {
    C c = new C();
    D d = new D();

   // SomeClass obj = new SomeClass();
    someMethod(42);
    System.out.println(SOME_PROPERTY);

  }

}

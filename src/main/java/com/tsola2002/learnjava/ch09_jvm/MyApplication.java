package com.tsola2002.learnjava.ch09_jvm;

//import com.tsola2002.learnjava.ch09_jvm.example.ExampleClass;

public class MyApplication {

  public static void main(String... args) {
      System.out.print("Program Arguments are: "); //prints: Hello, world!

      // prints all program arguments
      for(String arg: args){
        System.out.print( arg + " " );
      }

      // prints values of VM options someParameter
      String p = System.getProperty("someParameter");
      System.out.println("\n vm options are: " + p);

      // prints values of environment variables
      String u = System.getenv("someVar");
      System.out.println("\n Environment Variables are: " +u);

      // multiplies by 2 and brings in example class
      //      int i = ExampleClass.multiplyByTwo(2);
      //      System.out.println(i);
    
  }

}

package com.tsola2002.learnjava.ch03_fundamentals;


import java.util.Arrays;

public class ArrayDemo {

  public static void main(String... args) {
    array1();
  }



  private static void array1(){
    int[] numbers = new int[3];
    numbers[0] = 1;
    numbers[1] = 2;
    numbers[2] = 3;
    System.out.println("numbers = " + Arrays.toString(numbers));
    int[] intArray = {1,2,3,4,5,6,7,8,9,10};
    float[][][][][]floatArray = new float[3][3][3][3][3];
    double[][] doubleArray ={{1.1, 2.2, 3, 2},{10,20,30,5},{1,2,3,4}};
    String[] stringArray = {"abc", "a23"};
    System.out.println();
   // System.out.println(floatArray[2][2]); //prints: 0.0

    System.out.println(stringArray[0]);
    System.out.println(stringArray[1]);
    System.out.println(doubleArray[0][3]);
  }

}

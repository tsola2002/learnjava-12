package com.tsola2002.learnjava.ch03_fundamentals;

public class WideningNarrowing {

  public static void main(String[] args) {
    widening();
    narrowing();
    wrapperMethod();
    stringConvert();
  }

  public static void stringConvert(){
//    byte b1 = Byte.parseByte("42");
//    System.out.println(b1);
//    Byte b2 = Byte.decode("42");
//    System.out.println(b2);


    String s1 = Integer.toString(54);
    System.out.println(s1.getClass().getSimpleName());
    String s2 = Double.toString(3.14);
    System.out.println(s2);
  }

  // CONVERSION USING ABSTRACT METHODS
  // FROM THE WRAPPER CLASS
  public static void wrapperMethod(){
    int i = 123456789;
    double d = Integer.valueOf(i).doubleValue();
    System.out.println(i);
    //System.out.println(d);
  }

  public static void narrowing(){
   // System.out.println(Integer.MAX_VALUE);
    double d1 = 1234567890.0;
   // System.out.println(d1);
   // System.out.println((int)d1);
  }

  public static void widening(){
    int i = 1234567890;
    double d = (double) i;
    //System.out.println((int)d);
   // System.out.println(i);
   // System.out.println(d);

    //CONVERTING A LONG TO A FLOAT
    long l1 =  12345678L;
    float f1 =  (float)l1;
   // System.out.println(l1);
   // System.out.println(f1);

  }

}

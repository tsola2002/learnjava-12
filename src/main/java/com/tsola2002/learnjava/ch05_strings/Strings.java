package com.tsola2002.learnjava.ch05_strings;

public class Strings {

  public static void main(String[] args) {
    //length();
    //isEmpty();
    //indexOf();
    // equals();
    //contains();
    //substring();
    //format();
    //concat();
    // split();
    //repeat();
    strip();
  }

  private static void length(){
    String s7 = "42";
    System.out.println(s7.length());
  }

  private static void isEmpty(){
    System.out.println("".isEmpty());
    System.out.println("".isBlank());
    System.out.println(" ".isEmpty());
  }

  private static void indexOf(){
    //    String s6 = "abc42t%";
    //    System.out.println(s6.indexOf("4"));
    //    System.out.println(s6.indexOf("%"));
    System.out.println("ebebbeeb eb eb".lastIndexOf("eb"));
  }

  public static void equals(){
    String s1 = "abc";
    String s2 = "abc";
    String s3 = "acb";

//    System.out.println(s1.equals(s2));
//    System.out.println(s1.equals(s3));
//    System.out.println("abc".equals(s1));
//    System.out.println("abc".equals(s3));

    String s4 = "aBc";
    String s5 = "Abc";

      //    System.out.println(s4.equalsIgnoreCase(s5));
      //    System.out.println("aBc".equalsIgnoreCase(s5));
      //    System.out.println("def".equalsIgnoreCase(s5));

      System.out.println(s1.contentEquals(s2));
      System.out.println("abc".contentEquals(s2));
  }

  public static void contains(){
    String s6 = "abc42t%";
    String s7 = "42";
    String s8 = "xyz";

//    System.out.println(s6.contains(s7));
//    System.out.println(s6.contains("ac"));
//    System.out.println(s6.contains(s8));

    System.out.println(s6.startsWith("abc"));
    System.out.println(s6.endsWith("2t%"));
    System.out.println(s6.startsWith("42", 3));
    System.out.println(s6.endsWith("%"));

    String s4 = "aBc";
    String s5 = "Abc";

    System.out.println(s4.compareTo(s5));
  }

  private static void substring(){
//    System.out.println("42".substring(0));
//    System.out.println("42".substring(1));
//    System.out.println("42".substring(2));
    System.out.println("42".substring(0,1));
    // System.out.println("42".substring(-1));
    String s6 = "abc42t%";
    System.out.println(s6.substring(3, 6));

  }

  private static void format(){
    String t = "Hey, %s Give me %d apples, please!";
    System.out.println(String.format(t, "Shola", 419));

    String t1 = String.format(t, "Nick", 2);
    System.out.println(t1);
  }

  private static void concat(){
    String s7 = "42";
    String s8 = "xyz";
    String newStr1 = s7.concat(s8);
    System.out.println(newStr1);
  }

  private static void split(){
    //System.out.println("\nString method split():");
    String[] arr = "abcbc".split("b");
    System.out.println(arr.toString());   //prints: a
   // System.out.println(arr[1]);   //prints: c
   // System.out.println(arr[2]);   //prints: c
  }

  private static void repeat(){
    System.out.println("\nString method repeat():");
    System.out.println("ab".repeat(3)); //prints: ababab
    System.out.println("ab".repeat(1)); //prints: ab
    System.out.println("ab".repeat(0)); //prints:
  }

  private static void strip(){
    System.out.println("\nString method strip():");
    String sp = "   abc   ";
    System.out.println("'" + sp + "'");                 //prints: '   abc   '
    System.out.println("'" + sp.stripLeading() + "'");  //prints: 'abc   '
    System.out.println("'" + sp.stripTrailing() + "'"); //prints: '  abc'
    System.out.println("'" + sp.strip() + "'");         //prints: 'abc'
  }

}

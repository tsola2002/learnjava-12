package com.tsola2002.learnjava.ch07_libraries;



import org.apache.commons.codec.binary.Base64;

public class Codec {

  public static void main(String[] args) {

    String encodedString  = new String(Base64.encodeBase64("Hello, World!".getBytes()));

    System.out.println(encodedString.getBytes());

  }

}

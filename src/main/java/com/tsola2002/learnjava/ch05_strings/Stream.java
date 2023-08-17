package com.tsola2002.learnjava.ch05_strings;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Stream {

  public static void main(String[] args) {

        // byteArrayInputStream1();
        // byteArrayInputStream3();
            fileInputStream1();
        //    objectInputOutputStream();
        //    pipedInputOutputStream1();
        //    sequenceInputStream();
        //    filterInputStream();
        //   printStream1();
        //    streamTokenizer();
        //    scanner1();

       // File f = new File("."); //points to the current directory
      //  System.out.println(f.getAbsolutePath());

  }

  private static void printStream1() {
    String fileName = "output.txt";
    try(FileOutputStream  fos = new FileOutputStream(fileName);
        PrintStream ps = new PrintStream(fos)){
      ps.println("Hi there!");
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }


  private static byte[] bytesSource(){
    // creates a byte variable
    return new byte[]{42, 43, 44};
  }

  private static void byteArrayInputStream1() {
    // creating a buffer
    byte[] buffer2 = bytesSource();


    try(ByteArrayInputStream bais = new ByteArrayInputStream(buffer2)){
      int data = bais.read();
      while(data != -1) {
        System.out.print(data + " ");   //prints: 42 43 44
        // reading the bytes using the read() function
        data = bais.read();
      }
    } catch (Exception ex){
      ex.printStackTrace();
    }
  }

  private static void byteArrayInputStream3() {
    System.out.println("\nbyteArrayInputStream3():");
    byte[] buffer = bytesSource();
    try(ByteArrayInputStream bais = new ByteArrayInputStream(buffer)){
      int data = bais.read();
      while (data != -1) {
        System.out.print(((char)data) + " ");   //prints: * + ,
      }
    } catch (Exception ex){
      ex.printStackTrace();
    }
  }

  private static void fileInputStream1() {
    // create a variable to store the file path
    String filePath = "src/main/resources/hello.txt";
    try(FileInputStream fis = new FileInputStream(filePath)){
      int data;
      while ((data = fis.read()) != -1) {
        System.out.print(((char)data) + " ");   //prints: H e l l o !
      }
    } catch (Exception ex){
      ex.printStackTrace();
    }
  }



}

package com.tsola2002.learnjava.ch11_network;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

public class UrlClient {

  public static void main(String[] args) {
   //getFromFile();
   //getFromUrl();
   postToUrl();
  }

  private static void getFromFile() {

    try {
      // path to the file that is relative to the program's executing location
      URL url = new URL("file:src/main/resources/hello.txt");
      System.out.println(url.getPath());  //src/main/resources/hello.txt
      System.out.println(url.getFile());
      // input stream to take in data from a file
      try(InputStream is = url.openStream()){
        // reading contents of is stream of data
        int data = is.read();
        while(data != -1){
          // we convert from byte to character
          System.out.print((char) data); //prints: Hello!
          data = is.read();
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private static void getFromUrl() {
    try {
      //URL url = new URL("https://www.google.com/search?q=Java&num=10");
      URL url = new URL("https://www.youtube.com/results?search_query=java&sp=EgIIAQ%253D%253D");
      System.out.println(url.getPath());  //prints: /search
      System.out.println(url.getFile());  //prints: /search?q=Java&num=10

      // we create URL connection object because it
      // is need for live url communication
      URLConnection conn = url.openConnection();
      // we specify the headers for the url connection
      conn.setRequestProperty("Accept", "text/html");
      conn.setRequestProperty("Connection", "close");
      conn.setRequestProperty("Accept-Language", "en-US");
      conn.setRequestProperty("User-Agent", "Mozilla/5.0");

      // input stream to take in data from a live url
      try(InputStream is = conn.getInputStream();
          BufferedReader br = new BufferedReader(new InputStreamReader(is))){
        String line;
        while ((line = br.readLine()) != null){
          System.out.println(line);
        }
      }
    }
    catch(Exception ex){
      ex.printStackTrace();
    }
  }



  private static void postToUrl() {
    try {
      // create another url
      URL url = new URL("http://localhost:3333/something");

      // create connection to the url
      URLConnection conn = url.openConnection();

      // conn.setRequestProperty("Method", "POST");
      // conn.setRequestProperty("User-Agent", "Java client");

      // indicate that output has to be sent to the server
      conn.setDoOutput(true);

      // we let the output stream send the query parameters to the server.
      try(OutputStreamWriter osw = new OutputStreamWriter(conn.getOutputStream()))
      {
        // appending query parameters
        osw.write("parameter1=value1&parameter2=value2");
        // closing the output stream
        osw.flush();
      }

      // input stream to take in data from a live url
      try(BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream())))
        {
          String line;
          while ((line = br.readLine()) != null) {
            System.out.println(line);
          }
        }
    }
    catch (Exception ex)
    {
      ex.printStackTrace();
    }
  }

}


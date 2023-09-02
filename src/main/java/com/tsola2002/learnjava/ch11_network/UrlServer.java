package com.tsola2002.learnjava.ch11_network;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class UrlServer {

  public static void main(String[] args) throws Exception {
      // we create our http server
      HttpServer server = HttpServer.create(new InetSocketAddress(3333),0);
      // listens for /something and activates posthandler
      server.createContext("/something", new PostHandler());
      server.setExecutor(null);
      // start the server
      server.start();

  }

  static class PostHandler implements HttpHandler {

    public void handle(HttpExchange exch) {
      System.out.println();   //to skip the row
      System.out.println(exch.getRequestURI());            //prints: /something
      System.out.println(exch.getHttpContext().getPath()); //prints: /something

      // input stream to take in data from a live url
      try(BufferedReader in = new BufferedReader(
          new InputStreamReader(exch.getRequestBody()));

          // get input stream and store it as output stream
          //extracts the response body and stores it in an output stream
          OutputStream os = exch.getResponseBody()){
          System.out.println("Received as body:");

          // prints out the input streams body
          in.lines().forEach(
              l -> System.out.println("  " + l)
          );

        String confirm = "Got it! Thanks.";
        exch.sendResponseHeaders(200, confirm.length());
        os.write(confirm.getBytes());
      } catch (Exception ex){
        ex.printStackTrace();
      }
    }
  }
}




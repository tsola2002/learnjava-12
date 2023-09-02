package com.tsola2002.learnjava.ch11_network;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandler;
import java.net.http.HttpResponse.BodyHandlers;
import java.net.http.HttpResponse.PushPromiseHandler;
import java.net.http.WebSocket;
import java.net.http.WebSocket.Listener;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class HttpClientDemo {

  public static void main(String[] args) {
    // get();
    // post();
    //getAsync();
    // postAsync();
    // postAsyncMultiple();
    // postAsyncMultipleUsingPool();
    //push();
    webSocket();
  }

  private static void get() {
    HttpClient httpClient = HttpClient.newHttpClient();

    // BUILDING A HTTPCLIENT USING A BUILDER
    //    HttpClient httpClient = HttpClient.newBuilder()
    //        .version(Version.HTTP_2) //default
    //        .build();

    HttpRequest req = HttpRequest.newBuilder()
        .uri(URI.create("http://localhost:3333/something"))
        .GET()
        .build();

    try{
      HttpResponse<String> resp =
          httpClient.send(req, BodyHandlers.ofString());

      System.out.println("Response: " +
          resp.statusCode() + " : " + resp.body());
    }
    catch(Exception ex){
      ex.printStackTrace();
    }
  }

  private static void post(){
    HttpClient httpClient = HttpClient.newHttpClient();

    HttpRequest req = HttpRequest.newBuilder()
        .uri(URI.create("http://localhost:3333/something"))
        .POST(BodyPublishers.ofString("Hi there from http client"))
        .build();

    try {
      HttpResponse<String> resp = httpClient.send(req, BodyHandlers.ofString());
      System.out.println("Response: " + resp.statusCode() + " : " + resp.body());
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  private static void getAsync(){
    HttpClient httpClient = HttpClient.newHttpClient();

    HttpRequest req = HttpRequest.newBuilder()
        .uri(URI.create("http://localhost:3333/something"))
        .GET()   // default
        .build();

        // the client will send using sendAsync() method returns an instance of the
        // CompletableFuture<HttpResponse> class.
        /*
        CompletableFuture<Void> cf =
        httpClient.sendAsync(req, BodyHandlers.ofString())
                // thenAccept() method applies the passed-in functionality
                // to the result returned by the previous method of the chain.
                .thenAccept(resp -> System.out.println("Response: " +
                                resp.statusCode() + " : " + resp.body()));
        */


            CompletableFuture<String> cf =
                httpClient.sendAsync(req, BodyHandlers.ofString())
                    // thenApply() method, which accepts a function that returns a value
                    .thenApply(resp -> "Server responded: " + resp.body());

    System.out.println("The request was sent asynchronously...");
    try {
      // which specify the number of the units, indicating how long the method
      // should wait for the task that is represented
      // by the CompletableFuture<Void> object to complete
      System.out.println("CompletableFuture get: " +
          cf.get(5, TimeUnit.SECONDS));
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    System.out.println("Exit the client...");
  }

  private static void postAsync(){
    HttpClient httpClient = HttpClient.newHttpClient();

    HttpRequest req = HttpRequest.newBuilder()
        .uri(URI.create("http://localhost:3333/something"))
        .POST(BodyPublishers.ofString("Hi there!"))
        .build();

    CompletableFuture<String> cf =
        httpClient.sendAsync(req, BodyHandlers.ofString())
            .thenApply(resp -> "Server responded: " + resp.body());
    System.out.println("The request was sent asynchronously...");
    try {
      System.out.println("CompletableFuture get: " +
          cf.get(5, TimeUnit.SECONDS));
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    System.out.println("Exit the client...");
  }

  private static void postAsyncMultiple(){
    HttpClient httpClient = HttpClient.newHttpClient();

    List<CompletableFuture<String>> cfs = new ArrayList<>();
    List<String> nums = List.of("1", "2", "3");
    for(String num: nums){
      // create the request object for sending
      HttpRequest req = HttpRequest.newBuilder()
          .uri(URI.create("http://localhost:3333/something"))
          .POST(BodyPublishers.ofString("Hi! My name is " + num + "."))
          .build();

      // use the client to send the request
      CompletableFuture<String> cf = httpClient
          .sendAsync(req, BodyHandlers.ofString())
          .thenApply(rsp -> "Server responded to msg " + num + ": "
              + rsp.statusCode() + " : " + rsp.body());
      cfs.add(cf);
    }
    System.out.println("The requests were sent asynchronously...");
    try {
      for(CompletableFuture<String> cf: cfs){
        System.out.println("CompletableFuture get: " + cf.get(5, TimeUnit.SECONDS));
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    System.out.println("Exit the client...");
  }

  private static void postAsyncMultipleUsingPool(){
    // creating 2 thread pools on which the postAsync will run on
    ExecutorService pool = Executors.newFixedThreadPool(2);

    // creating the client using the pool
    HttpClient httpClient = HttpClient.newBuilder()
                                      .executor(pool)
                                      .build();

    List<CompletableFuture<String>> cfs = new ArrayList<>();
    List<String> nums = List.of("1", "2", "3");
    for(String num: nums){
      HttpRequest req = HttpRequest.newBuilder()
          .uri(URI.create("http://localhost:3333/something"))
          .POST(BodyPublishers.ofString("Hi! My name is " + num + "."))
          .build();
      CompletableFuture<String> cf = httpClient
          .sendAsync(req, BodyHandlers.ofString())
          .thenApply(rsp -> "Server responded to msg " + num + ": "
              + rsp.statusCode() + " : " + rsp.body());

      cfs.add(cf);
    }
    System.out.println("The requests were sent asynchronously...");
    try {
      for(CompletableFuture<String> cf: cfs){
        System.out.println("CompletableFuture get: " + cf.get(5, TimeUnit.SECONDS));
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    System.out.println("Exit the client...");
  }

  private static void push(){
    HttpClient httpClient = HttpClient.newHttpClient();

    HttpRequest req = HttpRequest.newBuilder()
        .uri(URI.create("http://localhost:3333/something"))
        .GET()
        .build();

    // response(FUTURE async equals to the client sending the body)
    // the third parameter of the sendAsync() method is a function that handles the push response if one comes from the server.
    CompletableFuture cf =
        httpClient.sendAsync(req, BodyHandlers.ofString(), (PushPromiseHandler) HttpClientDemo::applyPushPromise);

    System.out.println("The request was sent asynchronously...");
    try {
      System.out.println("CompletableFuture get: " + cf.get(5, TimeUnit.SECONDS));
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    System.out.println("Exit the client...");
  }

  private static void applyPushPromise(HttpRequest initReq, HttpRequest pushReq,
      Function<BodyHandler, CompletableFuture<HttpResponse>> acceptor) {

    // It just prints out the URI of the push origin
    CompletableFuture<Void> cf = acceptor.apply(BodyHandlers.ofString())
                                         .thenAccept(resp -> System.out.println("Got pushed response " + resp.uri()));
    try {
      System.out.println("Pushed completableFuture get: " + cf.get(1, TimeUnit.SECONDS));
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    System.out.println("Exit the applyPushPromise function...");

  }

  private static void webSocket(){
    HttpClient httpClient = HttpClient.newHttpClient();

    // we create a websocket object of the client using the websocket builder
    WebSocket webSocket = httpClient.newWebSocketBuilder()
        // build async method returns a completablefuture
        // The join() method of the CompletableFuture class returns the result value when complete,
        // OUTDATED CODE
        //.buildAsync(URI.create("ws://echo.websocket.org"), new WsClient())
        .buildAsync(URI.create("ws://echo.websocket.events"), new WsClient())
        .join();


    System.out.println("The WebSocket was created and ran asynchronously.");

    // our client waits for 200 milliseconds, and then sends the Close message and exits. I
    try {
      TimeUnit.MILLISECONDS.sleep(200);
    } catch (InterruptedException ex) {
      ex.printStackTrace();
    }

    // WebSocket communication continues until either side sends a Close message.
    webSocket.sendClose(WebSocket.NORMAL_CLOSURE, "Normal closure")
        .thenRun(() -> System.out.println("Close is sent."));
  }


  private static class WsClient implements WebSocket.Listener {
    @Override
    public void onOpen(WebSocket webSocket) {
      System.out.println("Connection established.");
      webSocket.sendText("Some message", true);
      Listener.super.onOpen(webSocket);
    }
    @Override
    public CompletionStage onText(WebSocket webSocket, CharSequence data, boolean last) {
      System.out.println("Method onText() got data: " + data);
      if(!webSocket.isOutputClosed()) {
        webSocket.sendText("Another message", true);
      }
      return Listener.super.onText(webSocket, data, last);
    }
    @Override
    public CompletionStage onClose(WebSocket webSocket, int statusCode, String reason) {
      System.out.println("Closed with status " + statusCode + ", reason: " + reason);
      return Listener.super.onClose(webSocket, statusCode, reason);
    }

  }


}

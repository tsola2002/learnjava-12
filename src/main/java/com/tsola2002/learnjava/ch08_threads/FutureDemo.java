package com.tsola2002.learnjava.ch08_threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Future {

  public static void main(String[] args) {
    futureSubmitRunnable1();
  }



  private static void futureSubmitRunnable1() {

    System.out.println("\nfutureSubmitRunnable1:\n");

    ExecutorService pool = Executors.newSingleThreadExecutor();

    // FUTURE IS AN OBJECT THAT WILL HOLD NEW DETAILS OF OUR THREAD
    Future future = pool.submit(new MyRunnable("One"));

    System.out.println(future.isDone());         //prints: false
    System.out.println(future.isCancelled());    //prints: false
    try{
      System.out.println(future.get());        //prints: null
      System.out.println(future.isDone());     //prints: true
      System.out.println(future.isCancelled());//prints: false
    } catch (Exception ex){
      ex.printStackTrace();
    } finally {
      shutdownAndTerminate(pool);
    }

  }

  private static class MyRunnable implements Runnable {
    private String name;

    public MyRunnable(String name) {
      this.name = name;
    }

    public void run() {
      try {
        System.out.println(this.name + " is working...");
        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println(this.name + " is done");
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        System.out.println(this.name + " was interrupted\n" +
            this.name + " Thread.currentThread().isInterrupted()="
            + Thread.currentThread().isInterrupted());
      }
    }
  }


}

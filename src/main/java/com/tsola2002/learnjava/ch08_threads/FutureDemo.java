package com.tsola2002.learnjava.ch08_threads;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class FutureDemo {

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

  private static void shutdownAndTerminate(ExecutorService pool){
    try {
      long timeout = 100;
      TimeUnit timeUnit = TimeUnit.MILLISECONDS;
      System.out.println("Waiting all threads completion for "
          + timeout + " " + timeUnit + "...");
      // Blocks until timeout or all threads complete execution,
      // or the current thread is interrupted, whichever happens first.
      boolean isTerminated =
          pool.awaitTermination(timeout, timeUnit);
      System.out.println("isTerminated()=" + isTerminated);
      if (!isTerminated) {
        System.out.println("Calling shutdownNow()...");
        List<Runnable> list = pool.shutdownNow();
        System.out.println(list.size() + " threads running");
        isTerminated =
            pool.awaitTermination(timeout, timeUnit);
        if (!isTerminated) {
          System.out.println("Some threads are still running");
        }
        System.out.println("Exiting");
      }
    } catch (InterruptedException ex) {
      ex.printStackTrace();
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

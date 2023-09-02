package com.tsola2002.learnjava.ch08_threads;

import java.util.concurrent.TimeUnit;

public class Threads {

  public static void main(String[] args) {

    for(int i = 0; i<=5; i++){
      Counter th1 = new Counter();
      th1.start();

    }

//    Counter th1 = new Counter();
//    Counter th2 = new Counter();

    // STARTS A NEW THREAD
//    th1.start();
//    th2.start();


  }

  public static class Counter extends Thread{

    @Override
    public void run(){

      for ( int i = 0; i <= 5; i++ ){

        System.out.println(i);

        try {
          Thread.sleep(3000);
        }
        catch (InterruptedException e) {
          throw new RuntimeException(e);
        }


      }
    }



  }

}

package com.tsola2002.learnjava.ch08_threads;

import java.util.concurrent.TimeUnit;

public class ThreadMain {

  public static void main(String[] args) {

    ThreadInfo myRunnable1  =  new ThreadInfo("One");
    ThreadInfo myRunnable2 = new ThreadInfo("Two");


    Thread tr1 = new Thread(myRunnable1);
    Thread tr2 = new Thread(myRunnable2);

    tr1.start();

    tr2.setDaemon(true);
    tr2.start();

    pauseFiveSeconds();
    myRunnable1.setParameter("exit");

    pauseFiveSeconds();
    System.out.println("Main thread exists");
  }

  private static void pauseFiveSeconds(){
    try { TimeUnit.SECONDS.sleep(5);
    }
    catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

}

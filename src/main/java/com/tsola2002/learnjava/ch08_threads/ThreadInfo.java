package com.tsola2002.learnjava.ch08_threads;

import java.util.concurrent.TimeUnit;

public class ThreadInfo implements Runnable {

  private String parameter, name;

  // CONSTRUCTOR
  public ThreadInfo( String name) {
    this.name = name;
  }

  public void run() {
    while (!"exit".equals(parameter)) {
      System.out.println("The Thread type is a: " + this.name +
          "parameter is: " + parameter);
      pauseOneSecond();
    }
  }

  private static void pauseOneSecond(){
    try {
      TimeUnit.SECONDS.sleep(1);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public void setParameter(String parameter) {
    this.parameter = parameter;
  }


}



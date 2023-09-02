package com.tsola2002.learnjava.ch07_libraries;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Logging {

  static final Logger logger = LogManager.getLogger(Logging.class.getName());

  public static void main(String... args) {
    new Logging().multiplyByTwo(null);
  }

    public int multiplyByTwo(Class2 class2){
      if(class2 == null){
        // USE THE LOG4J LIBRARY TO LOG AN ERROR
        logger.error("THIS IS VERY WRONG");
        System.exit(1);
      }
      return class2.getValue() * 2;
  }

}

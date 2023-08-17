package com.tsola2002.learnjava.ch06_collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionUtils {

  public static void main(String[] args) {
    javaUtilCollections_copy();
  }

  private static void javaUtilCollections_copy() {
    List<String> list1 = Arrays.asList("s1","s2");
    List<String> list2 = Arrays.asList("s3", "s4", "s5", "s6");
    Collections.copy(list2, list1);
    System.out.println(list2);    //prints: [s1, s2, s5]
  }


}

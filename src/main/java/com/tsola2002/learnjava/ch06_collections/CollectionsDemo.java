package com.tsola2002.learnjava.ch06_collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionsDemo {

  public static void main(String[] args) {
    //initialize1();
    //initialize2();
    //initialize3();
    //iterable();
     map();
  }

  public static void map(){
    Map<Integer, String> map = Map.of(1, "s1",
        2, "s2", 3, "s3");

    for(Integer key: map.keySet()){
      System.out.print(key + " : " + map.get(key) + ", ");
     // System.out.print(key + ", ");
    }

    for(Map.Entry e : map.entrySet()){
      //System.out.print(e.getKey() + " : " + e.getValue() + ",");
      System.out.print(e + ", ");
    }
  }

  public static void iterable() {
//    Iterable<String> list = List.of("s1", "s2", "s3");
//    System.out.println(list);

    //Iterable<String> list = Arrays.asList("s1", "s2", "s3"); //List.of("s1", "s2", "s3");
    //System.out.println(list);

//    for(String e: list ){
//      System.out.print(e + " ");
//    }

  //  list.forEach(e -> System.out.print(e + " "));
  }

  public static void initialize3(){

    Collection<String> list1 = List.of("s1", "s1", "s2");
    System.out.println(list1);

    List<String> list2 = new ArrayList<>(list1);
    System.out.println(list2);

    Set<String> set = new HashSet<>(list1);
    System.out.println(set);



//    List<String> list3 = new ArrayList<>(set);
//    System.out.println(list3);

//prints: [s1, s2]

  }


  public static void initialize2(){

    //creating an arraylist
    List<String> list1 = new ArrayList<>();

    //add an item to the arraylist
    list1.add("l1");
    list1.add("l1");
    System.out.println(list1);

    List<String> list2 = new ArrayList<>();
    list2.add("s4");
    list2.addAll(list1);

    System.out.println(list2);


    Set<String> set1 = new HashSet<>();
    set1.add("s1");
    set1.add("s1");

    set1.addAll(list1);
    System.out.println(set1);
  }

  public static void initialize1(){
    Collection<String> col1 = List.of("s1", "s2", "s3");
    System.out.println(col1);

    col1 = Set.of("s4", "s5", "s6");
    System.out.println(col1);
  }

}

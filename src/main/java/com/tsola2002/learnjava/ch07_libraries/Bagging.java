package com.tsola2002.learnjava.ch07_libraries;

import java.util.Map;
import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.IterableMap;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.OrderedMap;
import org.apache.commons.collections4.bag.HashBag;
import org.apache.commons.collections4.bidimap.TreeBidiMap;
import org.apache.commons.collections4.map.HashedMap;
import org.apache.commons.collections4.map.LinkedMap;

public class Bagging {

  public static void main(String[] args) {
  //  bagging();
  //  bidiMap();
    // mapIterator();
    orderedMapping();
  }

  private static void orderedMapping() {
    OrderedMap<Integer, String> map = new LinkedMap<>();
    map.put(4, "four");
    map.put(5, "five");
    map.put(6, "six");
    System.out.println(map.lastKey());
    System.out.println(map.nextKey(4));
  }

  private static void mapIterator() {
    IterableMap<Integer, String> map =
                new HashedMap<>(Map.of(1, "one", 2, "two"));
    MapIterator it = map.mapIterator();
    while(it.hasNext()){
      Object key = it.next();
      Object value = it.getValue();
      System.out.print(key + ", " + value + ", ");

      if(((Integer)key) == 2){
        it.setValue("three");
      }
    }
    System.out.println("\n" + map);
  }

  private static void bidiMap() {

    BidiMap<Integer, String> bidi = new TreeBidiMap<>();
    bidi.put(2, "two");

    bidi.put(3, "three");

    bidi.put(4, "four");

    System.out.println(bidi);

    System.out.println(bidi.inverseBidiMap());

    System.out.println(bidi.get(4));

    System.out.println(bidi.getKey("four"));

    bidi.removeValue("three");

    System.out.println(bidi);
  }

  private static void bagging() {

    Bag<String> myBag = new HashBag<>();
    myBag.add("one", 5);
    System.out.println(myBag);

    myBag.remove("one", 1);
    System.out.println(myBag);

    System.out.println(myBag.getCount("one"));
  }

}

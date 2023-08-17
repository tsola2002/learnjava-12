package com.tsola2002.learnjava.ch02_oop;

public class SampleClass {

  public static void main(String[] args) {

    //int s = 2;

    AnotherClass an = new AnotherClass();
    for(String s: args){
      an.display(s);
    }
  }

  public static class AnotherClass {

    private int result;
    public void display(String s){
      System.out.println("s equals to " + s);
    }

    public int process(int i){

      result = i * 2;

      return result;

    }

    public int getResult(){

      return result;
    }

  }

}

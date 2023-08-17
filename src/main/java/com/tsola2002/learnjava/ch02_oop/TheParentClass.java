package com.tsola2002.learnjava.ch02_oop;

public class TheParentClass {



  private int prop;

  public TheParentClass(int prop){
    this.prop = prop;
  }

  public void someParentMethod(){}

}

class TheChildClass extends TheParentClass
{
  private String prop;

  public TheChildClass(int arg1, String arg2){
    super(arg1);
    this.prop = arg2;
  }
  public void someChildMethod(){



  }



}

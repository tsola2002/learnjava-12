package com.tsola2002.learnjava.ch03_fundamentals;

public class AccessModifiers {

  public static void main(String... args){
    // create an instance of accessModifier
    var top = new AccessModifiers();
    // accessing the toplevelprivatemethod of the object
    top.topLevelPrivateMethod();
    System.out.println(InnerStaticClass.PROP);


  }

  //ACCESS MODIFIED PROPERTIES
  String prop1;
  private String prop2;
  protected String prop3;
  public String prop4;

  //ACCESS MODIFIED METHODS
  void method1(){}
  private void method2(){}
  protected void method3(){}
  public void method4(){}

  //ACCESS MODIFIED CLASSES
  class A1{}
  private class A2{}
  protected class A3{}
  public class A4{}

  interface I1{}
  private interface I2{}
  protected interface I3{}
  public interface I4{}

  private String topLevelPrivateProperty = "Top-level private value";
  private void topLevelPrivateMethod(){
    // create instance of inner class
    var inner = new InnerClass();

    // access innerprivateproperty
    System.out.println(inner.innerPrivateProperty);

    // access the objects inner private method
    inner.innerPrivateMethod();
  }

  private class InnerClass{
    private String innerPrivateProperty = "Inner private value";

    private void innerPrivateMethod(){
      System.out.println(topLevelPrivateProperty);
    }
  }

  private class InnerStaticClass {
    private static String PROP = "Inner private static";
    private String innerPrivateProperty = "Inner private value";

    private void innerPrivateMethod(){
      var top = new AccessModifiers();
      System.out.println(top.topLevelPrivateProperty);
    }
  }

}

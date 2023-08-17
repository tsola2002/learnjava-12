package com.tsola2002.learnjava.ch02_oop;

public class Constructor {

  public static void main(String... args) {

    ChildClass ref1 = new ChildClass(1, "Java 12 class");
    ChildClass ref2 = new ChildClass(1, "Something");
    ParentClass par1  = new ParentClass(419);
    ref1.someMethod();
    ref2.someMethod();

    System.out.println(ref1.toString());



  }

  private int prop1;

  private String prop2;

  public Constructor(int prop1, String prop2) {
    this.prop1 = prop1;
    this.prop2 = prop2;
  }

  private static class ParentClass{
    public int p1;

    public ParentClass(int p1) {
      this.p1 = p1;
    }

    public void someParentMethod(){}

  }

  private static class ChildClass extends ParentClass  {
    private String prop;

    public ChildClass(int arg1, String arg2) {
      super(arg1);
      this.prop = arg2;
    }

    @Override
    public String toString() {
      return "ChildClass{" +
          "prop='" + prop + '\'' +
          ", p1=" + p1 +
          '}';
    }

    public void someMethod(){}


  }


}

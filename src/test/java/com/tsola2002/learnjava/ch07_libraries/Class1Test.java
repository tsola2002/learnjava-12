package com.tsola2002.learnjava.ch07_libraries;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class Class1Test {

  @Test
  public void multiplyByTwo() {
    Class2 class2Mock = Mockito.mock(Class2.class);

    Mockito.when(class2Mock.getValue())
           .thenReturn(5);

    Class1 class1 =  new Class1();
    int actualResult = class1.multiplyByTwo(class2Mock);

    Assert.assertEquals(10, actualResult);

  }

  @Test
  public void divideByTwo() {

    //CREATING A MOCK OBJECT
    Class2 class2Mock =  Mockito.mock(Class2.class);

    Mockito.when(class2Mock.getValue())
           .thenReturn(10);

    // CREATING THE REAL OBJECT TO TEST WITH
    Class1 class1 =  new Class1();

    // RUNNING THE CLASS1 METHOD USING OUR REAL OBJECT
    int divideResult = class1.divideByTwo(class2Mock);

    // VERIFY THE EXPECTED RESULT WITH THE ACTUAL RESULT
    Assert.assertEquals(5, divideResult);

  }
}
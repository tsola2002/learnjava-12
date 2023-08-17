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
}
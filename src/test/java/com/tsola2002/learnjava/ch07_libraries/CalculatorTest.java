package com.tsola2002.learnjava.ch07_libraries;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {

  @Test
  public void testAdd() {
    Calculator calculator = new Calculator();

    int result = calculator.add(5, 5);

    Assert.assertEquals(12, result);
  }
}
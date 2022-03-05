package com.damianmuca;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class MainTest {

  @Test(groups = {"fast"})
  public void start_trueShouldBeTrue() {
    assertTrue(true);
  }
}

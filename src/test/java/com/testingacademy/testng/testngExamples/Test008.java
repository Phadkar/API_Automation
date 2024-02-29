package com.testingacademy.testng.testngExamples;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class Test008 {
@Test
    void testCase01() {
        // Assertion -  AR == ER
        // Two Types Assertions
        // Soft Assertion

        // Expected Result - pramod

        SoftAssert s = new SoftAssert();
        s.assertEquals(true,false,"True should not be equal to false");
    System.out.println("Please execute me");
    s.assertAll();

//Hard Assertion
    Assert.assertEquals(true,false,"Failed");
    System.out.println("This will not print");
    }
}

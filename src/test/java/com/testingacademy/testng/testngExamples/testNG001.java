package com.testingacademy.testng.testngExamples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class testNG001 {
@Test
    public void testCase1(){
    Assert.assertEquals(true,true);
    }

    @Test
    public void testCase2(){
    Assert.assertEquals(false,true);
    }

}

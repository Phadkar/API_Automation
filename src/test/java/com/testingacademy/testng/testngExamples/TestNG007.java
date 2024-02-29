package com.testingacademy.testng.testngExamples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNG007 {

    @Test(groups = {"sanity","QA"})
    public void sanityRun(){
        System.out.println("Sanity Run");
        System.out.println("QA");
    }
    @Test(groups = {"Reg"})
    public void regRun(){
        System.out.println("Regression Run");
    }

    @Test(groups = {"smoke"})
    public void smokeRun(){
        System.out.println("Smoke Test");
        Assert.assertTrue(false);
    }
}

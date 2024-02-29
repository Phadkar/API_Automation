package com.testingacademy.testng.testngExamples;

import org.testng.annotations.Test;

public class TestNG006 {

    @Test (priority = 1)
    public void t1(){
        System.out.println("1");
    }

    @Test(priority = -1)
    public void t2(){
        System.out.println("2");
    }

    @Test (priority = 2)
    public void t3(){
        System.out.println("3");
    }
}
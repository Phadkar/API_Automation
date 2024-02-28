package com.testingacademy.testng;

import org.testng.annotations.*;

public class Test001 {

@BeforeSuite
void  demo11(){
    System.out.println("Before suite");
}
    @BeforeTest
    void  demo12(){
        System.out.println("Before Test");
    }
    @BeforeClass
    void  demo13(){
        System.out.println("Before Class");
    }
    @BeforeMethod
    void demo1(){
        System.out.println("Before Method");
    }
    @Test
    void demo(){
        System.out.println("Test");
    }

    @AfterMethod
    void demo2(){
        System.out.println("Before Method");
    }
    @AfterClass
    void  demo23(){
        System.out.println("After Class");
    }

    @AfterTest
    void  demo22(){
        System.out.println("After Test");
    }

    @AfterSuite
    void  demo21(){
        System.out.println("After suite");
    }

}

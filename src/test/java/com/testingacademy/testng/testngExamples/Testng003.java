package com.testingacademy.testng.testngExamples;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Testng003 {
String token;
Integer bookingID;
    public String getToken(){
        token = "123";
        return token;
    }
@BeforeTest
    public void getBookingID(){
        token = getToken();
        bookingID = 123;
    }
    @Test
    public void testPUTReq(){
        System.out.println(token);
        System.out.println(bookingID);
    }
@Test
    public void testPUTReq2(){
        System.out.println(token);
        System.out.println(bookingID);
    }
}

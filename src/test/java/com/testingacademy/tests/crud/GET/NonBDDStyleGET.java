package com.testingacademy.tests.crud.GET;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class NonBDDStyleGET {
    public static void main(String[] args) {
        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/2428").log().all();
        r.when().get();
        r.then().log().all().statusCode(200);
        RequestSpecification r2 = RestAssured.given();

        r2.baseUri("https://restful-booker.herokuapp.com");
        r2.basePath("/booking/2428").log().all();
        r2.when().get();
        r2.then().log().all().statusCode(200);
    }
}

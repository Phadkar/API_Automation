package com.testingacademy.tests.crud.GET;

import io.restassured.RestAssured;

public class BDDStyleGET {
    public static void main(String[] args) {
        RestAssured.given()
                .baseUri("https://www.zippopotam.us").basePath("/IN/400028")
                .when().log().all().get()
                .then().log().all().statusCode(201);
    }
}

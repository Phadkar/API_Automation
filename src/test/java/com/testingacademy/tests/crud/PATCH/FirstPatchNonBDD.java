package com.testingacademy.tests.crud.PATCH;

import io.restassured.RestAssured;

import io.restassured.http.ContentType;

import io.restassured.response.Response;

import io.restassured.response.ValidatableResponse;

import io.restassured.specification.RequestSpecification;

import org.hamcrest.Matchers;

import org.testng.annotations.Test;
public class FirstPatchNonBDD {

        RequestSpecification r;

        Response response;

        ValidatableResponse vr;



        String payload = "{\n" +

                " \"firstname\": \"Lungi\",\n" +

                " \"lastname\": \"Dance\"\n" +

                "}";

        @Test

        public void PatchNonBDD()

        {

            r= RestAssured.given().log().all();

            r.baseUri("https://restful-booker.herokuapp.com");

            r.basePath("/booking/11");

            r.contentType(ContentType.JSON);

//r.auth().basic("admin", "password123");

            r.body(payload);





            response = r.when().patch();





            vr = response.then().statusCode(200).log().all();

            vr.body("firstname", Matchers.equalTo("Lungi"));

            vr.body("lastname", Matchers.equalTo("Dance"));

        }







    }




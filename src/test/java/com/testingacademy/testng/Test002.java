package com.testingacademy.testng;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Test002 {
String token;
    RequestSpecification  requestSpecification;
    ValidatableResponse validatableResponse;
    @BeforeTest
    public void getToken(){
requestSpecification = RestAssured.given();
String payload= "{\n" +
        "    \"username\" : \"admin\",\n" +
        "    \"password\" : \"password123\"\n" +
        "}";
requestSpecification.basePath("https://restful-booker.herokuapp.com/");
requestSpecification.baseUri("auth");
requestSpecification.contentType(ContentType.JSON);
        requestSpecification.when().body(payload);
        Response response = RestAssured.post();
        validatableResponse = response.then();

        // Rest Assured -> Matchers (Hamcrest) - 1-2% Times you will be using it
        validatableResponse.body("token", Matchers.notNullValue());


        token = response.then().log().all().extract().path(token);
        //Testng
        Assert.assertNotNull(token);


        //Assertj
        //assertThat(token).isNotNull().isNotBlank().isNotEmpty();

    }

    @Test
    public void testNonBDDPUTReq(){
        String jsonString = "{\r\n" + "    \"firstname\" : \"Pramod\",\r\n" + "    \"lastname\" : \"Dutta\",\r\n"
                + "    \"totalprice\" : 111,\r\n" + "    \"depositpaid\" : true,\r\n" + "    \"bookingdates\" : {\r\n"
                + "        \"checkin\" : \"2018-01-01\",\r\n" + "        \"checkout\" : \"2019-01-01\"\r\n"
                + "    },\r\n" + "    \"additionalneeds\" : \"Breakfast\"\r\n" + "}";



    }
}

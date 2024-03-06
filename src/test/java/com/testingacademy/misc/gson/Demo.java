package com.testingacademy.misc.gson;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.testng.annotations.Test;
import com.google.gson.Gson;
import java.security.PublicKey;

public class Demo {

    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;

    @Test
    public void testPost(){

        Faker faker = new Faker();
        Booking booking = new Booking();
        String expectFirstName = faker.name().firstName();


        booking.setFirstname(expectFirstName);
        booking.setLastname("Hadkar");
        booking.setTotalprice(112);
        booking.setDepositpaid(true);

        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2024-02-01");
        bookingdates.setCheckout("2024-02-01");
        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Breakfast");

        System.out.println(booking);
        // Object -> JSON String (GSON)
        Gson gson = new Gson();
        String jsonStringBooking =  gson.toJson(booking);
        System.out.println(jsonStringBooking);

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(jsonStringBooking).log().all();

        Response response = requestSpecification.when().post();

        Integer bookingID = response.then().extract().path("bookingid");

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
        System.out.println("Your Booking ID -->" +bookingID);
    }
}

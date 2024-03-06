package com.testingacademy.misc.gson;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

public class PostReqTC {
    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    @Test
    public void testPositive(){

Booking booking = new Booking();
Faker faker = new Faker();
String expectFirstname = faker.name().firstName();
booking.setFirstname(expectFirstname);
booking.setLastname("Hadkar");
booking.setTotalprice(200);
booking.setDepositpaid(true);

        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2024-02-01");
        bookingdates.setCheckout("2024-02-01");
        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Breakfast");

        System.out.println(booking);

        Gson gson = new Gson();
        String jsonStringBooking = gson.toJson(booking);
        System.out.println(jsonStringBooking);

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(jsonStringBooking).log().all();

        Response response = requestSpecification.when().post();
        String jsonResponseString = response.asString();
           BookingResponse bookingResponseObject =     gson.fromJson(jsonResponseString, BookingResponse.class);

           assertThat(bookingResponseObject.getBookingid()).isNotNull();
        Assert.assertEquals(bookingResponseObject.getBooking().getFirstname(),expectFirstname);
        Integer bookingID = response.then().extract().path("bookingid");

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
assertThat(bookingResponseObject.getBooking().getFirstname()).isEqualTo(expectFirstname).isNotNull();
    }
}

package com.testingacademy.testng.ddt;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

public class ddt001 {

    @Test(dataProvider = "getData", dataProviderClass = UtilExcel.class)
    public void testLogin(String userName, String password){
        String payload = "{\n" +
                "  \"username\": \"" + userName + "\",\n" +
                "  \"password\": \"" + password + "\",\n" +
                "  \"remember\": false,\n" +
                "  \"recaptcha_response_field\": \"\"\n" +
                "}";

        RequestSpecification requestSpecification = RestAssured.given();

                requestSpecification.baseUri("https://app.vwo.com");
                requestSpecification.basePath("/login");
                requestSpecification.contentType(ContentType.JSON).log().all();
                requestSpecification.body(payload);

              Response response =requestSpecification.when().post();

              ValidatableResponse validatableResponse = response.then();
        String responseString = response.asString();
        System.out.println(responseString);

        validatableResponse.statusCode(200);

       Integer  id = response.then().extract().path("id");
        System.out.println(id);

        assertThat(id).isNotNull();



    }

}

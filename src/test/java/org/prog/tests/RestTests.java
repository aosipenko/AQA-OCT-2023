package org.prog.tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.prog.dto.SearchResultsDto;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class RestTests {

    @Test
    public void testRestRequest() {
//        RequestSpecification requestSpecification = RestAssured.given();
//        requestSpecification.queryParam("inc", "gender,name,nat");
//        requestSpecification.queryParam("noinfo");
//
//        Response response = requestSpecification.get("https://randomuser.me/api/");
//
//        ValidatableResponse validatableResponse = response.then();
//        validatableResponse.statusCode(200);
//        validatableResponse.contentType(ContentType.JSON);
//
//        response.body().prettyPrint();

//        RestAssured.baseURI = "https://randomuser.me/";
        ValidatableResponse validatableResponse = RestAssured
                .given()
                .queryParam("results", "3")
                //TODO: add check that coordinates (latitude and longitude) are not empty
// TODO:        .queryParam("inc", "gender,name,nat,location")
                .queryParam("inc", "gender,name,nat")
                .queryParam("noinfo")
                .get("https://randomuser.me/api/")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON);

        System.out.println(validatableResponse.extract().body().asPrettyString());

//        validatableResponse.body("results.gender", Matchers.hasItemInArray("female"));
        List<String> genders =
                validatableResponse.extract().body().jsonPath().get("results.gender");

        List<String> names =
                validatableResponse.extract().body().jsonPath().get("results.name.first");


        names.forEach(name -> System.out.println(name));
    }

    @Test
    public void restTestDto() {
        SearchResultsDto dto = RestAssured
                .given()
                .queryParam("results", "3")
                .queryParam("inc", "gender,name,nat")
                .queryParam("noinfo")
                .get("https://randomuser.me/api/")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract()
                .body()
                .as(SearchResultsDto.class);

        System.out.println(dto);
        Assert.assertTrue(dto
                .getResults()
                .stream()
                .anyMatch(personDto -> personDto.getGender().equals("male")));
    }
}

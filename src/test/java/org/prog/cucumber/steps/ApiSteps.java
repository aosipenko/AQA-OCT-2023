package org.prog.cucumber.steps;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.prog.dto.SearchResultsDto;

public class ApiSteps {

    @Given("I retrieve {int} random users with API")
    public void retrieveUsers(int amount){
        SqlSteps.searchResultsDto = RestAssured
                .given()
                .queryParam("results", amount)
                .queryParam("inc", "gender,name,nat")
                .queryParam("noinfo")
                .get("https://randomuser.me/api/")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract()
                .body()
                .as(SearchResultsDto.class);
    }
}

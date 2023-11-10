package org.prog.cucumber.steps;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.prog.dto.SearchResultsDto;
import org.prog.util.DataHolder;
import org.springframework.beans.factory.annotation.Autowired;

public class ApiSteps {

    @Autowired
    private DataHolder dataHolder;

    @Given("I retrieve {int} random users with API")
    public void retrieveUsers(int amount) {
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

    @Given("I retrieve {int} random users with API as {string}")
    public void retrieveUsersWithHolder(int amount, String alias) {
        SearchResultsDto dto = RestAssured
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

        dataHolder.put(alias, dto);
    }
}

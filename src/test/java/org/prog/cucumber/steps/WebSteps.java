package org.prog.cucumber.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.prog.pages.GooglePage;
import org.prog.pages.WikiPage;
import org.prog.util.DataHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;

import java.util.List;

public class WebSteps {

    @Autowired
    public GooglePage googlePage;

    @Autowired
    public WikiPage wikiPage;


    @Autowired
    private DataHolder dataHolder;

    public static String searchValue;

    @Given("I load google page")
    public void loadGooglePage() {
        googlePage.loadPage();
        googlePage.acceptCookiesIfPresent();
    }

    @When("I search for {string}")
    public void searchForBen(String value) {
        performSearch(value);
    }

    @When("I google for that person")
    public void performSearch() {
        performSearch(searchValue);
    }

    @When("I google for person {string}")
    public void performSearchFromHolder(String alias) {
        performSearch((String) dataHolder.get(alias));
    }

    @Then("I can see {string} in search results")
    public void checkSearchHeaders(String value) {
        verifySearchResults(value);
    }

    @Then("I see that persons name in search results")
    public void checkSearchHeaders() {
        verifySearchResults(searchValue);
    }

    @Then("I see that person {string} name in search results")
    public void checkSearchHeadersFromHolder(String alias) {
        verifySearchResults((String) dataHolder.get(alias));
    }

    private void performSearch(String value) {
        googlePage.setSearchValue(value);
        googlePage.performSearch();
    }

    private void verifySearchResults(String value) {
        List<String> headers = googlePage.getSearchResultHeaders();
        Assert.assertTrue(headers.stream().anyMatch(header -> header.contains(value)));
    }
}

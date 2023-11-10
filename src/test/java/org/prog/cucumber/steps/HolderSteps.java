package org.prog.cucumber.steps;

import io.cucumber.java.en.Then;
import org.prog.util.DataHolder;
import org.springframework.beans.factory.annotation.Autowired;

public class HolderSteps {

    @Autowired
    private DataHolder dataHolder;

    @Then("I check my holder {string}")
    public void checkDataHolder(String key) {
        System.out.println(dataHolder.get(key));
    }
}

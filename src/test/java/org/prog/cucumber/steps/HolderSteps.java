package org.prog.cucumber.steps;

import io.cucumber.java.en.Then;
import org.prog.util.DataHolder;

public class HolderSteps {

    @Then("I check my holder {string}")
    public void checkDataHolder(String key) {
        System.out.println(DataHolder.getInstance().get(key));
    }
}

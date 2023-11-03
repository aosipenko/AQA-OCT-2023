package org.prog.cucumber.steps;

import io.cucumber.java.en.Given;

public class ParallelSetSteps {

    @Given("i set static value to {string}")
    public void setValue(String value){
        ParallelPrintSteps.valueContainer.set(value);
    }
}

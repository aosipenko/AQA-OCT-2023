package org.prog.cucumber.steps;

import io.cucumber.java.en.Then;

import java.util.Random;

public class ParallelPrintSteps {

    public static ThreadLocal<String> valueContainer = new ThreadLocal<>();

    @Then("i print that value")
    public void printValue() throws InterruptedException {
        waitForRandomTime();
        System.out.println(">>>>>>>>>>>>" + valueContainer.get());
    }

    private void waitForRandomTime() throws InterruptedException {
        Random random = new Random();
        int sleepTime = random.nextInt(5) + 1;
        Thread.sleep(sleepTime * 1000);
    }
}

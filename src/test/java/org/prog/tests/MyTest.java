package org.prog.tests;

import org.testng.annotations.*;

public class MyTest {

    @BeforeSuite
    public void setUp() {
        System.out.println("this is the beginning");
    }

    @BeforeMethod
    public void beforeTest() {
        System.out.println("================================");
    }

    @Test(dataProvider = "buttonsAndBacks")
    public void smth2(String buttonColor, String backColor, String anotherColor) {
        System.out.println("i press " + buttonColor + " button");
        System.out.println("i check background is " + backColor);
    }

    @AfterMethod
    public void afterTest() {
        System.out.println("---------------------------");
    }

    @AfterSuite
    public void tearDown() {
        System.out.println("this is the end");
    }

    @DataProvider(name = "buttonsAndBacks")
    public static Object[][] primeNumbers() {
        return new Object[][]{
                {"red", "#red", "anotherColor"},
                {"blue", "#blue", "anotherColor"},
                {"green", "#green", "anotherColor"}
        };
    }
}

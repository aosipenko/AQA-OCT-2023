package org.prog.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AnotherTest {

    @BeforeMethod
    public void beforeTest() {
        System.out.println("================================");
    }

    @Test
//    @Severity(SeverityLevel.TRIVIAL)
    public void smth() {
        System.out.println("this is test");
    }

    @Test
//    @Severity(SeverityLevel.CRITICAL)
    public void smth2() {
        System.out.println("this is test");
    }

    @Test
//    @Severity(SeverityLevel.MINOR)
    public void smth3() {
        System.out.println("this is test");
    }

    @AfterMethod
    public void afterTest() {
        System.out.println("---------------------------");
    }

    //    @Step("This is some step")
    private void smth23() {
        System.out.println();
    }

}

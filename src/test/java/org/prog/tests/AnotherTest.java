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
    public void smth() {
        System.out.println("this is test");
    }

    @Test
    public void smth2() {
        System.out.println("this is test");
    }

    @Test
    public void smth3() {
        System.out.println("this is test");
    }

    @AfterMethod
    public void afterTest() {
        System.out.println("---------------------------");
    }

}

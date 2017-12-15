package com.cucumber.tests.homework;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;

public class Homework extends BaseSteps {

    @Before
    public void before() {
        startBrowser();
    }

    @After
    public void after() {
        stopWebDriver();
    }

    @Given("^the Bonusprint home page is open$")
    public void bp_Homepage_is_open() {
        driver.get("https://t-dtap.bonusprint.co.uk/");
        //wait.until(ExpectedConditions.elementToBeClickable(By.name("firstname")));
    }

}
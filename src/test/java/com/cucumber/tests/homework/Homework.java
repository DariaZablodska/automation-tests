package com.cucumber.tests.homework;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertTrue;

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
        driver.get("https://www.bonusprint.co.uk/");
    }


    @And("^I click on the My Account link$")
    public void bp_MyAccount_is_open() {

        WebElement MyAccount = driver.findElement(By.cssSelector("[data-title='My account']"));
        MyAccount.click();
    }

    @And("^I click on the Saved projects link$")
    public void bp_SavedProject_is_open() {
        WebElement SavedProject = driver.findElement(By.cssSelector("[data-tam='SecondSavedProjects']"));
        SavedProject.click();
        assertTrue(driver.getTitle().contains("Login"));
    }

}


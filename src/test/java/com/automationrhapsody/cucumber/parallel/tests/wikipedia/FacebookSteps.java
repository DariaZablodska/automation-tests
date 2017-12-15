package com.automationrhapsody.cucumber.parallel.tests.wikipedia;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import cucumber.api.java.en.And;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class FacebookSteps  extends BaseSteps {

    @Before
    public void before() {
        startBrowser();
    }

    @After
    public void after() {
        stopWebDriver();
    }

    @Given("^FB page is in open$")
    public void fb_Page_is_in_open() {
        driver.get("https://www.facebook.com/");
        //wait.until(ExpectedConditions.elementToBeClickable(By.name("firstname")));
    }


    @When("^I enter values (.*) and (.*)$")     //WITH PARAMETER
    public void i_enter_values(String firstName, String lastName) {
        driver.findElement(By.name("firstname")).sendKeys(firstName);
        driver.findElement(By.name("lastname")).sendKeys(lastName);
    }

    @Then("^I Should see the values$")
    public void i_Should_see_the_values() {
        System.out.println("ACTUAL VALUE: " + driver.findElement(By.name("firstname")).getAttribute("value"));
        Assert.assertEquals(driver.findElement(By.name("firstname")).getAttribute("value").isEmpty(), false);

    }

    @And("^I enter email address (.*)")
    public void i_enter_email(String email) {
        driver.findElement(By.name("reg_email__")).sendKeys(email);

    }

    @And("^I reenter email address (.*)")
    public void i_reenter_email(String reemail) {
        driver.findElement(By.name("reg_email_confirmation__")).sendKeys(reemail);

    }

    @And("^I enter new password (.*)")
    public void i_enter_password(String password) {
        driver.findElement(By.name("reg_passwd__")).sendKeys(password);
    }

    @And("^I select month (.*)")
    public void i_select_date(String month) {
        Select dropdown = new Select(driver.findElement(By.id("month")));
        dropdown.selectByIndex(1);
    }

    @And("^I select day (.*)")
    public void i_select_day(String day) {
        Select dropdown = new Select(driver.findElement(By.id("day")));
        dropdown.selectByValue("4");
    }

    @And("^I select year (.*)")
    public void i_select_year(String year) {
        Select dropdown = new Select(driver.findElement(By.id("year")));
        dropdown.selectByValue("2000");
    }

    @And("^I select gender (.*)")
    public void i_select_gender(String female) {
        WebElement Female = driver.findElement(By.cssSelector("input[name='sex']"));
        Female.click();

    }

    @Then("^I press (.*) button")
    public void i_press_button(String createAccount) {
        WebElement CreateAccount = driver.findElement(By.cssSelector("[name='websubmit']"));
        CreateAccount.click();


    }

}

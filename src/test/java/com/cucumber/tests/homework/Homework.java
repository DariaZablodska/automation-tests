package com.cucumber.tests.homework;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.junit.Assert.assertTrue;

public class Homework extends BaseSteps {

    private UserConfig userConfig;

    @Before
    public void before() {
        userConfig = new UserConfig();
        userConfig.init(getClass().getResourceAsStream("tests.properties"));
        startBrowser();
    }

    @After
    public void after() {
        stopWebDriver();
    }

    @Given("^the Bonusprint home page is open$")
    public void homepageIsOpen() {
        driver.get("https://www.bonusprint.co.uk/");
    }


    @And("^I click on the My Account link$")
    public void myAccountIsOpen() {
        driver.findElement(By.cssSelector("[data-dropdown='menu-authentication-navigation']")).click();
    }

    @And("^I click on the Saved projects link$")
    public void savedProjectIsOpen() {
        Actions actions = new Actions(driver);
        WebElement savedProjects = driver.findElement(By.cssSelector("[data-title='My account']"));
        actions.moveToElement(savedProjects).build().perform();
        driver.findElement(By.linkText("Saved projects")).click();
    }

    @Then("^I expect to see the login form$")
    public void loginFormIsOpen() {
        assertTrue(driver.getTitle().contains("Login"));
    }

    @When("^I click on the login link$")
    public void clickLoginLink() {
        driver.findElement(By.cssSelector("[data-tam='authenticationSecondaryMenuLogInLink']")).click();
    }

    @When("^I click on the continue as new customer button$")
    public void newCustomerButton() {
        driver.findElement(By.cssSelector("a.extra-small")).click();

    }

    @Then("^I  expect to see the create account form$")
    public void accountFormIsOpen() {
        assertTrue(driver.getTitle().contains("Customer Register"));
    }

    @When("^I am logging in$")
    public void credentials() {
        driver.findElement(By.cssSelector("#Email")).sendKeys(UserConfig.username);
        driver.findElement(By.cssSelector("#Password")).sendKeys(UserConfig.password);

        driver.findElement(By.cssSelector("input.extra-small")).click();
    }

    @Then("^I enter credentials email (.*) and password (.*)$")
    public void enterCredentials(String email, String password) {
        driver.findElement(By.cssSelector("#Email")).sendKeys(email);
        driver.findElement(By.cssSelector("#Password")).sendKeys(password);
        driver.findElement(By.cssSelector("#ConfirmPassword")).sendKeys(password);
    }

    @Then("^I expect to see the My accounts section$")
    public void accountSection() {
        assertTrue(driver.getTitle().contains("My Account"));
    }

    @Then("^I expect to see the Saved projects$")
    public void savedProjects() {
        assertTrue(driver.getTitle().contains("Saved projects"));
    }

    @And("^I click register$")
    public void register() {
        driver.findElement(By.cssSelector(".extra-small")).click();
    }
}

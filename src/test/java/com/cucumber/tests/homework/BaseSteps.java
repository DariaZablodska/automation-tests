package com.cucumber.tests.homework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.util.Properties;

public class BaseSteps {

    private static final String WEB_DRIVER_FOLDER = "webdrivers";

    protected WebDriver driver;

    protected void startWebDriver() {
        Properties props = System.getProperties();
        props.setProperty("webdriver.gecko.driver",
            driversFolder(new File("").getAbsolutePath()) + "geckodriver");
        driver = new FirefoxDriver();
        //driver.navigate().to("http://en.wikipedia.org");
    }

    protected void startBrowser() {
        Properties props = System.getProperties();
        props.setProperty("webdriver.gecko.driver",
                driversFolder(new File("").getAbsolutePath()) + "geckodriver");
        driver = new FirefoxDriver();
        //driver.navigate().to("http://en.wikipedia.org");
    }

    protected void stopWebDriver() {
        driver.quit();
    }

    protected void wait(int timeOutInSeconds) {
        try {
            Thread.sleep(timeOutInSeconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static String driversFolder(String path) {
        File file = new File(path);
        for (String item : file.list()) {
            if (WEB_DRIVER_FOLDER.equals(item)) {
                return file.getAbsolutePath() + "/" + WEB_DRIVER_FOLDER + "/";
            }
        }
        return driversFolder(file.getParent());
    }
}

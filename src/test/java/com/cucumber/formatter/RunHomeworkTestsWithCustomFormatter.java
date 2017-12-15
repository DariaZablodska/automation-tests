package com.cucumber.formatter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    plugin = {"CustomFormatter:custom-formatter-output.txt"},
    features = {"classpath:com/cucumber/tests/homework"},
    glue = {"com.cucumber.tests"},
    tags = {"~@ignored"}
)
public class RunHomeworkTestsWithCustomFormatter {
}

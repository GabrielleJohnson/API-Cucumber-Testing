package com.testing.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.testing.utils",
        plugin = {
                "pretty",
                "json:target/cucumber/cucumber.json",
                "html:target/cucumber/cucumber.html"
        }
)
public class TestRunner extends AbstractTestNGCucumberTests {

}
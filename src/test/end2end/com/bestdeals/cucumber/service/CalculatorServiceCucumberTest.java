package com.bestdeals.cucumber.service;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(format = {"pretty", "html:target/cucumber/calculator/service"},
        features = "classpath:features/calculator/service",
        glue = "com/bestdeals/cucumber/service"

)
public class CalculatorServiceCucumberTest {

}

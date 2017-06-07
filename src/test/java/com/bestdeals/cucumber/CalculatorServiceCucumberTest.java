package com.bestdeals.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(format = {"pretty", "html:target/cucumber/calculator"},
        features = "classpath:features",
        glue = "com/bestdeals"

)
public class CalculatorServiceCucumberTest {

}

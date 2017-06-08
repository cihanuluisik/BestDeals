package com.bestdeals.cucumber.end2end;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(format = {"pretty", "html:target/cucumber/calculator/end2end"},
        features = "classpath:features/calculator/end2end",
        glue = "com/bestdeals/cucumber/end2end"

)
public class CalculateByRestServiceCucumberTest {

}

package com.bestdeals.cucumber.end2end.all;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(format = {"pretty", "html:target/cucumber/calculator/end2end/all"},
        features = "classpath:features/calculator/end2end/all",
        glue = "com/bestdeals/cucumber/end2end/all"

)
public class CalculateAllByRestServiceCucumberTest {

}

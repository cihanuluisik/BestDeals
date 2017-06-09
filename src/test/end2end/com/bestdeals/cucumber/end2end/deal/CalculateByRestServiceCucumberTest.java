package com.bestdeals.cucumber.end2end.deal;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(format = {"pretty", "html:target/cucumber/calculator/end2end/deal"},
        features = "classpath:features/calculator/end2end/deal",
        glue = "com/bestdeals/cucumber/end2end/deal"

)
public class CalculateByRestServiceCucumberTest {

}

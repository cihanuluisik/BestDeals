package com.bestdeals.cucumber.end2end;

import com.bestdeals.ReturnCalculatorApplication;
import com.bestdeals.returns.domain.Deal;
import com.bestdeals.returns.domain.Interval;
import com.bestdeals.returns.endpoint.CalculateParams;
import com.bestdeals.returns.endpoint.builder.CalculateParamsBuilder;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( classes = ReturnCalculatorApplication.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CalculateByRestServiceSteps {


    @Autowired
    private TestWebClient testWebClient;

    @Autowired
    private CalculateParamsBuilder calculateParamsBuilder;


    @When("^I call calculator webservice with ([^\"]*) ([^\"]*) amount$")
    public void iCallCalculatorServiceWithCurrencyAmountAmount(String currency, BigDecimal amount) throws Throwable {
        calculateParamsBuilder.withCurrency(currency).withAmount(amount);
    }

    @And("^annual rate ([^\"]*)$")
    public void annualRateRate(Double rate) throws Throwable {
        calculateParamsBuilder.withRate(rate);
    }

    @And("^for ([^\"]*) years period$")
    public void forPeriodYearsPeriod(Integer period) throws Throwable {
        calculateParamsBuilder.withPeriod(period);
    }

    @And("^by ([^\"]*) compound interval$")
    public void withIntervalCompoundInterval(Interval interval) throws Throwable {
        calculateParamsBuilder.withInterval(interval);
    }

    @Then("^the webservice should calculate to ([^\"]*) USD return for ([^\"]*) interest deal$")
    public void theWebserviceShouldCalculateToUsdReturnUSDReturnForDealInterestDeal(BigDecimal usdReturn, Deal deal) throws Throwable {
        calculateParamsBuilder.withDeal(deal);
        CalculateParams calculateParams = calculateParamsBuilder.build();

        BigDecimal calculatedReturn = testWebClient.callCalculate(calculateParams, BigDecimal.class,"/calculate");
        assertThat(calculatedReturn.doubleValue()).isEqualTo(usdReturn.doubleValue());
    }

}

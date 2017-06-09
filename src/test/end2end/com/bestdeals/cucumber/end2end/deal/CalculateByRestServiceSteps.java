package com.bestdeals.cucumber.end2end.deal;

import com.bestdeals.ReturnCalculatorApplication;
import com.bestdeals.cucumber.end2end.TestWebClient;
import com.bestdeals.returns.domain.Deal;
import com.bestdeals.returns.domain.builder.DealBuilder;
import com.bestdeals.returns.domain.enums.DealType;
import com.bestdeals.returns.domain.enums.IntervalType;
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
    private DealBuilder dealBuilder;


    @When("^I call calculator webservice with ([^\"]*) ([^\"]*) amount$")
    public void iCallCalculatorServiceWithCurrencyAmountAmount(String currency, BigDecimal amount) throws Throwable {
        dealBuilder.withCurrency(currency).withAmount(amount);
    }

    @And("^annual rate ([^\"]*)$")
    public void annualRateRate(Double rate) throws Throwable {
        dealBuilder.withRate(rate);
    }

    @And("^for ([^\"]*) years period$")
    public void forPeriodYearsPeriod(Integer period) throws Throwable {
        dealBuilder.withPeriod(period);
    }

    @And("^by ([^\"]*) compound interval$")
    public void withIntervalCompoundInterval(IntervalType intervalType) throws Throwable {
        dealBuilder.withInterval(intervalType);
    }

    @Then("^the webservice should calculate to ([^\"]*) USD return for ([^\"]*) interest deal$")
    public void theWebserviceShouldCalculateToUsdReturnUSDReturnForDealInterestDeal(BigDecimal usdReturn, DealType dealType) throws Throwable {
        dealBuilder.withDeal(dealType);
        Deal deal = dealBuilder.build();

        BigDecimal calculatedReturn = testWebClient.callCalculate("/calculate", deal);
        assertThat(calculatedReturn.doubleValue()).isEqualTo(usdReturn.doubleValue());
    }


}

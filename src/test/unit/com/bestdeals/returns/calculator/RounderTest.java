package com.bestdeals.returns.calculator;

import com.bestdeals.returns.service.calculator.Rounder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Parameterized.class)
public class RounderTest {

    private Rounder rounder;

    public RounderTest(double given, double rounded) {
        this.given = given;
        this.rounded = rounded;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { 0.124, 0.12}, { 0.1249, 0.12}, { 0.125, 0.13 },{ 0.1250, 0.13 }, {0.126, 0.13 }
        });
    }

    @Before
    public void setUp() throws Exception {
        rounder = new Rounder();
    }

    private double given, rounded;

    @Test
    public void givenADoubleWhenRoundedThenReturnsExpected() {
        assertThat(rounder.roundTo2Decimal(BigDecimal.valueOf(given))).isEqualTo(BigDecimal.valueOf(rounded));
    }

}
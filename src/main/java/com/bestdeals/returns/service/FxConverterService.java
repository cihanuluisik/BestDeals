package com.bestdeals.returns.service;

import com.bestdeals.returns.repository.FxRateRepository;
import com.bestdeals.returns.service.validator.CurrencyValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

import static com.bestdeals.returns.service.validator.CurrencyValidator.ERR_MSG_CURRENCY_IS_NOT_FOUND;

@Service
public class FxConverterService {

    public static final String UNIT_CURRENCY ="USD";

    private final FxRateRepository  fxRateRepository;
    private final CurrencyValidator currencyValidator;

    @Autowired
    public FxConverterService(FxRateRepository fxRateRepository, CurrencyValidator currencyValidator) {
        this.fxRateRepository = fxRateRepository;
        this.currencyValidator = currencyValidator;
    }

    public BigDecimal convertToUsd(String currency, BigDecimal amount){
        currencyValidator.validateCurrency(currency, amount);
        BigDecimal fxRate =  getRate(currency);
        return amount.multiply(fxRate);
    }

    private BigDecimal getRate(String currency) {

        switch (currency) {
            case UNIT_CURRENCY:
                return BigDecimal.ONE;
            default:
                return fxRateRepository.findByCurrencyAndDate(currency, LocalDate.now())
                        .orElseThrow(() -> new RuntimeException(ERR_MSG_CURRENCY_IS_NOT_FOUND))
                        .getRate();
        }
    }

}

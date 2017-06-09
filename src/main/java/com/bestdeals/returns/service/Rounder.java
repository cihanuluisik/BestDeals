package com.bestdeals.returns.service;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class Rounder {

    public BigDecimal roundTo2Decimal(BigDecimal amount){
        return amount.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

}

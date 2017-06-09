package com.bestdeals.returns.domain;

import com.bestdeals.returns.domain.enums.DealType;
import com.bestdeals.returns.domain.enums.IntervalType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Deal {

    @Id
    @GeneratedValue
    private Integer id;


    public Integer getClientId() {
        return clientId;
    }

    public DealType getDealType() {
        return dealType;
    }

    public String getCurrency() {
        return currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public IntervalType getIntervalType() {
        return intervalType;
    }

    public Double getRate() {
        return rate;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    private Integer      clientId;
    private DealType     dealType;
    private String       currency;
    private BigDecimal   amount;
    private IntervalType intervalType;
    private Double       rate;
    private Integer      period;


}

package com.bestdeals.returns.domain.enums;

public enum DealType {

    Simple("Simple Compound"), Annual("Annual Simple");

    private final String name;

    DealType(String name) {
        this.name = name;
    }


}

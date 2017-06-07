package com.bestdeals.returns.domain;

public enum Deal {

    Simple("Simple Compound"), Annual("Annual Simple");

    private final String name;

    Deal(String name) {
        this.name = name;
    }


}

package com.prado.paulo.FinanceFlow.domain.category.model;

public enum CategoryType {

    INCOME("INCOME"),
    EXPENSE("EXPENSE");

    private String type;

    CategoryType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}

package org.example.api.service.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class BankInfo implements Serializable {

    private String name;

    private BigDecimal balance;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}

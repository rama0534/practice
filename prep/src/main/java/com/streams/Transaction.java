package com.streams;

import java.util.Objects;

public class Transaction {
    private final String date;
    private final double amount;

    public Transaction(String date, double amount) {
        this.date = date;
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public String getData() {
        return date;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if (!(obj instanceof  Transaction)) return false;
        Transaction t = (Transaction) obj;
        return Objects.equals(date, t.date) &&
                amount == t.amount;
    }
    @Override
    public int hashCode() {
        return Objects.hash(date, amount);
    }
}

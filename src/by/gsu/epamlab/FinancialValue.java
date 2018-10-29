package by.gsu.epamlab;

import java.util.Currency;
import java.util.Objects;

public class FinancialValue {

    private Currency currency; // = Currency.getInstance("BYR");
    private long amount;

    public FinancialValue() {
    }

    public FinancialValue(long amount, String codeCurrency) {
        createCurrency(codeCurrency);
        this.amount = amount;
    }

    private void createCurrency(String codeCurrency) {
        if (codeCurrency.equals("BYN")) {
            this.currency = Currency.getInstance("BYR");
        } else {
            this.currency = Currency.getInstance(codeCurrency);
        }
    }

    public FinancialValue(double amount, String codeCurrency) {
        this(amount);
        createCurrency(codeCurrency);

    }

    public FinancialValue(long amount) {
        this.amount = amount;
    }

    public FinancialValue(double amount) {
        this.amount = floor(amount);
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public void setAmount(double amount) {
        this.amount = floor(amount);
    }

    public static long floor(double amount) {
        return (int) Math.floor(amount);
    }

    @Override
    public String toString() {
        if (currency.getSymbol().equals("BYR")) {
            return amount + " " + "BYN";
        } else {
            return amount + " " + currency;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FinancialValue financialValue = (FinancialValue) o;
        return amount == financialValue.amount &&
                Objects.equals(currency, financialValue.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currency, amount);
    }

    private int compareToTotal(FinancialValue o) {
        if (amount < o.amount)
            return -1;
        if (amount == o.getAmount())
            return 0;
        return 1;
    }

    public boolean greaterThan(FinancialValue o) {
        return (compareToTotal(o) > 0);
    }


}

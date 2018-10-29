package by.gsu.epamlab;

import java.util.Currency;
import java.util.Locale;
import java.util.Objects;

public class FinancialValue {

    private Currency currency = Currency.getInstance("BYR");
    private long total;

    public FinancialValue() {
    }

    public FinancialValue(long total, String locale) {
        createCurrency(locale);
        this.total = total;
    }

    private void createCurrency(String locale) {
        if (locale.equals("BYN")) {
            this.currency = Currency.getInstance("BYR");
        } else {
            this.currency = Currency.getInstance(locale);
        }
    }

    public FinancialValue(double total, String locale) {
        this(total);
        createCurrency(locale);

    }

    public FinancialValue(long total) {
        this.total = total;
    }

    public FinancialValue(double total) {
        this.total = floor(total);
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public void setTotal(double total) {
        this.total = floor(total);
    }

    public static long floor(double total) {
        return (int) Math.floor(total);
    }

    @Override
    public String toString() {
        if (currency.getSymbol().equals("BYR")) {
            return total + " " + "BYN";
        } else {
            return total + " " + currency;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FinancialValue financialValue = (FinancialValue) o;
        return total == financialValue.total &&
                Objects.equals(currency, financialValue.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currency, total);
    }

    private int compareTo(FinancialValue o) {
        if (total < o.total)
            return -1;
        if (total == o.getTotal())
            return 0;
        return 1;
    }

    public boolean greaterThan(FinancialValue o) {
        return (compareTo(o) > 0);
    }


}

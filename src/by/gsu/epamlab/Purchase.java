package by.gsu.epamlab;

import java.util.Objects;
import java.util.Scanner;

public class Purchase {
    private String name;
    private int units;
    private FinancialValue price = new FinancialValue(0, "BYN");

    //region Constructors
    public Purchase() {
    }

    public Purchase(String name, long total, int units) {
        this.name = name;
        this.price.setAmount(total);
        this.units = units;
    }

    public Purchase(Scanner scanner) {
        name = scanner.next();
        price.setAmount(scanner.nextLong());
        units = scanner.nextInt();
    }
    //endregion

    //region Getters
    public String getName() {
        return name;
    }

    public FinancialValue getPrice() {
        return price;
    }

    public int getUnits() {
        return units;
    }

     //endregion

    public FinancialValue getCost() {
        return new FinancialValue(units * price.getAmount(), "BYN");
    }

    protected String fieldsToString() {
        return "name='" + name + '\'' +
                "; price=" + price +
                "; units=" + units;
    }

    @Override
    public String toString() {
        return fieldsToString() +
                "; cost=" + getCost();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Purchase)) return false;
        Purchase purchase = (Purchase) o;
        return Objects.equals(name, purchase.name) &&
                Objects.equals(price, purchase.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}

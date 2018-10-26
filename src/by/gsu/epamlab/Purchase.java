package by.gsu.epamlab;

import java.util.Objects;
import java.util.Scanner;

public class Purchase {
    private String name;
    private double price;
    private int units;
//    private static final String IDENTIFICATOR = "GENERAL_PURCHASE";

    //region Constructors
    public Purchase() {
//        name = "nothing";
//        price = 0;
    }

    public Purchase(String name, double price, int units) {
        this.name = name;
        this.price = price;
        this.units = units;
    }

    public Purchase(Scanner scanner) {
        name = scanner.next();
        price = scanner.nextDouble();
        units = scanner.nextInt();
    }
    //endregion

    //region Getters
    public String getName() { return name; }

    public double getPrice() {
        return price;
    }

    public int getUnits() {
        return units;
    }

    //endregion

    public double getCost(){
        return units * price;
    }

    protected String fieldsToString(){
        return "name='" + name + '\'' +
                "; price=" + price +
                "; units=" + units;
    }

    @Override
    public String toString() {
        return  fieldsToString() +
                "; cost=" + getCost();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Purchase)) return false;
        Purchase purchase = (Purchase) o;
        return Double.compare(purchase.price, price) == 0 &&
                Objects.equals(name, purchase.name);
    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(name, price);
//    }
}

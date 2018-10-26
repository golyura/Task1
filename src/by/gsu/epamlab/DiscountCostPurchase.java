package by.gsu.epamlab;

import java.util.Scanner;

public class DiscountCostPurchase extends Purchase {
    private double discountCost = 50;
    private final int count = 5;
//    private static final String IDENTIFICATOR = "SUBCLASS_AMOUNT_PURCHASE";

    public DiscountCostPurchase() {
    }

    public DiscountCostPurchase(String name, double price, int units) {
        super(name, price, units);
    }

    public DiscountCostPurchase(Scanner scanner) {
        super(scanner);
    }

    @Override
    public double getCost() {
        if (getUnits() > count) {
            return super.getCost() * (1 - discountCost / 100);
        }
        return super.getCost();
    }

    @Override
    public String toString() {
        return super.fieldsToString() + "; discountCost=" + discountCost
                + "; cost=" + getCost();
    }

    public double getDiscountCost() {
        return discountCost;
    }

    public void setDiscountCost(double discountCost) {
        this.discountCost = discountCost;
    }
}

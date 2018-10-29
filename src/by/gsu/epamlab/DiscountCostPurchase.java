package by.gsu.epamlab;

import java.util.Scanner;

public class DiscountCostPurchase extends Purchase {
    private double discountCost = 50.825;
    private final static int NUMBER_OF_PURCHASES = 5;

    public DiscountCostPurchase() {
    }

    public DiscountCostPurchase(String name, long price, int units) {
        super(name, price, units);
    }

    public DiscountCostPurchase(Scanner scanner) {
        super(scanner);
    }

    @Override
    public FinancialValue getCost() {
        if (getUnits() > NUMBER_OF_PURCHASES) {
           return new FinancialValue(super.getCost().getTotal() * (1 - discountCost / 100), "BYN");

        }
        return super.getCost();
    }

    @Override
    protected String fieldsToString() {
        return super.fieldsToString() + "; discountCost=" + discountCost +"%";
    }

    public double getDiscountCost() {
        return discountCost;
    }

    public void setDiscountCost(double discountCost) {
        this.discountCost = discountCost;
    }
}

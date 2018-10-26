package by.gsu.epamlab;

import java.util.Scanner;

public class DiscountPricePurchase extends Purchase {
    private double discountPrice;
//    private static final String IDENTIFICATOR = "SUBCLASS_DISCOUNT_PURCHASE";

    public DiscountPricePurchase() {
    }

    public DiscountPricePurchase(String name, double price, int units) {
        super(name, price, units);
    }

    public DiscountPricePurchase(Scanner scanner) {
        super(scanner);
    }

    @Override
    public double getCost() {
        return super.getCost() - discountPrice;
    }

    @Override
    public String toString() {
        return super.fieldsToString() + "; discountPrice=" + discountPrice
                + "; cost=" + getCost();
    }

    public double getDiscount() {
        return discountPrice;
    }

    public void setDiscount(double discount) {
        this.discountPrice = discount;
    }
}

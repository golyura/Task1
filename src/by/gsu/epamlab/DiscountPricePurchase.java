package by.gsu.epamlab;

import java.util.Scanner;

public class DiscountPricePurchase extends Purchase {

    private FinancialValue discountPrice = new FinancialValue(35);

    public DiscountPricePurchase() {
    }

    public DiscountPricePurchase(String name, long price, int units) {
        super(name, price, units);
    }

    public DiscountPricePurchase(Scanner scanner) {
        super(scanner);
    }

    @Override
    public FinancialValue getCost() {
        return new FinancialValue((getPrice().getTotal() - discountPrice.getTotal()) * getUnits(), "BYN");
    }

    @Override
    protected String fieldsToString() {
        return super.fieldsToString() + "; discountPrice=" + discountPrice;
    }

    public FinancialValue getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(FinancialValue discountPrice) {
        this.discountPrice = discountPrice;
    }
}

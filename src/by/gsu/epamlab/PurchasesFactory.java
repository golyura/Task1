package by.gsu.epamlab;

import java.util.Scanner;

public class PurchasesFactory {
    private enum PurchaseKind {
        GENERAL_PURCHASE,
        PRICE_PURCHASE,
        COST_PURCHASE;
    }

    public static Purchase getPurchaseFromFactory(Scanner sc) {
        String id = sc.next();
        PurchaseKind kind = PurchaseKind.valueOf(id);
        switch (kind) {
            case GENERAL_PURCHASE:
                return new Purchase(sc);
            case PRICE_PURCHASE:
                return new DiscountPricePurchase(sc);
            case COST_PURCHASE:
                return new DiscountCostPurchase(sc);
            default:
                throw new IllegalArgumentException();
        }


    }

}

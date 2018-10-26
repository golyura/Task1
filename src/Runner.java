import by.gsu.epamlab.DiscountCostPurchase;
import by.gsu.epamlab.DiscountPricePurchase;
import by.gsu.epamlab.Purchase;
import by.gsu.epamlab.PurchasesFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Runner {
    private Purchase[] purchases = new Purchase[6];

    public static void main(String[] args) {
//        Purchase purchase = new Purchase("Milk", 140, 3);
//        System.out.println(purchase);
//        DiscountPricePurchase discountPricePurchase = new DiscountPricePurchase("Milk", 140, 3);
//        discountPricePurchase.setDiscount(30);
//        System.out.println(discountPricePurchase);
//        DiscountCostPurchase discountCostPurchase = new DiscountCostPurchase("Milk", 140, 6);
//        discountCostPurchase.setDiscountCost(33);
//        System.out.println(discountCostPurchase);

        Runner runner = new Runner();
        int count = 0;
        double maxPrice = 0;
        boolean isPurchasesAreEqual = true;
        try {
//            Scanner scanner = new Scanner(new File("src/in.txt"));
            Scanner scanner = new Scanner(new File("src/testequals.txt"));
            while (scanner.hasNext()) {
                Purchase purchaseFromFile = PurchasesFactory.getPurchaseFromFactory(scanner);
                runner.purchases[count++] = purchaseFromFile;
                System.out.println(purchaseFromFile);
                if (maxPrice < purchaseFromFile.getPrice()) {
                    maxPrice = purchaseFromFile.getPrice();
                }
                if (count > 1) {
                    if(!runner.purchases[count - 2].equals(runner.purchases[count - 1])){
                        isPurchasesAreEqual = false;
                    }
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("maxPrice = " + maxPrice);
        System.out.println("isPurchasesAreEqual = " + isPurchasesAreEqual);


//        for (Purchase p: runner.purchases             ) {
//            System.out.println(p);
//        }

    }
}

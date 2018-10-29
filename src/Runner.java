import by.gsu.epamlab.DiscountCostPurchase;
import by.gsu.epamlab.DiscountPricePurchase;
import by.gsu.epamlab.Purchase;
import by.gsu.epamlab.PurchasesFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Currency;
import java.util.Locale;
import java.util.Scanner;

public class Runner {
    private static Purchase[] purchases = new Purchase[6];

    public static void main(String[] args) {
        Purchase maxCostPurchase = new Purchase();
        boolean isPurchasesAreEquals = true;
//        try(Scanner scanner = new Scanner(new File("src/testequals.txt"))) {
        try (Scanner scanner = new Scanner(new File("src/in.txt"))) {
            for (int i = 0; i < 6; i++) {
                Purchase purchaseFromFile = PurchasesFactory.getPurchaseFromFactory(scanner);
//                purchaseFromFile.getPrice().setCurrency(Currency.getInstance(Locale.US));
                purchases[i] = purchaseFromFile;

                System.out.println(purchaseFromFile);
                if(purchaseFromFile.getCost().greaterThan(maxCostPurchase.getCost())){
                    maxCostPurchase = purchaseFromFile;
                }
                if (i > 1) {
                    if (!purchases[i - 2].equals(purchases[i - 1])) {
                        isPurchasesAreEquals = false;
                    }
                }
            }
        }  catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("maxCostPurchase = " + maxCostPurchase);
        System.out.println("isPurchasesAreEquals = " + isPurchasesAreEquals);



//        Purchase purchase = new Purchase("Milk", 140, 3);
//        System.out.println(purchase);
//        DiscountPricePurchase discountPricePurchase = new DiscountPricePurchase("Milk", 140, 3);
////        discountPricePurchase.setDiscount(30);
//        System.out.println(discountPricePurchase);
//        DiscountCostPurchase discountCostPurchase = new DiscountCostPurchase("Milk", 140, 6);
////        discountCostPurchase.setDiscountCost(33);
//        System.out.println(discountCostPurchase);


//        Runner runner = new Runner();
//        int count = 0;
//        double maxCost = 0;
//        Purchase maxPurchase = new Purchase();
//        boolean isPurchasesAreEquals = true;
//
//        //            Scanner scanner = new Scanner(new File("src/testequals.txt"));
//        try (Scanner scanner = new Scanner(new File("src/in.txt"))) {
//            while (scanner.hasNext()) {
//                Purchase purchaseFromFile = PurchasesFactory.getPurchaseFromFactory(scanner);
//                runner.purchases[count++] = purchaseFromFile;
//                System.out.println(purchaseFromFile);
//                if (maxCost < purchaseFromFile.getCost().getTotal()) {
//                    maxCost = purchaseFromFile.getCost().getTotal();
//                    maxPurchase = purchaseFromFile;
//                }
//                if (count > 1) {
//                    if (!runner.purchases[count - 2].equals(runner.purchases[count - 1])) {
//                        isPurchasesAreEquals = false;
//                    }
//                }
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        System.out.println("maxPurchase: " + maxPurchase.toString());
//        System.out.println("isPurchasesAreEquals = " + isPurchasesAreEquals);


//        for (Purchase p: runner.purchases             ) {
//            System.out.println(p);
//        }

    }
}

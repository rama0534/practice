package org.opportune.codingProblems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PriceCheck {
    public static void main(String[] args) {
        System.out.println("Price check");
        List<String> products = Arrays.asList("eggs", "milk", "cheese");
        List<Double> productPrices = Arrays.asList(2.89, 3.29, 5.79);
        List<String> productSold = Arrays.asList("eggs", "eggs", "cheese", "milk");
        List<Double> soldPrice = Arrays.asList(2.89, 2.99, 5.97, 3.29);
        int errors = priceCheck(products, productPrices, productSold, soldPrice);
        System.out.println("Total errors in sales " + errors);
    }

    private static int priceCheck(List<String> products, List<Double> productPrices, List<String>  productSold, List<Double> soldPrice) {
        int totalErrors = 0;
        int n = productPrices.size();
        HashMap<String, Double> productActualPrices = new HashMap<>();
        for (int i = 0; i < n; i++) {
            productActualPrices.put(products.get(i), productPrices.get(i));
        }

        for (int i = 0; i < productSold.size(); i++) {
            String product = productSold.get(i);
            double actualPrice = productActualPrices.get(product);
            if (Double.compare(actualPrice, soldPrice.get(i)) != 0)   totalErrors++;
        }

        return totalErrors;
    }
}

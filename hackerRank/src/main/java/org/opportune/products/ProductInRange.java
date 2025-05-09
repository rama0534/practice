package org.opportune.products;

import org.json.JSONArray;
import org.json.JSONObject;
import org.opportune.APICall;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ProductInRange {
    public static void main(String[] args){
        System.out.println("Hello world");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter category");
        String category = scanner.next();
        System.out.println("Enter minimum Price");
        int minPrice = scanner.nextInt();
        System.out.println("Enter maximum Price");
        int maxPrice = scanner.nextInt();
        int totalMatchingProducts = getProducts(category, minPrice, maxPrice);
        System.out.println("There are total " + totalMatchingProducts + " products available from " + minPrice +" and " + maxPrice);
    }

    private static int getProducts(String category, int minPrice, int maxPrice) {
        int totalProduct = 0;
        int page = 1;
        int totalPages = 1;
        String url = "https://jsonmock.hackerrank.com/api/inventory?category";
        try {
            String encodedCategory = URLEncoder.encode(category, StandardCharsets.UTF_8);
            do {
                String urlString = String.format(url + "=%s&page=%d", encodedCategory, page);
                JSONObject jsonObject = APICall.getAPIResponse(urlString);
                totalPages = jsonObject.getInt("total_pages");
                JSONArray data = jsonObject.getJSONArray("data");
                if (!data.isEmpty()) {
                    for (int i = 0; i < data.length(); i++) {
                        JSONObject product = data.getJSONObject(i);
                        int price = product.getInt("price");
                        if (minPrice <= price && price <= maxPrice) {
                            totalProduct++;
                        }
                    }
                }
                page++;
            }while (page <= totalPages);

        } catch (RuntimeException | IOException e) {
            throw new RuntimeException(e);
        }

        return totalProduct;
    }

}

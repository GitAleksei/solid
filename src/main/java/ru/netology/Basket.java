package ru.netology;

import java.util.HashMap;
import java.util.Map;

public class Basket {
    private final Map<Integer, Product> basketOfProducts;
    private final Map<Integer, CountPrice> idCounts;

    public Basket() {
        basketOfProducts = new HashMap<>();
        idCounts = new HashMap<>();
    }

    public void put(Product product, Integer count) {
        if (basketOfProducts.containsKey(product.getId())) {
            idCounts.get(product.getId()).sumCount(count);
            idCounts.get(product.getId()).sumPrice(count * product.getPrice());
        } else {
            basketOfProducts.put(product.getId(), product);
            idCounts.put(product.getId(), new CountPrice(count, count * product.getPrice()));
        }
    }

    public double getSumPrice() {
        double sum = 0;

        for (CountPrice price : idCounts.values()) {
            sum += price.getPrice();
        }

        return sum;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(
                String.format("%24s%20s%20s%20s%20s%20s", "name:", "manufacturer:",
                        "countryOfOrigin:", "price:", "count:", "countPrice:"))
                .append("\n");
        int i = 1;
        for (Product product : basketOfProducts.values()) {
            result.append(String.format("%2d", i++))
                    .append(". ")
                    .append(product)
                    .append(idCounts.get(product.getId()))
                    .append("\n");
        }
        result.append(String.format("%104s%20.2f", "Total price:", getSumPrice()))
                .append("\n");
        return result.toString();
    }
}

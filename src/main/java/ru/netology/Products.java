package ru.netology;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Products {
    private List<Product> products;

    public Products(List<Product> products) {
        this.products = products;
    }

    public Products filter(Predicate<Product> predicate) {
        return new Products(products.stream()
                .filter(predicate)
                .collect(Collectors.toList()));
    }

    public Product get(int i) {
        return products.get(i);
    }

    public List<Product> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(String.format("%24s%20s%20s%20s", "name:", "manufacturer:", "countryOfOrigin:", "price:"))
                .append("\n");
        int i = 1;
        for (Product product : products) {
            result.append(String.format("%2d", i++))
                    .append(". ")
                    .append(product.toString())
                    .append("\n");
        }
        return result.toString();
    }
}

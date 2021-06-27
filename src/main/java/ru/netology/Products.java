package ru.netology;

import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Products {
    private List<Product> products;

    public Products(List<Product> products) {
        this.products = products;
        System.out.println(products.getClass());
    }

    public Products filter(Predicate<Product> predicate) {
        return new Products(products.stream()
                .filter(predicate)
                .collect(Collectors.toList()));
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        int i = 1;
        for (Product product : products) {
            result.append(i++)
                    .append(". ")
                    .append(product.toString())
                    .append("\n");
        }
        return result.toString();
    }
}

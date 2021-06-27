package ru.netology;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Product> productList = new LinkedList<>();
        productList.add(new Product("vacuum cleaner", "samsung",
                "South Korea", 11, 20));
        productList.add(new Product("phone", "samsung",
                "South Korea", 110, 200));
        Products products = new Products(productList);
        System.out.println(products);
        System.out.println(products.filter(e -> e.getName().equals("phone")));
    }
}

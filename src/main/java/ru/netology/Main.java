package ru.netology;

public class Main {
    public static void main(String[] args) {
        MyReader reader = new ReaderFromCSV("Products.csv");
        Products products = reader.read();
        System.out.println(products);
        System.out.println(products.filter(e -> e.getManufacturer().equals("Logitech")));
    }
}

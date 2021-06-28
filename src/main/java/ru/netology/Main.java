package ru.netology;

public class Main {
    public static void main(String[] args) {
//        ReaderFromCSV readerFromCSV = new ReaderFromCSV("Products.csv");
//        Products products = readerFromCSV.read();
        ReaderFromJSON readerFromJSON = new ReaderFromJSON("Products.json");
        Products products = readerFromJSON.read();
        System.out.println(products);
        System.out.println(products.filter(e -> e.getManufacturer().equals("Logitech")));
    }
}

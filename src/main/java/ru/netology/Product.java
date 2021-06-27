package ru.netology;

public class Product {
    private String name;
    private String manufacturer;
    private String countryOfOrigin;
    private double price;
    private int count;

    public Product(String name, String manufacturer, String countryOfOrigin, double price,
                   int count) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.countryOfOrigin = countryOfOrigin;
        this.price = price;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public double getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return String.format("%15s%15S%15s%15f", name, manufacturer, countryOfOrigin, price);
    }
}

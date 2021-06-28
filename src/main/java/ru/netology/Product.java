package ru.netology;

import com.opencsv.bean.CsvBindByName;

import java.io.Serializable;

public class Product implements Serializable {
    @CsvBindByName
    private String name;
    @CsvBindByName
    private String manufacturer;
    @CsvBindByName
    private String countryOfOrigin;
    @CsvBindByName
    private double price;
    @CsvBindByName
    private int count;

    public Product() {

    }

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

    public void setName(String name) {
        this.name = name;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return String.format("%20s%15s%15s%15.2f", name, manufacturer, countryOfOrigin, price);
    }
}

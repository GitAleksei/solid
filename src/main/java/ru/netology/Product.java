package ru.netology;

import com.opencsv.bean.CsvBindByName;

import java.io.Serializable;

public class Product implements Serializable {
    @CsvBindByName
    private int id;
    @CsvBindByName
    private String name;
    @CsvBindByName
    private String manufacturer;
    @CsvBindByName
    private String countryOfOrigin;
    @CsvBindByName
    private double price;

    public Product() {

    }

    public Product(int id, String name, String manufacturer, String countryOfOrigin, double price) {
        this.id = id;
        this.name = name;
        this.manufacturer = manufacturer;
        this.countryOfOrigin = countryOfOrigin;
        this.price = price;
    }

    public int getId() {
        return id;
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

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return String.format("%20s%20s%20s%20.2f", name, manufacturer, countryOfOrigin, price);
    }
}

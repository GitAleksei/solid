package ru.netology;

public class CountPrice {
    private int count;
    private double price;

    public CountPrice(int count, double price) {
        this.count = count;
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public double getPrice() {
        return price;
    }

    public void sumCount(int count) {
        this.count += count;
    }

    public void sumPrice(double price) {
        this.price += price;
    }

    @Override
    public String toString() {
        return String.format("%20d%20.2f", count, price);
    }
}

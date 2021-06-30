package ru.netology.bill;

import ru.netology.bill.tax_type.TaxTypeCountry;

import java.math.BigDecimal;

public class Bill {
    private BigDecimal amount;
    private TaxTypeCountry taxTypeCountry;

    public Bill(BigDecimal amount, TaxTypeCountry taxTypeCountry) {
        this.amount = amount;
        this.taxTypeCountry = taxTypeCountry;
    }

    @Override
    public String toString() {
        BigDecimal tax = taxTypeCountry.calculateTaxFor(amount);
        return "Bill:\n" +
                String.format("%40s%20.2f", "Total price without tax:", amount) +
                "\n" +
                String.format("%40s%20.2f", "Tax:", tax) +
                "\n" +
                String.format("%40s%20.2f", "Total price with tax:", amount.add(tax));
    }
}

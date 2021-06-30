package ru.netology.bill.tax_type;

import java.math.BigDecimal;

public class TaxTypeDe extends TaxTypeCountry{
    private final BigDecimal TAX_DE = new BigDecimal("0.19");

    @Override
    public BigDecimal calculateTaxFor(BigDecimal amount) {
        return amount.multiply(TAX_DE);
    }
}

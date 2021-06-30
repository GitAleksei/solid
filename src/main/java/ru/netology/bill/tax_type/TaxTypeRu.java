package ru.netology.bill.tax_type;

import java.math.BigDecimal;

public class TaxTypeRu extends TaxTypeCountry{
    private final BigDecimal TAX_RU = new BigDecimal("0.2");

    @Override
    public BigDecimal calculateTaxFor(BigDecimal amount) {
        return amount.multiply(TAX_RU);
    }
}

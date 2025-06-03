package ro.irian.labs.pizza.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Embeddable
public class CurrencyValue {

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "currency", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private CurrencyType currency;

    public CurrencyValue(Double price, CurrencyType currency) {
        this.price = price;
        this.currency = currency;
    }

    public CurrencyValue() {
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public CurrencyType getCurrency() {
        return currency;
    }

    public void setCurrency(CurrencyType currency) {
        this.currency = currency;
    }
}

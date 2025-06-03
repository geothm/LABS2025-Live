package ro.irian.labs.pizza.service.api;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import ro.irian.labs.pizza.domain.CurrencyType;

public class PizzaDTO {

    @NotNull
    @Pattern(regexp = "^[A-Za-z ]+$")
    private String name;

    @NotNull
    @Min(10)
    @Max(100)
    private Double price;

    private CurrencyType currency;

    public PizzaDTO() {
    }

    public PizzaDTO(String name, Double price, CurrencyType currency) {
        this.name = name;
        this.price = price;
        this.currency = currency;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

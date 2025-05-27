package ro.irian.labs.pizza.domain;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "pizza")
public class Pizza {

    @Id
    private Long id;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Embedded
    private CurrencyValue currencyValue;

    public Pizza() {}

    public Pizza(Long id, String name, Double price) {
        this.id = id;
        this.name = name;

        this.currencyValue = new CurrencyValue(price, CurrencyType.RON);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }



    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public CurrencyValue getCurrencyValue() {
        return currencyValue;
    }

    public void setCurrencyValue(CurrencyValue currencyValue) {
        this.currencyValue = currencyValue;
    }

    public boolean nameContains(String nameContains) {
        return name.toLowerCase()
                .contains(nameContains.toLowerCase());
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pizza pizza = (Pizza) o;
        return Objects.equals(id, pizza.id) && Objects.equals(name, pizza.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}

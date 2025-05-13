package ro.irian.labs.l2e2springbootproperties;

import java.util.Objects;

public class Pizza {

    private final Long id;
    private final String name;
    private final Double price;


    public Pizza(Long id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
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

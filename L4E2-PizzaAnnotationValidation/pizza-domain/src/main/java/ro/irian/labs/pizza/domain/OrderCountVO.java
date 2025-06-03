package ro.irian.labs.pizza.domain;

public interface OrderCountVO {
    Long getOrderNumber();     // Order.id
    Long getNumberOfPizzas();  // COUNT(p)
}

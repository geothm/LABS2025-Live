package ro.irian.labs.pizza.domain;

import java.time.LocalDateTime;

public interface OrderVO {
    Long          getId();   // Order.id
    LocalDateTime getOrderDate();
    String getCustomerName();
}

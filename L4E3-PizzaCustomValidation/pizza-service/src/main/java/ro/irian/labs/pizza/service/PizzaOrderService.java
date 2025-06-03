package ro.irian.labs.pizza.service;

import org.springframework.stereotype.Service;
import ro.irian.labs.pizza.domain.OrderCountVO;
import ro.irian.labs.pizza.domain.OrderJPARepository;
import ro.irian.labs.pizza.domain.OrderVO;
import ro.irian.labs.pizza.domain.PizzaOrder;

import java.util.List;

@Service
public class PizzaOrderService {

    private final OrderJPARepository repository;

    public PizzaOrderService(OrderJPARepository repository) {
        this.repository = repository;
    }

    public List<PizzaOrder> getOrdersContainingPizza(String pizzaName) {
        return repository.findOrdersByPizzaName(pizzaName);
    }

    public List<PizzaOrder> getAllOrders() {
        return repository.findAll();
    }

    public List<OrderVO> getOrderVOs() {
        return repository.findAllProjectedBy();
    }

    public List<OrderCountVO> getOrderCount() {
        return repository.findOrderPizzaCounts();
    }

}

package ro.irian.labs.pizza.web.lib;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ro.irian.labs.pizza.domain.PizzaOrder;
import ro.irian.labs.pizza.service.PizzaOrderService;

import java.util.List;

@RestController
@RequestMapping("pizza-order")
public class PizzaOrderController {

    private final PizzaOrderService pizzaOrderService;

    public PizzaOrderController(PizzaOrderService pizzaOrderService) {
        this.pizzaOrderService = pizzaOrderService;
    }

    @GetMapping
    public List<PizzaOrder> getPizzaOrdersContainingPizza(@RequestParam(required = false) String pizzaName) {
        return pizzaName != null ? pizzaOrderService.getOrdersContainingPizza(pizzaName) : pizzaOrderService.getAllOrders();
    }
}

package ro.irian.labs.pizza.web.lib;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import ro.irian.labs.pizza.domain.Pizza;
import ro.irian.labs.pizza.service.api.PizzaService;

import java.util.List;

@RestController
@RequestMapping("pizza")
public class PizzaController {

    public final PizzaService pizzaService;

    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @GetMapping()
    public List<Pizza> getAllPizza() {
        return pizzaService.getAllPizzas();
    }

    @GetMapping("/{pizzaId}")
    public Pizza getPizzaById(@PathVariable Long pizzaId) {
        return  pizzaService.getPizzaById(pizzaId);
    }

    @GetMapping("/filter")
    public List<Pizza> getPizzaNameContains(@RequestParam String nameContainsString) {
        return pizzaService.getPizzaByNameContains(nameContainsString);
    }

}

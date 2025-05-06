package ro.irian.labs.l1e3springservicedi;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Stream;

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
        return pizzaService.getPizzaById(pizzaId);
    }

    @GetMapping("/filter")
    public List<Pizza> getPizzaNameContains(@RequestParam String nameContainsString) {
        return pizzaService.getPizzaByNameContains(nameContainsString);
    }

}

package ro.irian.labs.l1e4springmultidi;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pizza")
public class PizzaController {

    public final List<PizzaService> pizzaService;

    public final PizzaService fastPizzaService;

    public PizzaController(List<PizzaService> pizzaService,
                           PizzaService fastPizzaService) {
        this.pizzaService = pizzaService;
        this.fastPizzaService = fastPizzaService;
    }

    @GetMapping()
    public List<Pizza> getAllPizza() {
        return pizzaService.stream()
                .flatMap(pizzaServiceVar -> pizzaServiceVar.getAllPizzas().stream())
                .toList();
    }

    @GetMapping("/{pizzaId}")
    public Pizza getPizzaById(@PathVariable Long pizzaId) {
        return  pizzaService.stream()
                .flatMap(pizzaServiceVar -> pizzaServiceVar.getAllPizzas().stream())
                .filter(pizza -> pizza.getId().equals(pizzaId))
                .findFirst()
                .orElse(null);
    }

    @GetMapping("/filter")
    public List<Pizza> getPizzaNameContains(@RequestParam String nameContainsString) {
        return pizzaService.stream()
                .flatMap(pizzaServiceVar -> pizzaServiceVar.getPizzaByNameContains(nameContainsString).stream())
                .toList();
    }

    @GetMapping("/fast/{pizzaId}")
    public Pizza getFastPizzaById(@PathVariable Long pizzaId) {
        return fastPizzaService.getPizzaById(pizzaId);
    }
}

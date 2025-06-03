package ro.irian.labs.pizza.web.lib;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ro.irian.labs.pizza.domain.Pizza;
import ro.irian.labs.pizza.service.api.PizzaDTO;
import ro.irian.labs.pizza.service.api.PizzaService;

import java.net.URI;
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
    public List<Pizza> getPagedPizza(@RequestParam String nameContainsString) {
        return pizzaService.getPizzaByNameContains(nameContainsString);
    }

    @GetMapping("/paged")
    public Page<Pizza> getPagedPizza(Pageable pageable) {
        return pizzaService.getPagedPizzas(pageable);
    }

    @PostMapping
    public ResponseEntity<?> savePizza(@RequestBody @Valid PizzaDTO pizzaDTO) {
        Long id = pizzaService.savePizza(pizzaDTO);

        URI location = URI.create("/pizza/" + id);

        return ResponseEntity.created(location).build();
    }

}

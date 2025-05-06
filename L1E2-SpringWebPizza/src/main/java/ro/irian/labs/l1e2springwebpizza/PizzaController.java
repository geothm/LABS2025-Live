package ro.irian.labs.l1e2springwebpizza;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("pizza")
public class PizzaController {

    @GetMapping()
    public List<String> getAllPizza() {
        return List.of("Salami", "Prosciutto", "Capriciosa");
    }

    @GetMapping("/{pizzaName}")
    public String getPizzaByName(@PathVariable String pizzaName) {
        return Stream.of("Salami", "Prosciutto", "Capriciosa")
                .filter(pizza -> pizza.equalsIgnoreCase(pizzaName))
                .findFirst()
                .orElse("Pizza not found");
    }

    @GetMapping("/filter")
    public List<String> getPizzaNameContains(@RequestParam String nameContains) {
        return Stream.of("Salami", "Prosciutto", "Capriciosa")
                .filter(pizza -> pizza.toLowerCase().contains(nameContains.toLowerCase()))
                .toList();
    }

}

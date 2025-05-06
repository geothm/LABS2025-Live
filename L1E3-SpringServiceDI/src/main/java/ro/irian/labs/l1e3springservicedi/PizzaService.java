package ro.irian.labs.l1e3springservicedi;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaService {

    private List<Pizza> pizzas;

    @PostConstruct
    private void init(){
        pizzas = List.of(
                new Pizza(1L, "Salami"),
                new Pizza(2L, "Prosciutto"),
                new Pizza(3L, "Capriciosa")
        );
    }

    public List<Pizza> getAllPizzas(){
        return pizzas;
    }

    public Pizza getPizzaById(Long id){
        return pizzas.stream()
                .filter(pizza -> pizza.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<Pizza> getPizzaByNameContains(String nameContainsString){
        return pizzas.stream()
                .filter(pizza -> pizza.nameContains(nameContainsString))
                .toList();
    }
}
